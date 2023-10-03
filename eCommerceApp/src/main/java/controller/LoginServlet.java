/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author rodrigoroman
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        User newUser = new User(username,password,email,userType);
        HttpSession session = request.getSession();
        session.setAttribute("user", newUser);
        RequestDispatcher requestDispatcher;
        if(userType.equals("admin")){
            requestDispatcher = request.getRequestDispatcher("view/inventory.jsp");
        }else{
            requestDispatcher = request.getRequestDispatcher("view/shoppingCart.jsp");
        }
        requestDispatcher.forward(request, response);
        
        
    }

}
