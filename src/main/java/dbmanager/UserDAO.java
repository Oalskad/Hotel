/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.UserDTO;
import Model.AdminDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Oalskad
 */
public class UserDAO implements DAOInterface<UserDTO> {

    // Method check login
    public UserDTO login(String userName, String password) {
        UserDTO userDTO = null;
        String sql = "select * from [dbo].[User]"
                + " where username = ? and password = ?  ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userDTO = new UserDTO();

                userDTO.setUserID(rs.getString("userID"));
                userDTO.setUserName(rs.getString("username"));
                userDTO.setPassword(rs.getString("password"));
                userDTO.setFname(rs.getString("fname"));
                userDTO.setLname(rs.getString("lname"));
                userDTO.setDayOfBirth(rs.getDate("dayOfBirth"));
                userDTO.setVisitFrequency(rs.getInt("visitFrequency"));
                userDTO.setPhoneNumber(rs.getString("phoneNumber"));
                userDTO.setEmail(rs.getString("email"));
                userDTO.setGender(rs.getString("gender"));
                return userDTO;
            }
        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return userDTO;
    }

    //Override method insert
    @Override
    public boolean insert(UserDTO userDTO) {
        String sql = "INSERT INTO [dbo].[User](userID, username, password, fname, lname, dayOfBirth, visitFrequency, phoneNumber, email, gender)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);

        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userDTO.getUserID());
            ps.setString(2, userDTO.getUserName());
            ps.setString(3, userDTO.getPassword());
            ps.setString(4, userDTO.getFname());
            ps.setString(5, userDTO.getLname());
            ps.setDate(6, userDTO.getDayOfBirth());
            ps.setInt(7, userDTO.getVisitFrequency());
            ps.setString(8, userDTO.getPhoneNumber());
            ps.setString(9, userDTO.getEmail());
            ps.setString(10, userDTO.getGender());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insert Student error!" + ex.getMessage());
        }

        return false;
    }

    // Override method delete dua tren username
    @Override
    public boolean delete(UserDTO t) {

        int ketQua = 0;
        try {
            // B?????c 1: t???o k???t n???i ?????n CSDL
            Connection con = DBUtils.getConnection();

            // B?????c 2: t???o ra ?????i t?????ng statement
            String sql = "DELETE from [dbo].[User] "
                    + " WHERE username=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getUserName());

            // B?????c 3: th???c thi c??u l???nh SQL
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // B?????c 4:
            System.out.println("B???n ???? th???c thi: " + sql);
            System.out.println("C?? " + ketQua + " d??ng b??? thay ?????i!");

            // B?????c 5:
            DBUtils.closeConnection(con);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(UserDTO t) {
        int ketQua = 0;
        try {
            // B?????c 1: t???o k???t n???i ?????n CSDL
            Connection con = DBUtils.getConnection();

            // B?????c 2: t???o ra ?????i t?????ng statement
            String sql = "UPDATE [dbo].[User] "
                    + " SET "
                    + "username = ?"
                    + ", password = ?"
                    + ", fname = ?"
                    + ", lname = ?"
                    + ", dayOfBirth = ?"
                    + ", visitFrequency = ?"
                    + ",email = ?"
                    + ",gender = ?"
                    + " WHERE userID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getUserName());
            st.setString(2, t.getPassword());
            st.setString(3, t.getFname());
            st.setString(4, t.getLname());
            st.setDate(5, t.getDayOfBirth());
            st.setInt(6, t.getVisitFrequency());
            st.setString(7, t.getEmail());
            st.setString(8, t.getGender());
            st.setString(9, t.getUserID());
            // B?????c 3: th???c thi c??u l???nh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // B?????c 4:
            System.out.println("B???n ???? th???c thi: " + sql);
            System.out.println("C?? " + ketQua + " d??ng b??? thay ?????i!");

            // B?????c 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean select(UserDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Tim User theo ID
    public UserDTO selectById(String userID) {
        UserDTO userDTO = null;
        try {

            // B?????c 1: t???o k???t n???i ?????n CSDL
            Connection con = DBUtils.getConnection();

            // B?????c 2: t???o ra ?????i t?????ng statement
            String sql = "SELECT * FROM [dbo].[User] where userID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userID);

            // B?????c 3: th???c thi c??u l???nh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // B?????c 4:
            while (rs.next()) {
                userDTO = new UserDTO();
                userDTO.setUserID(rs.getString("userID"));
                userDTO.setUserName(rs.getString("username"));
                userDTO.setPassword(rs.getString("password"));
                userDTO.setFname(rs.getString("fname"));
                userDTO.setLname(rs.getString("lname"));
                userDTO.setDayOfBirth(rs.getDate("dayOfBirth"));
                userDTO.setVisitFrequency(rs.getInt("visitFrequency"));
                userDTO.setPhoneNumber(rs.getString("phoneNumber"));
                userDTO.setEmail(rs.getString("email"));
                userDTO.setGender(rs.getString("gender"));
                return userDTO;
            }

            // B?????c 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userDTO;
    }

    //Method to check existed username
    public boolean selectByUserName(String userName) {

        try {

            // B?????c 1: t???o k???t n???i ?????n CSDL
            Connection con = DBUtils.getConnection();

            // B?????c 2: t???o ra ?????i t?????ng statement
            String sql = "SELECT * FROM [dbo].[User] where username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userName);

            // B?????c 3: th???c thi c??u l???nh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // B?????c 4:
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

            // B?????c 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<UserDTO> list() {
        String sql = "select * from [dbo].[User]";
        List<UserDTO> listUser = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                userID, username, password, fname, lname, dayOfBirth, visitFrequency, phoneNumber, email, gender
                UserDTO userDTO = new UserDTO();
                userDTO.setUserID(rs.getString("userID"));
                userDTO.setUserName(rs.getString("username"));
                userDTO.setPassword(rs.getString("password"));
                userDTO.setFname(rs.getString("fname"));
                userDTO.setLname(rs.getString("lname"));
                userDTO.setDayOfBirth(rs.getDate("dayOfBirth"));
                userDTO.setVisitFrequency(rs.getInt("visitFrequency"));
                userDTO.setPhoneNumber(rs.getString("phoneNumber"));
                userDTO.setEmail(rs.getString("email"));
                userDTO.setGender(rs.getString("gender"));
                listUser.add(userDTO);
            }
            return listUser;
        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return null;

    }

    public int listSize() {
        List<UserDTO> listUser = list();
        return listUser.size();
    }

    //Generate next user ID by add 1 to the last ID
    public int generateNextUserID() {
        List<UserDTO> list = list();
        try {
            UserDTO e = list.get(list.size() - 1);
            int numberOnly = Integer.parseInt(e.getUserID().replaceAll("[^0-9]", ""));
            return numberOnly + 1;
        } catch (Exception e) {

        }
        return -1;
    }

    public static void main(String[] args) {
//         UserDAO userDAO = new UserDAO();
// String AUTO_USER_ID = String.format("US%03d", (userDAO.generateNextUserID()));
//
//        //USER CONSTRUCTOR
//        String userID = AUTO_USER_ID;
//        System.out.println(userID);
        
        UserDTO userDTO = new UserDTO();
        System.out.println(userDTO.toString());
//        int a =0;
//        for(a=0 ; a<10;a++){
//        String formatted = String.format("US%03d", a);
//        System.out.println(formatted);
//        
//         String str="2005-03-31";  
//      Date date=Date.valueOf(str);
//        System.out.println(date);
//        UserDTO B = new UserDTO();
       
////        B = userDAO.login("Olaskadq??e", "Pugre11111");
////        System.out.println(userDAO.listSize());
//
//        B = userDAO.selectById("US001");
//      
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(B.getDayOfBirth());
//      int day = cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println(B.getDayOfBirth().toString());
//        System.out.println(day);
//        System.out.println(B.toString());
//        B.setLname("LOONG");
//        
//        userDAO.update(B);
//
//        System.out.println(B.toString());
//        System.out.println(userDAO.generateNextUserID());
//        if (userDAO.selectByUserName("Oalskad")) {
//            System.out.println("MMB");
//
//        } else {
//            System.out.println("MMVB");
//        }
//        userDAO.insert(B);
        
//        List<UserDTO> listUser = new ArrayList<>();
//        listUser = userDAO.list();
//        for (UserDTO a : listUser) {
//
//            System.out.println(a.toString());
//        }
    }
}
