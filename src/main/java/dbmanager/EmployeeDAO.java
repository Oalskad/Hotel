/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.EmployeeDTO;
import Model.UserDTO;
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
public class EmployeeDAO {
    public boolean insert(EmployeeDTO employeeDTO) {
        //employeeID    f/lname     phone    address    department
        String sql = "INSERT INTO [dbo].[Employee](employeeID, fname, lname, phone, address, department)"
                + " values(?, ?, ?, ?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);

        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, userDTO.getUserID());
//            ps.setString(2, userDTO.getUserName());
//            ps.setString(3, userDTO.getPassword());
//            ps.setString(4, userDTO.getFname());
//            ps.setString(5, userDTO.getLname());
//            ps.setDate(6, userDTO.getDayOfBirth());
//            ps.setInt(7, userDTO.getVisitFrequency());
//            ps.setString(8, userDTO.getPhoneNumber());
//            ps.setString(9, userDTO.getEmail());
//            ps.setString(10, userDTO.getGender());

                ps.setString(1, employeeDTO.getEmployeeID());
                ps.setString(2, employeeDTO.getFname());
                ps.setString(3, employeeDTO.getLname());
                ps.setInt(4, employeeDTO.getPhone());
                ps.setString(5, employeeDTO.getAddress());
                ps.setString(6, employeeDTO.getDepartment());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insert Employee error!" + ex.getMessage());
        }

        return false;
    }

    // Override method delete dua tren username
    public boolean delete(EmployeeDTO t) {

        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from [dbo].[Employee] "
                    + " WHERE employeeID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getEmployeeID());

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

    public boolean update(EmployeeDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE [dbo].[Employee] "
                    + " SET "
                    + ", fname = ?"
                    + ", lname = ?"
                    + ", phone = ?"
                    + ", address = ?"
                    + ", department = ?"
                    + " WHERE employeeID = ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getFname());
            st.setString(2, t.getLname());
            st.setInt(3, t.getPhone());
            st.setString(4, t.getAddress());
            st.setString(5, t.getDepartment());
            st.setString(9, t.getEmployeeID());
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

    public boolean select(EmployeeDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Tim User theo ID
    public EmployeeDTO selectById(String employeeID) {
        EmployeeDTO employeeDTO = null;
        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Employee] where employeeID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, employeeID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                employeeDTO = new EmployeeDTO();
                employeeDTO.setEmployeeID(rs.getString("employeeID"));
                employeeDTO.setFname(rs.getString("fname"));
                employeeDTO.setLname(rs.getString("lname"));
                employeeDTO.setPhone(rs.getInt("phone"));
                employeeDTO.setAddress(rs.getString("address"));
                employeeDTO.setDepartment(rs.getString("department"));
                return employeeDTO;
            }

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employeeDTO;
    }

    //Method to check existed username
    public boolean selectByEmployeeID(String employeeID) {

        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[employee] where employeeID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, employeeID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.next()) {
//                userDTO = new UserDTO();
//                userDTO.setUserID(rs.getString("userID"));
//                userDTO.setUserName(rs.getString("username"));
//                userDTO.setPassword(rs.getString("password"));
//                userDTO.setFname(rs.getString("fname"));
//                userDTO.setLname(rs.getString("lname"));
//                userDTO.setDayOfBirth(rs.getDate("dayOfBirth"));
//                userDTO.setVisitFrequency(rs.getInt("visitFrequency"));
//                userDTO.setPhoneNumber(rs.getString("phoneNumber"));
//                userDTO.setEmail(rs.getString("email"));
//                userDTO.setGender(rs.getString("gender"));
//                return userDTO;
                return true;
            }

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public List<EmployeeDTO> list() {
        String sql = "select * from [dbo].[Employee]";
        List<EmployeeDTO> listEmployee = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //employeeID    f/lname     phone    address    department
//                userID, username, password, fname, lname, dayOfBirth, visitFrequency, phoneNumber, email, gender
                EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setEmployeeID(rs.getString("employeeID"));
                    employeeDTO.setFname(rs.getString("fname"));
                    employeeDTO.setLname(rs.getString("lname"));
                    employeeDTO.setPhone(rs.getInt("phone"));
                    employeeDTO.setAddress(rs.getString("address"));
                    employeeDTO.setDepartment(rs.getString("department"));
                listEmployee.add(employeeDTO);
            }
            return listEmployee;
        } catch (Exception ex) {
            System.out.println("Query Empoyloyee error!" + ex.getMessage());
        }
        return null;

    }

    public int listSize() {
        List<EmployeeDTO> listEmployee = list();
        return listEmployee.size();
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
        UserDTO B = new UserDTO();

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
//         List<UserDTO> listUser = new ArrayList<>();
//         listUser = userDAO.list();
//         for(UserDTO a : listUser)
//         {
//             System.out.println("a");
//             System.out.println(a.getUserID());
//        }
    }
}
