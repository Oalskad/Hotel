/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.RoomDTO;
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
public class RoomDAO {
    public boolean insert(RoomDTO roomDTO) {
        String sql = "INSERT INTO [dbo].[Room](roomID, status, employeeID, dailyPrice, type, name, numberOfBed, bedType, desc)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);
            //type name numberOfBed bedType desc
            //roomID status employeeID<import> dailyPrice
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomDTO.getRoomID());
            ps.setBoolean(2, roomDTO.isStatus());
            ps.setString(3, roomDTO.getEmployeeDTO().getEmployeeID());
            ps.setDouble(4, roomDTO.getDailyPrice());
            ps.setString(5, roomDTO.getType());
            ps.setString(6, roomDTO.getName());
            ps.setInt(7, roomDTO.getNumberOfBed());
            ps.setString(8, roomDTO.getBedType());
            ps.setString(9, roomDTO.getDesc());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insert Room error!" + ex.getMessage());
        }

        return false;
    }

    public boolean delete(RoomDTO t) {

        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from [dbo].[Room] "
                    + " WHERE roomID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getRoomID());

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

    public boolean update(RoomDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            
            String sql = "UPDATE [dbo].[Room] "
                    + " SET "
                    
                    
                    + ", employeeID = ?"
                    + ", dailyPrice = ?"
                    + ", status = ?"
                    
                    + "  type = ?"
                    + ", name = ?"
                    + ", numberOfBed = ?"
                    + ", bedType = ?"
                    + ", desc = ?"
                    + " WHERE roomID = ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getEmployeeDTO().getEmployeeID());
            st.setDouble(2, t.getDailyPrice());
            st.setBoolean(3, t.isStatus());
            st.setString(4, t.getType());
            st.setString(5, t.getName());
            st.setInt(6, t.getNumberOfBed());
            st.setString(7, t.getDesc());
            st.setString(9, t.getRoomID());
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

    public boolean select(RoomDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Tim User theo ID
    public RoomDTO selectById(String roomID) {
        RoomDTO roomDTO = null;
        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Room] where roomID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, roomID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                //type name numberOfBed bedType desc
                //roomID status employeeID<import> dailyPrice
                roomDTO = new RoomDTO();
                EmployeeDAO employeeDAO = new EmployeeDAO();
                
                roomDTO.setRoomID(rs.getString("roomID"));
                roomDTO.setStatus(rs.getBoolean("status"));
                roomDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString("employeeID")));
                roomDTO.setType(rs.getString("type"));
                roomDTO.setName(rs.getString("name"));
                roomDTO.setNumberOfBed(rs.getInt("numberOfBed"));
                roomDTO.setBedType(rs.getString("bedType"));
                roomDTO.setDesc(rs.getString("desc"));
                return roomDTO;
            }

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return roomDTO;
    }

    //Method to check existed username
    public boolean selectByRoomID(String roomID) {

        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Room] where roomID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, roomID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.next()) {
//                userDTO = new RoomDTO();
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

    public List<RoomDTO> list() {
        String sql = "select * from [dbo].[Room]";
        List<RoomDTO> listRoom = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                userID, username, password, fname, lname, dayOfBirth, visitFrequency, phoneNumber, email, gender
                RoomDTO roomDTO = new RoomDTO();
                EmployeeDAO employeeDAO = new EmployeeDAO();
                
                roomDTO.setRoomID(rs.getString("roomID"));
                roomDTO.setStatus(rs.getBoolean("status"));
                roomDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString("employeeID")));
                roomDTO.setType(rs.getString("type"));
                roomDTO.setName(rs.getString("name"));
                roomDTO.setNumberOfBed(rs.getInt("numberOfBed"));
                roomDTO.setBedType(rs.getString("bedType"));
                roomDTO.setDesc(rs.getString("desc"));
                listRoom.add(roomDTO);
            }
            return listRoom;
        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return null;

    }

    public int listSize() {
        List<RoomDTO> listRoom = list();
        return listRoom.size();
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
        RoomDTO B = new RoomDTO();

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
//         List<RoomDTO> listRoom = new ArrayList<>();
//         listRoom = userDAO.list();
//         for(RoomDTO a : listRoom)
//         {
//             System.out.println("a");
//             System.out.println(a.getUserID());
//        }
    }
}
