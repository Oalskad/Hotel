package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Admin.AdminDAO;
import Admin.AdminDTO;
import User.UserDAO;
import User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class LoginController extends HttpServlet {

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
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //lOGIN 
            if (path.equalsIgnoreCase("/login")) {

                String url = "";
                UserDAO userDAO = new UserDAO();
                String user = (String) request.getParameter("userName");
                String password = (String) request.getParameter("password");

                UserDTO userDTO = userDAO.login(user, password);
                if (userDTO != null) {
                    
                    session.setAttribute("userDTO", userDTO);
                    url = "/home.jsp";

                } else {
                    if (user != null || password != null) {
                        request.setAttribute("error", "Wrong username or password");
                    }
                    url = "/loginJSP.jsp";
                }
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } 


                //CREATE USER
            else if (path.equalsIgnoreCase("/signup")) {
                UserDAO userDAO = new UserDAO();
                String url = "";
                String errorMessage = "";
                String errorMessageDate = "";
                boolean error = true;
                Date dateOfBirth = null;

                //AUTO GENERATE USER ID WITH PATTERN US### 
                String AUTO_USER_ID = String.format("US%03d", (userDAO.generateNextUserID()));

                //USER CONSTRUCTOR
                String userID = AUTO_USER_ID;
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                try {
                    dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
                } catch (Exception e) {
                    errorMessageDate = "invalid Date";
                    error = false;
                }
                String phoneNumber = request.getParameter("phoneNumber");
                String email = request.getParameter("email");
                String gender = request.getParameter("gender");

                if (userDAO.selectByUserName(userName)) {
                    errorMessage += "User Name is already taken";
                    error = false;
                }
                request.setAttribute("errorMessage", errorMessage);
                request.setAttribute("errorMessageDate", errorMessageDate);

                if (error == true) {
                    UserDTO userDTO = new UserDTO(userID, userName, password, fname, lname, dateOfBirth, 0, phoneNumber, email, gender);
                    userDAO.insert(userDTO);
                    RequestDispatcher rd = request.getRequestDispatcher("/loginJSP.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
                    rd.forward(request, response);
                }
            }
            
            
            else if(path.equalsIgnoreCase("/logout")){
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("/loginJSP.jsp");
                rd.forward(request, response);
            }

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
