/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.CouponDTO;
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
public class CouponDAO implements DAOInterface<CouponDTO> {

    
     public CouponDTO selectByName(String couponName) {
        CouponDTO couponDTO = null;
        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Coupons] where name =?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, couponName);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                couponDTO = new CouponDTO();
                couponDTO.setCouponID(rs.getString("couponID"));
                couponDTO.setName(rs.getString("name"));
                couponDTO.setDiscount(rs.getDouble("discount"));

                return couponDTO;
            }

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return couponDTO;
    }
    
    
    
    //Tim User theo ID
    public CouponDTO selectById(String couponID) {
        CouponDTO couponDTO = new CouponDTO();
        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Coupons] where couponID= ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, couponID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                couponDTO = new CouponDTO();
                couponDTO.setCouponID(rs.getString("couponID"));
                couponDTO.setName(rs.getString("name"));
                couponDTO.setDiscount(rs.getDouble("discount"));

                return couponDTO;
            }

            // Bước 5:
            DBUtils.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return couponDTO;
    }

//    }
    @Override
    public boolean insert(CouponDTO t) {
        String sql = "INSERT INTO [dbo].[Coupons](couponID, name, discount)"
                + " values(?, ?, ?)";
//        INSERT INTO table_name(column1, column2, column3, ...)
//        VALUES(value1, value2, value3, ...);

        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCouponID());
            ps.setString(2, t.getName());
            ps.setDouble(3, t.getDiscount());

            ps.executeUpdate();
        } catch (SQLException ex) {

        }

        return false;
    }

    @Override
    public boolean delete(CouponDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from [dbo].[Coupons] "
                    + " WHERE counponID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getCouponID());

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
    public boolean update(CouponDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE [dbo].[Coupons] "
                    + " SET "
                    + "name = ?"
                    + ", discount = ?"
                    + " WHERE userID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getName());
            st.setDouble(2, t.getDiscount());
            st.setString(3, t.getCouponID());

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
    public boolean select(CouponDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CouponDTO> list() {
        String sql = "select * from [dbo].[Coupons]";
        List<CouponDTO> listCoupon = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                CouponDTO couponDTO = new CouponDTO();
                couponDTO.setCouponID(rs.getString("couponID"));
                couponDTO.setName(rs.getString("name"));
                couponDTO.setDiscount(rs.getDouble("discount"));
                listCoupon.add(couponDTO);
            }
            return listCoupon;
        } catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return null;

    }

    public static void main(String[] args) {
//        CouponDAO couponDAO = new CouponDAO();
//        CouponDTO couponDTO = new CouponDTO();
//        
//        
//        couponDTO = couponDAO.selectByName("WELCOME");
//        System.out.println(couponDTO.toString());
//        couponDTO.setCouponID("CP008");
//        couponDAO.insert(couponDTO);
//        List<CouponDTO> listCoupon = couponDAO.list();
//
//        for (CouponDTO a : listCoupon) {
//            System.out.println(a.toString());
//
//        }

//        CouponDTO couponDTO = couponDAO.selectByName("WELCOME");
//
//        System.out.println(couponDTO==null);
    }
}
