/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.CouponDTO;
import Model.ReceiptDTO;
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
public class ReceiptDAO implements DAOInterface<ReceiptDTO>{

    //Override method insert
    @Override
    public boolean insert(ReceiptDTO t) {
        String sql = "INSERT INTO [dbo].[Receipt]([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice])"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);

        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getReceiptID());
            ps.setString(2, t.getCouponDTO().getCouponID());
            ps.setInt(3, t.getCardNumber());
            ps.setString(4, t.getServiceDTO().getServID());
            ps.setString(5, t.getUserDTO().getUserID());
            ps.setString(6, t.getRoomDTO().getRoomID());
            ps.setString(7, t.getDetail());
            ps.setDate(8, t.getStartDate());
            ps.setDate(9, t.getEndDate());
            ps.setString(10, t.getEmployeeDTO().getEmployeeID());
            ps.setDouble(11, t.getFinalPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Insert Student error!" + ex.getMessage());
        }

        return false;
    }

    // Override method delete dua tren username
    @Override
    public boolean delete(ReceiptDTO t) {

        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from [dbo].[Receipt] "
                    + " WHERE [receiptID]=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getReceiptID());

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

    @Override
    public boolean update(ReceiptDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE [dbo].[Receipt] "
                    + " SET "
                    + "[couponID] = ?"
                    + ", [cardNumber] = ?"
                    + ", [servID] = ?"
                    + ", [userID] = ?"
                    + ", [roomID] = ?"
                    + ", [detail] = ?"
                    + ",[startDate] = ?"
                    + ",[endDate] = ?"
                    + ",[employeeID] = ?"
                    + ",[finalPrice] = ?"
                    + " WHERE [receiptID]=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getCouponDTO().getCouponID());
            st.setInt(2, t.getCardNumber());
            st.setString(3, t.getServiceDTO().getServID());
            st.setString(4, t.getUserDTO().getUserID());
            st.setString(5, t.getDetail());
            st.setDate(6, t.getStartDate());
            st.setDate(7, t.getEndDate());
            st.setString(8, t.getEmployeeDTO().getEmployeeID());
            st.setDouble(9, t.getFinalPrice());
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

    @Override
    public boolean select(ReceiptDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Tim User theo ID
    public ReceiptDTO selectById(String userID) {
        ReceiptDTO receiptDTO = null;
        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Receipt] where [receiptID]=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                receiptDTO = new ReceiptDTO();
                CouponDAO couponDAO = new CouponDAO();
                ServiceDAO serviceDAO = new ServiceDAO();
                RoomDAO roomDAO = new RoomDAO();
                EmployeeDAO employeeDAO = new EmployeeDAO();
                
                
                receiptDTO.setReceiptID(rs.getString(1));
                receiptDTO.setCouponDTO(couponDAO.selectById(rs.getString(2)));
                receiptDTO.setCardNumber(rs.getInt(3));
                receiptDTO.setServiceDTO(serviceDAO.selectById(rs.getString(4)));
                receiptDTO.setRoomDTO(roomDAO.selectById(rs.getString(5)));
                receiptDTO.setDetail(rs.getString(6));
                receiptDTO.setStartDate(rs.getDate(7));
                receiptDTO.setEndDate(rs.getDate(8));
                receiptDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString(9)));
                receiptDTO.setFinalPrice(rs.getDouble(10));
                return receiptDTO;
            }

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return receiptDTO;
    }

  

    @Override
    public List<ReceiptDTO> list() {
        String sql = "select * from [dbo].[Receipt]";
        List<ReceiptDTO> listReceipt = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                userID, username, password, fname, lname, dayOfBirth, visitFrequency, phoneNumber, email, gender
               ReceiptDTO  receiptDTO = new ReceiptDTO();
                 CouponDAO couponDAO = new CouponDAO();
                ServiceDAO serviceDAO = new ServiceDAO();
                RoomDAO roomDAO = new RoomDAO();
                EmployeeDAO employeeDAO = new EmployeeDAO();
                
                receiptDTO.setReceiptID(rs.getString(1));
                receiptDTO.setCouponDTO(couponDAO.selectById(rs.getString(2)));
                receiptDTO.setCardNumber(rs.getInt(3));
                receiptDTO.setServiceDTO(serviceDAO.selectById(rs.getString(4)));
                receiptDTO.setRoomDTO(roomDAO.selectById(rs.getString(5)));
                receiptDTO.setDetail(rs.getString(6));
                receiptDTO.setStartDate(rs.getDate(7));
                receiptDTO.setEndDate(rs.getDate(8));
                receiptDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString(9)));
                receiptDTO.setFinalPrice(rs.getDouble(10));
                listReceipt.add(receiptDTO);
            }
            return listReceipt;
        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return null;

    }

  

    public static void main(String[] args) {


    }

 
}
