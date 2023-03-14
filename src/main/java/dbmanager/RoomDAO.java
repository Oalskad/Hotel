/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.ImageDTO;
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
        String sql = "INSERT INTO [dbo].[Room](roomID, status, employeeID, dailyPrice, type, numberOfBed, bedType, description)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);
        //type name numberOfBed bedType description
        //roomID status employeeID<import> dailyPrice
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomDTO.getRoomID());
            ps.setBoolean(2, roomDTO.isStatus());
            ps.setString(3, roomDTO.getEmployeeDTO().getEmployeeID());
            ps.setDouble(4, roomDTO.getDailyPrice());
            ps.setString(5, roomDTO.getType());
//            ps.setString(6, roomDTO.getName());
            ps.setInt(6, roomDTO.getNumberOfBed());
            ps.setString(7, roomDTO.getBedType());
            ps.setString(8, roomDTO.getDescription());
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
                    + " employeeID = ?"
                    + ", dailyPrice = ?"
                    + ", status = ?"
                    + ",  type = ?"
                    //                    + ", name = ?"
                    + ", numberOfBed = ?"
                    + ", bedType = ?"
                    + ", description = ?"
                    + " WHERE roomID = ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getEmployeeDTO().getEmployeeID());
            st.setDouble(2, t.getDailyPrice());
            st.setBoolean(3, t.isStatus());
            st.setString(4, t.getType());
//            st.setString(5, t.getName());
            st.setInt(5, t.getNumberOfBed());
            st.setString(6, t.getBedType());
            st.setString(7, t.getDescription());
            st.setString(8, t.getRoomID());
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
        ImageDAO imgDAO = new ImageDAO();
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
                //type name numberOfBed bedType description
                //roomID status employeeID<import> dailyPrice
                roomDTO = new RoomDTO();
                EmployeeDAO employeeDAO = new EmployeeDAO();

                roomDTO.setRoomID(rs.getString("roomID"));
                roomDTO.setStatus(rs.getBoolean("status"));
                roomDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString("employeeID")));
                roomDTO.setType(rs.getString("type"));
                roomDTO.setDailyPrice(rs.getDouble("dailyPrice"));
                roomDTO.setNumberOfBed(rs.getInt("numberOfBed"));
                roomDTO.setBedType(rs.getString("bedType"));
                roomDTO.setDescription(rs.getString("description"));
                roomDTO.setListImg(imgDAO.listImageSelectById(rs.getString("roomID")));
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
    public RoomDTO selectByRoomID(String roomID) {
        RoomDTO roomDTO = null;
        ImageDAO imgDAO = new ImageDAO();
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
                roomDTO = new RoomDTO();
                EmployeeDAO employeeDAO = new EmployeeDAO();
                roomDTO.setRoomID(rs.getString("roomID"));
                roomDTO.setStatus(rs.getBoolean("status"));
                roomDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString("employeeID")));
                roomDTO.setType(rs.getString("type"));
                roomDTO.setDailyPrice(rs.getDouble("dailyPrice"));
                roomDTO.setNumberOfBed(rs.getInt("numberOfBed"));
                roomDTO.setBedType(rs.getString("bedType"));
                roomDTO.setDescription(rs.getString("description"));
                roomDTO.setListImg(imgDAO.listImageSelectById(rs.getString("roomID")));
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

    public List<RoomDTO> list() {
        String sql = "select * from [dbo].[Room]";
        List<RoomDTO> listRoom = new ArrayList<>();
        ImageDAO imgDAO = new ImageDAO();
        
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
                roomDTO.setDailyPrice(rs.getDouble("dailyPrice"));
                roomDTO.setNumberOfBed(rs.getInt("numberOfBed"));
                roomDTO.setBedType(rs.getString("bedType"));
                roomDTO.setDescription(rs.getString("description"));
                roomDTO.setListImg(imgDAO.listImageSelectById(rs.getString("roomID")));
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
    
    
    public List<ImageDTO> getListImg(String ID){
        ImageDAO imgDAO = new ImageDAO();
        return imgDAO.listImageSelectById(ID);
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
        RoomDAO roomDAO = new RoomDAO();
        RoomDTO roomDTO = new RoomDTO();
        roomDTO = roomDAO.selectById("RO001");
        List<ImageDTO> a = roomDAO.getListImg("RO001");
        System.out.println(a.get(0).getImgSrc());
//        System.out.println(roomDTO.toString());
//        roomDTO.setStatus(false);
//         System.out.println(roomDTO.toString());
//         roomDAO.update(roomDTO);
//        List<ImageDTO> list = roomDAO.getListImg("RO001");
//        for(ImageDTO a : list){
//            System.out.println(a.getImgSrc());
//        }
//        B = userDAO.login("Olaskadqưe", "Pugre11111");
//        System.out.println(userDAO.listSize());
//        B = userDAO.selectById("US001");
//        B.setLname("LOOOONG");
//        userDAO.update(B);
//
//        System.out.println(B.toString());
//        if (userDAO.selectByUserName("Oalskad")) {
//            System.out.println("MMB");
//
//        } else {
//            System.out.println("MMVB");
//        }
//        userDAO.insert(B);
//        List<RoomDTO> listRoom = new ArrayList<>();
//        listRoom = roomDAO.list();
//        for (RoomDTO a : listRoom) {
//            for(ImageDTO b : a.getListImg()){
//                System.out.println(b.getImgSrc());
//            }
//        }
    }
}
