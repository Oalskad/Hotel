/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RoomDTO;
import Model.UserDTO;
import dbmanager.RoomDAO;
import dbmanager.ServiceDAO;
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
@WebServlet(name = "HomePageController", urlPatterns = {"/HomePageController"})
public class HomePageController extends HttpServlet {

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
        String path = request.getPathInfo();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RoomDAO roomDAO = new RoomDAO();
            List<RoomDTO> listRoom = new ArrayList<RoomDTO>();
            listRoom = roomDAO.list();
            request.setAttribute("listRoom", listRoom);
            RequestDispatcher rs = request.getRequestDispatcher("HomePage.jsp");
            rs.forward(request, response);
            /* TODO output your page here. You may use following sample code. */
//            if (path == null) {
//                RoomDAO roomDAO = new RoomDAO();
//                List<RoomDTO> listRoom = new ArrayList<RoomDTO>();
//                listRoom = roomDAO.list();
//                request.setAttribute("listRoom", listRoom);
//                RequestDispatcher rs = request.getRequestDispatcher("HomePage.jsp");
//                rs.forward(request, response);
//            } else {
//                search(request, response);
//            }
//            
        }
    }

//    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String roomType = request.getParameter("roomType");
//        int numbOfPeople = Integer.parseInt(request.getParameter("numbOfPeople"));
//
//        int numbOfChildren = Integer.parseInt(request.getParameter("numbOfChildren"));
//        if (numbOfChildren > 0) {
//            numbOfChildren = (int) Math.round(numbOfPeople / 2);
//        }
//
//        int totalPeople = numbOfPeople + numbOfChildren;
//
//        if (totalPeople >= 3) {
//            totalPeople = 3;
//        }
//        RoomDAO roomDAO = new RoomDAO();
//        List<RoomDTO> listRoom = new ArrayList<RoomDTO>();
//        listRoom = roomDAO.listSearch(totalPeople, roomType);
//        request.setAttribute("listRoom", listRoom);
//        RequestDispatcher rs = request.getRequestDispatcher("HomePage.jsp");
//        rs.forward(request, response);
//
//    }

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
