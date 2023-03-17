/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ReceiptDTO;
import Model.UserDTO;
import dbmanager.ReceiptDAO;
import dbmanager.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oalskad
 */
@WebServlet(name = "UserProfile", urlPatterns = {"/UserProfile"})
public class UserProfileController extends HttpServlet {

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
            if (path.equalsIgnoreCase("/details")) {
                showReceiptDetail(request, response);
                RequestDispatcher rd = request.getRequestDispatcher("/ReceiptDetails.jsp");
                rd.forward(request, response);
            } else if (path.equalsIgnoreCase("/edit")) {
                editProfile(request, response);
                response.sendRedirect(request.getContextPath() + "/Profile.jsp");
            }
        }

    }

    public List<ReceiptDTO> showReceiptDetail(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserDTO userDTO = new UserDTO();
        userDTO = (UserDTO) session.getAttribute("userDTO");
        List<ReceiptDTO> listReceipt = new ArrayList<ReceiptDTO>();
        ReceiptDAO receiptDAO = new ReceiptDAO();
        listReceipt = receiptDAO.listSelectByUserId(userDTO.getUserID());
        request.setAttribute("listReceipt", listReceipt);

        return listReceipt;
    }

    public void editProfile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = new UserDTO();

        HttpSession session = request.getSession();
        if (session.getAttribute("userDTO") != null) {
            userDTO = (UserDTO) session.getAttribute("userDTO");
        }

        String errorMessage = "";
        String errorMessageDate = "";
        boolean error = true;
        Date dateOfBirth = null;

        String userID = userDTO.getUserID();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        userDTO.setUserID(userID);
        userDTO.setUserName(userName);
        userDTO.setPassword(password);
        userDTO.setFname(fname);
        userDTO.setLname(lname);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setEmail(email);
        userDAO.update(userDTO);
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
