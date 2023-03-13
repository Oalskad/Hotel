/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CouponDTO;
import Model.ReceiptDTO;
import Model.RoomDTO;
import Model.ServiceDTO;
import Model.UserDTO;
import dbmanager.CouponDAO;
import dbmanager.ReceiptDAO;
import dbmanager.RoomDAO;
import dbmanager.ServiceDAO;
import dbmanager.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.rsa.RSACore;

/**
 *
 * @author Oalskad
 */
@WebServlet(name = "BookController", urlPatterns = {"/BookController"})
public class BookController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getPathInfo();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (path.equals("/detail")) {
                out.print("ewqeqweqewqewqwe");
                HttpSession session = request.getSession();
                UserDTO userDTO = new UserDTO();
                if (session.getAttribute("userDTO") != null) {
                    userDTO = (UserDTO) session.getAttribute("userDTO");
                }
                out.print(userDTO.getUserName());
                String roomID = null;
                RoomDTO roomDTO = null;
                roomID = request.getParameter("roomID");
                if (roomID != null) {
                    RoomDAO roomDAO = new RoomDAO();
                    roomDTO = roomDAO.selectByRoomID(request.getParameter("roomID"));
                    out.print("succcesss");
                    out.print(roomDTO.toString());
                }

                ServiceDAO serviceDAO = new ServiceDAO();
                List<ServiceDTO> listService = new ArrayList<ServiceDTO>();
                listService = serviceDAO.list();

                Date date = Date.valueOf(LocalDate.now());
                
                request.setAttribute("date", date);
                request.setAttribute("listService", listService);
                request.setAttribute("roomDTO", roomDTO);

                RequestDispatcher rd = request.getRequestDispatcher("/BookPage.jsp");
                rd.forward(request, response);
            } else if (path.equals("/book")) {
                ReceiptDTO receiptDTO = createReceipt(request, response);
                out.print(receiptDTO.toString());
            }
        }
    }

    public ReceiptDTO createReceipt(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = new UserDTO();
        if (session.getAttribute("userDTO") != null) {
            userDTO = (UserDTO) session.getAttribute("userDTO");
        }

        RoomDAO roomDAO = new RoomDAO();
        RoomDTO roomDTO = roomDAO.selectByRoomID(request.getParameter("roomID"));

//        String[] service = request.getParameterValues("service");
        ServiceDAO serviceDAO = new ServiceDAO();
        ServiceDTO serviceDTO = new ServiceDTO();
        if (serviceDAO.selectById(request.getParameter("service")) != null) {

            serviceDTO = serviceDAO.selectById(request.getParameter("service"));
        }
        //CouponDTO 
        CouponDAO couponDAO = new CouponDAO();
        CouponDTO couponDTO = new CouponDTO();
        if (couponDAO.selectByName(request.getParameter("couponName")) != null) {

            couponDTO = couponDAO.selectByName(request.getParameter("couponName"));
        }

//ReceiptDTO(CouponDTO couponDTO, UserDTO userDTO, RoomDTO roomDTO, EmployeeDTO employeeDTO, ServiceDTO serviceDTO, String receiptID, String detail, int cardNumber, Date startDate, Date endDate, double finalPrice)
        ReceiptDAO receiptDAO = new ReceiptDAO();
        ReceiptDTO receiptDTO = new ReceiptDTO();

        //Auto create ID
        String RECEIPT_ID = String.format("RC%03d", (receiptDAO.generateNextReceiptID()));
        String receiptID = RECEIPT_ID;

        //GET startDate and endDate
        Date startDate =Date.valueOf(LocalDate.now());
       
        
        Date endDate = null;
        try {
            endDate = Date.valueOf(request.getParameter("endDate"));
        } catch (Exception e) {

        }

        //Method to caculate days booked
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate); // .LocalDate();
        int intStarDate = cal.get(Calendar.DAY_OF_MONTH);
        cal = Calendar.getInstance();
        cal.setTime(endDate);
        int intEndDate = cal.get(Calendar.DAY_OF_MONTH);
        int daysBooked = intEndDate - intStarDate;

        receiptDTO.setReceiptID(receiptID);
        receiptDTO.setCouponDTO(couponDTO);

        receiptDTO.setServiceDTO(serviceDTO);

        receiptDTO.setUserDTO(userDTO);
        receiptDTO.setRoomDTO(roomDTO);

        receiptDTO.setEmployeeDTO(roomDTO.getEmployeeDTO());

        receiptDTO.setDetail(request.getParameter("detail"));

        receiptDTO.setCardNumber(Integer.parseInt(request.getParameter("cardNumber")));

        receiptDTO.setStartDate(startDate);
        receiptDTO.setEndDate(endDate);

        receiptDTO.setFinalPrice(finalPrice(request, response, daysBooked, roomDTO, couponDTO, serviceDTO));

        receiptDAO.insert(receiptDTO);
        userDTO.setVisitFrequency(userDTO.getVisitFrequency() + 1);
        userDAO.update(userDTO);

        return receiptDTO;

    }

    public double finalPrice(HttpServletRequest request, HttpServletResponse response, int daysBooked, RoomDTO roomDTO, CouponDTO couponDTO, ServiceDTO serviceDTO) {
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

        return finalPrice = ((dailyPrice * daysBooked + servicePrice) * coupon);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
