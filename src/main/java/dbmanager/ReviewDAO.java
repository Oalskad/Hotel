/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.ReviewDTO;
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
 * @author Oalskad
 */
public class ReviewDAO implements DAOInterface<ReviewDTO> {

    @Override
    public boolean insert(ReviewDTO t) {

        String sql = "INSERT INTO [dbo].[Review]([reviewID], [receiptID], [userID], [roomID], [description], [rating])"
                + " values(?, ?, ?, ?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);

        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getReviewID());
            ps.setString(2, t.getReceiptDTO_ID().getReceiptID());
            ps.setString(3, t.getUserDTO_ID().getUserID());
            ps.setString(4, t.getRoomDTO_ID().getRoomID());
            ps.setString(5, t.getDescription());
            ps.setInt(6, t.getRating());
            ps.executeUpdate();
        } catch (SQLException ex) {

        }

        return false;
    }

    @Override
    public boolean delete(ReviewDTO t) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from [dbo].[Review] "
                    + " WHERE reviewID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getReviewID());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            st.executeUpdate();

            // Bước 4:
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
    public boolean update(ReviewDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE [dbo].[Review] "
                    + " SET "
                    + " [description]= ?"
                    + ", [rating] = ?"
                    + " WHERE [reviewID]=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getDescription());
            st.setInt(2, t.getRating());
            st.setString(3, t.getReviewID());
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
    public boolean select(ReviewDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReviewDTO> list() {
        String sql = "select * from [dbo].[Review]";
        List<ReviewDTO> listReview = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
// String reviewID;
//    ReceiptDTO receiptDTO_ID;
//    UserDTO userDTO_ID;
//    RoomDTO roomDTO_ID;
//    String description;
//    int Rating;

                ReceiptDAO receiptDAO = new ReceiptDAO();
                UserDAO userDAO = new UserDAO();
                RoomDAO roomDAO = new RoomDAO();

                ReviewDTO reviewDTO = new ReviewDTO();
                reviewDTO.setReviewID(rs.getString(1));
                reviewDTO.setReceiptDTO_ID(receiptDAO.selectById(rs.getString(2)));
                reviewDTO.setUserDTO_ID(userDAO.selectById(rs.getString(3)));
                reviewDTO.setRoomDTO_ID(roomDAO.selectById(rs.getString(4)));
                reviewDTO.setDescription(rs.getString(5));
                reviewDTO.setRating(rs.getInt(6));

                listReview.add(reviewDTO);
            }
            return listReview;
        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return null;
    }

    public List<ReviewDTO> listByID(String ID) {
        String sql = "select * from [dbo].[Review] where roomID = ?";
        List<ReviewDTO> listReview = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
// String reviewID;
//    ReceiptDTO receiptDTO_ID;
//    UserDTO userDTO_ID;
//    RoomDTO roomDTO_ID;
//    String description;
//    int Rating;

                ReceiptDAO receiptDAO = new ReceiptDAO();
                UserDAO userDAO = new UserDAO();
                RoomDAO roomDAO = new RoomDAO();

                ReviewDTO reviewDTO = new ReviewDTO();
                reviewDTO.setReviewID(rs.getString(1));
                reviewDTO.setReceiptDTO_ID(receiptDAO.selectById(rs.getString(2)));
                reviewDTO.setUserDTO_ID(userDAO.selectById(rs.getString(3)));
                reviewDTO.setRoomDTO_ID(roomDAO.selectById(rs.getString(4)));
                reviewDTO.setDescription(rs.getString(5));
                reviewDTO.setRating(rs.getInt(6));

                listReview.add(reviewDTO);
            }

        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        if (!listReview.isEmpty()) {
            return listReview;
        }
        return null;
    }

    public int generateNextUserID() {
        List<ReviewDTO> list = list();
        try {
            if (list.size() > 0) {
                ReviewDTO e = list.get(list.size() - 1);
                int numberOnly = Integer.parseInt(e.getReviewID().replaceAll("[^0-9]", ""));
                return numberOnly + 1;
            }
        } catch (Exception e) {

        }
        return 1;
    }

    public static void main(String[] args) {
        ReviewDAO reviewDAO = new ReviewDAO();
        List<ReviewDTO> listReview = new ArrayList();
        listReview = reviewDAO.listByID("RO002");
        for(ReviewDTO a : listReview){
            System.out.println(a.getDescription());
        }
    }
}
