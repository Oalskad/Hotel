/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;


import Model.ServiceDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iba
 */
public class ServiceDAO {
//    public ServiceDTO login(String userName, String password) {
//        ServiceDTO ServiceDTO = null;
//        String sql = "select username, password from [dbo].[User]"
//                + " where username = ? and password = ?  ";
//        try {
//            Connection conn = DBUtils.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ps.setString(1, userName);
//            ps.setString(2, password);
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                ServiceDTO = new ServiceDTO();
//                ServiceDTO.setUserName(rs.getString("username"));
//                ServiceDTO.setUserName(rs.getString("password"));
//                return ServiceDTO;
//            }
//        } catch (Exception ex) {
//            System.out.println("Query admin error!" + ex.getMessage());
//        }
//        return ServiceDTO;
//    }

    //Override method insert
    public boolean insert(ServiceDTO serviceDTO) {
        String sql = "INSERT INTO [dbo].[Service](servID, servName, price, desc, empID)"
                + " values(?, ?, ?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);

        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, serviceDTO.getUserID());
//            ps.setString(2, serviceDTO.getUserName());
//            ps.setString(3, serviceDTO.getPassword());
//            ps.setString(4, serviceDTO.getFname());
//            ps.setString(5, serviceDTO.getLname());
//            ps.setDate(6, serviceDTO.getDayOfBirth());
//            ps.setInt(7, serviceDTO.getVisitFrequency());
//            ps.setString(8, serviceDTO.getPhoneNumber());
//            ps.setString(9, serviceDTO.getEmail());
//            ps.setString(10, serviceDTO.getGender());
            
            
            ps.setString(1, serviceDTO.getServID());
            ps.setString(2, serviceDTO.getServName());
            ps.setDouble(3, serviceDTO.getPrice());
            ps.setString(4, serviceDTO.getDesc());
            ps.setString(5, serviceDTO.getEmployeeDTO().getEmployeeID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insert Service error!" + ex.getMessage());
        }

        return false;
    }

    // Override method delete dua tren username
    public boolean delete(ServiceDTO t) {

        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from [dbo].[Service] "
                    + " WHERE servID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getServID());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            DBUtils.closeConnection(con);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ServiceDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE [dbo].[Service] "
                    + " SET "
                    + ",    servName = ?"
                    + ",    price = ?"
                    + ",    desc = ?"
                    + ",    empID = ?"
                    + "WHERE servID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getServName());
            st.setDouble(2, t.getPrice());
            st.setString(3, t.getDesc());
            st.setString(4, t.getEmployeeDTO().getEmployeeID());
            st.setString(5, t.getServID());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    public boolean select(ServiceDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Tim User theo ID
    public ServiceDTO selectById(String servID) {
        ServiceDTO serviceDTO = null;
        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Service] where servID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, servID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
//                
                    serviceDTO = new ServiceDTO();
                    EmployeeDAO employeeDAO = new EmployeeDAO();
                    serviceDTO.setServID(rs.getString("servID"));
                    serviceDTO.setServName(rs.getString("servName"));
                    serviceDTO.setPrice(rs.getDouble("price"));
                    serviceDTO.setDesc(rs.getString("desc"));
                    serviceDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString("employeeID")));
                return serviceDTO;
            }

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return serviceDTO;
    }

    //Method to check existed username
//    public boolean selectByUserName(String userName) {
//
//        try {
//
//            // Bước 1: tạo kết nối đến CSDL
//            Connection con = DBUtils.getConnection();
//
//            // Bước 2: tạo ra đối tượng statement
//            String sql = "SELECT * FROM [dbo].[User] where username=?";
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setString(1, userName);
//
//            // Bước 3: thực thi câu lệnh SQL
//            System.out.println(sql);
//            ResultSet rs = st.executeQuery();
//
//            // Bước 4:
//            if (rs.next()) {
////                ServiceDTO = new ServiceDTO();
////                ServiceDTO.setUserID(rs.getString("userID"));
////                ServiceDTO.setUserName(rs.getString("username"));
////                ServiceDTO.setPassword(rs.getString("password"));
////                ServiceDTO.setFname(rs.getString("fname"));
////                ServiceDTO.setLname(rs.getString("lname"));
////                ServiceDTO.setDayOfBirth(rs.getDate("dayOfBirth"));
////                ServiceDTO.setVisitFrequency(rs.getInt("visitFrequency"));
////                ServiceDTO.setPhoneNumber(rs.getString("phoneNumber"));
////                ServiceDTO.setEmail(rs.getString("email"));
////                ServiceDTO.setGender(rs.getString("gender"));
////                return ServiceDTO;
//                return true;
//            }
//
//            // Bước 5:
//            DBUtils.closeConnection(con);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return false;
//    }

    public List<ServiceDTO> list() {
        String sql = "select * from [dbo].[Service]";
        List<ServiceDTO> listService = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                userID, username, password, fname, lname, dayOfBirth, visitFrequency, phoneNumber, email, gender
//  servID, servName, price, desc, employeeID
                ServiceDTO serviceDTO = new ServiceDTO();

                    EmployeeDAO employeeDAO = new EmployeeDAO();
                    serviceDTO.setServID(rs.getString("servID"));
                    serviceDTO.setServName(rs.getString("servName"));
                    serviceDTO.setPrice(rs.getDouble("price"));
                    serviceDTO.setDesc(rs.getString("desc"));
                    serviceDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString("employeeID")));
                    listService.add(serviceDTO);
                
                
            }
            return listService;
        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return null;

    }

    public int listSize() {
        List<ServiceDTO> listService = list();
        return listService.size();
    }

    public static void main(String[] args) {

//        int a =0;
//        for(a=0 ; a<10;a++){
//        String formatted = String.format("US%03d", a);
//        System.out.println(formatted);
//        
//         String str="2005-03-31";  
//      Date date=Date.valueOf(str);
//        System.out.println(date);
        ServiceDTO B = new ServiceDTO();

        UserDAO userDAO = new UserDAO();
//        B = userDAO.login("Olaskadqưe", "Pugre11111");
//        System.out.println(userDAO.listSize());
//        B = userDAO.selectById("US001");
//        B.setLname("LOOOONG");
//        userDAO.update(B);
//
//        System.out.println(B.toString());

        if (userDAO.selectByUserName("Oalskad")) {
            System.out.println("MMB");

        } else {
            System.out.println("MMVB");
        }
//        userDAO.insert(B);
//         List<ServiceDTO> listUser = new ArrayList<>();
//         listUser = userDAO.list();
//         for(ServiceDTO a : listUser)
//         {
//             System.out.println("a");
//             System.out.println(a.getUserID());
//        }
    }
}
