/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ReceiptDTO;
import Model.ReviewDTO;
import dbmanager.ReceiptDAO;
import dbmanager.ReviewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oalskad
 */
@WebServlet(name = "ReviewControler", urlPatterns = {"/ReviewControler"})
public class ReviewControler extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         ReviewDAO reviewDAO = new ReviewDAO();
         ReviewDTO reviewDTO = new ReviewDTO();
         ReceiptDAO receiptDAO = new ReceiptDAO();
         ReceiptDTO receiptDTO = new ReceiptDTO();
         
         
         receiptDTO = receiptDAO.selectById(request.getParameter("receiptID"));
         
         String comment = "";
                 if(request.getParameter("comments")!=null){
                    comment = request.getParameter("comments");
                 }
         int rate =5;
         if(request.getParameter("stars") !=null){
              rate =   Integer.parseInt(request.getParameter("stars"));
         }
         
         
        String AUTO_REVIEW_ID = String.format("RV%03d", (reviewDAO.generateNextUserID()));

        //USER CONSTRUCTOR
        String reviewID = AUTO_REVIEW_ID;
         
         
         reviewDTO.setReviewID(reviewID);
         reviewDTO.setDescription(comment);
         reviewDTO.setRating(rate);
         reviewDTO.setUserDTO_ID(receiptDTO.getUserDTO());
         reviewDTO.setRoomDTO_ID(receiptDTO.getRoomDTO());
         reviewDTO.setReceiptDTO_ID(receiptDTO);
         reviewDAO.insert(reviewDTO);
         response.sendRedirect(request.getContextPath()+"/HomePage");
        }
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
