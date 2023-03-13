/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.CouponDTO;
import Model.EmployeeDTO;
import Model.ReceiptDTO;
import Model.RoomDTO;
import Model.ServiceDTO;
import Model.UserDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author iba
 */
public class ReceiptDAO implements DAOInterface<ReceiptDTO> {

    //Override method insert
    @Override
    public boolean insert(ReceiptDTO t) {
        String sql = "INSERT INTO [dbo].[Receipt]([receiptID], [couponID], [cardNumber], [servID], [userID], [roomID], [detail], [startDate], [endDate], [employeeID], [finalPrice])"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            st.setString(5,t.getRoomDTO().getRoomID());
            st.setString(6, t.getDetail());
            st.setDate(7, t.getStartDate());
            st.setDate(8, t.getEndDate());
            st.setString(9, t.getEmployeeDTO().getEmployeeID());
            st.setDouble(10, t.getFinalPrice());
            st.setString(11, t.getReceiptID());
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
                UserDAO userDAO = new UserDAO();
                RoomDAO roomDAO = new RoomDAO();
                EmployeeDAO employeeDAO = new EmployeeDAO();

                receiptDTO.setReceiptID(rs.getString(1));
                receiptDTO.setCouponDTO(couponDAO.selectById(rs.getString(2)));
                receiptDTO.setCardNumber(rs.getInt(3));
                receiptDTO.setServiceDTO(serviceDAO.selectById(rs.getString(4)));
                receiptDTO.setUserDTO(userDAO.selectById(rs.getString(5)));
                receiptDTO.setRoomDTO(roomDAO.selectById(rs.getString(6)));
                receiptDTO.setDetail(rs.getString(7));
                receiptDTO.setStartDate(rs.getDate(8));
                receiptDTO.setEndDate(rs.getDate(9));
                receiptDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString(10)));
                receiptDTO.setFinalPrice(Double.parseDouble(rs.getString(11)));
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
                ReceiptDTO receiptDTO = new ReceiptDTO();
                CouponDAO couponDAO = new CouponDAO();
                ServiceDAO serviceDAO = new ServiceDAO();
                RoomDAO roomDAO = new RoomDAO();
                EmployeeDAO employeeDAO = new EmployeeDAO();
                UserDAO userDAO = new UserDAO();


                receiptDTO.setReceiptID(rs.getString(1));
                receiptDTO.setCouponDTO(couponDAO.selectById(rs.getString(2)));
//                if (rs.getString(2) != null) {
//                    receiptDTO.setCouponDTO(couponDAO.selectById(rs.getString(2)));
//                }
//                else{
//                    receiptDTO.setCouponDTO(null);
//                }
                receiptDTO.setCardNumber(rs.getInt(3));
//                if (rs.getString(4) != null) {
//                    receiptDTO.setServiceDTO(serviceDAO.selectById(rs.getString(4)));
//                }
//                else{
//                    receiptDTO.setServiceDTO(null);
//                }
                receiptDTO.setServiceDTO(serviceDAO.selectById(rs.getString(4)));
                receiptDTO.setUserDTO(userDAO.selectById(rs.getString(5)));
                receiptDTO.setRoomDTO(roomDAO.selectById(rs.getString(6)));
                receiptDTO.setDetail(rs.getString(7));
                receiptDTO.setStartDate(rs.getDate(8));
                receiptDTO.setEndDate(rs.getDate(9));
                receiptDTO.setEmployeeDTO(employeeDAO.selectById(rs.getString(10)));
                receiptDTO.setFinalPrice(Double.parseDouble(rs.getString(11)));
                listReceipt.add(receiptDTO);
            }
            return listReceipt;
        } catch (Exception ex) {
            System.out.println("Query Reciept error!" + ex.getMessage());
        }
        return null;

    }

    public int generateNextReceiptID() {
        List<ReceiptDTO> list = list();
        try {

            ReceiptDTO e = list.get(list.size() - 1);
            int numberOnly = Integer.parseInt(e.getReceiptID().replaceAll("[^0-9]", ""));
            return numberOnly + 1;

        } catch (Exception e) {

        }
        return -1;
    }

    public static void main(String[] args) {
        ReceiptDAO receiptDAO = new ReceiptDAO();
        ReceiptDTO receiptDTO = new ReceiptDTO();
//        receiptDTO = receiptDAO.selectById("RC001");
//        System.out.println(receiptDTO.toString());
     
        RoomDAO roomDAO = new RoomDAO();
        RoomDTO roomDTO = new RoomDTO();
        roomDTO = roomDAO.selectById("RO002");

        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = userDAO.selectById("US001");

        CouponDAO couponDAO = new CouponDAO();
        CouponDTO couponDTO = new CouponDTO();

        couponDTO=couponDAO.selectByName("WELCOME");
        ServiceDTO serviceDTO = new ServiceDTO();
//
        EmployeeDTO employeeDTO = new EmployeeDTO();
        String str = "2005-03-25";
        Date date = Date.valueOf(str);

        String str2 = "2005-03-29";
         String RECEIPT_ID = String.format("RC%03d", (receiptDAO.generateNextReceiptID()));
        String receiptID = RECEIPT_ID;
//        System.out.println(receiptID);
//
        Date date2 = Date.valueOf(str2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int intStarDate = cal.get(Calendar.DAY_OF_MONTH);
        cal = Calendar.getInstance();
        cal.setTime(date2);
        int intEndDate = cal.get(Calendar.DAY_OF_MONTH);
        int daysBooked = intEndDate - intStarDate;
        receiptDTO.setReceiptID(receiptID);
       receiptDTO.setCouponDTO(couponDTO);
receiptDTO.setCouponDTO(couponDTO);        
       receiptDTO.setServiceDTO(serviceDTO);
        receiptDTO.setServiceDTO(serviceDTO);
        receiptDTO.setUserDTO(userDTO);
        receiptDTO.setRoomDTO(roomDTO);
        
      receiptDTO.setEmployeeDTO(roomDTO.getEmployeeDTO());
         receiptDTO.setEmployeeDTO(employeeDTO);

      receiptDTO.setDetail("");
        receiptDTO.setDetail("");
        receiptDTO.setCardNumber(23123);
        receiptDTO.setCardNumber(0);
        receiptDTO.setStartDate(date);
        receiptDTO.setEndDate(date);
      receiptDTO.setFinalPrice(50);

        receiptDAO.insert(receiptDTO);
//
        double finalPrice = 0;
        double servicePrice = 1;
        double coupon = 1;
        double dailyPrice = roomDTO.getDailyPrice();
        if (couponDTO.getCouponID() != null) {
            coupon = couponDTO.getDiscount();
        }
        if (serviceDTO.getServID() != null) {
            servicePrice = serviceDTO.getPrice();
        }

        finalPrice = ((dailyPrice * daysBooked + servicePrice) * coupon);

        System.out.println(coupon);
        System.out.println(servicePrice);
        System.out.println(dailyPrice);
        System.out.println(daysBooked);
        
        System.out.println(finalPrice);

       




//
//                UserDAO userDAO = new UserDAO();
//          
//                 UserDTO userDTO = userDAO.selectById("US001");
//
//                RoomDAO roomDAO = new RoomDAO();
//                RoomDTO roomDTO = roomDAO.selectByRoomID("RO001");
//
//                ServiceDAO serviceDAO = new ServiceDAO();
//                ServiceDTO serviceDTO = new ServiceDTO();
////                if (serviceDAO.selectById(request.getParameter("serviceID")) != null) {
////                    serviceDTO = serviceDAO.selectById(request.getParameter("serviceID"));
////                }
//                //CouponDTO 
//                CouponDAO couponDAO = new CouponDAO();
//                CouponDTO couponDTO = new CouponDTO();
////                if (couponDAO.selectByName(request.getParameter("couponName")) != null) {
////
////                    couponDTO = couponDAO.selectByName(request.getParameter("coupoName"));
////                }
//
////ReceiptDTO(CouponDTO couponDTO, UserDTO userDTO, RoomDTO roomDTO, EmployeeDTO employeeDTO, ServiceDTO serviceDTO, String receiptID, String detail, int cardNumber, Date startDate, Date endDate, double finalPrice)
//                ReceiptDAO receiptDAO = new ReceiptDAO();
//                ReceiptDTO receiptDTO = new ReceiptDTO();
//
//                //Auto create ID
//                String RECEIPT_ID = String.format("RC%03d", (receiptDAO.generateNextReceiptID()));
//                String receiptID = RECEIPT_ID;
//
//                //GET startDate and endDate
////                Date startDate = null;
////                try {
////                    startDate = Date.valueOf(request.getParameter("startDate"));
////                } catch (Exception e) {
////
////                }
////                Date endDate = null;
////                try {
////                    endDate = Date.valueOf(request.getParameter("endDate"));
////                } catch (Exception e) {
////
////                }
//
//
// String str = "2005-03-25";
//        Date date = Date.valueOf(str);
//
//        String str2 = "2005-03-29";
//         
////        System.out.println(receiptID);
////
//        Date date2 = Date.valueOf(str2);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int intStarDate = cal.get(Calendar.DAY_OF_MONTH);
//        cal = Calendar.getInstance();
//        cal.setTime(date2);
//        int intEndDate = cal.get(Calendar.DAY_OF_MONTH);
//        int daysBooked = intEndDate - intStarDate;
//
//                //Method to caculate days booked
//               
//
//                receiptDTO.setReceiptID(receiptID);
//                receiptDTO.setCouponDTO(couponDTO);
//
//                receiptDTO.setServiceDTO(serviceDTO);
//
//                receiptDTO.setUserDTO(userDTO);
//                receiptDTO.setRoomDTO(roomDTO);
//
//                receiptDTO.setEmployeeDTO(roomDTO.getEmployeeDTO());
//
//                receiptDTO.setDetail("");
//
//                receiptDTO.setCardNumber(123123);
//
//                receiptDTO.setStartDate(date);
//                receiptDTO.setEndDate(date2 );
//                
//                
//                 double finalPrice = 0;
//        double servicePrice = 1;
//        double coupon = 1;
//        double dailyPrice = roomDTO.getDailyPrice();
//        if (couponDTO.getCouponID() != null) {
//            coupon = couponDTO.getDiscount();
//        }
//        if (serviceDTO.getServID() != null) {
//            servicePrice = serviceDTO.getPrice();
//        }
//
//         finalPrice = ((dailyPrice * daysBooked + servicePrice) * coupon);
//                receiptDTO.setFinalPrice( finalPrice);
//
////                receiptDAO.insert(receiptDTO);
////        userDTO.setVisitFrequency(userDTO.getVisitFrequency() + 1);
////        userDAO.update(userDTO);
//
//
//                System.out.print(roomDTO.toString());
//       
    }

}
