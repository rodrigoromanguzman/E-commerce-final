/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Inventory;
import model.Product;
import model.Transaction;
import model.ShoppingCart;

/**
 *
 * @author rodrigoroman
 */
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/ShoppingCartServlet"})
public class ShoppingCartServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session =  request.getSession();
        String cartAttribute = "shoppingCart";
        ServletContext servletContext = request.getServletContext();
        Inventory inventory = (Inventory) servletContext.getAttribute("inventory");
        ShoppingCart cart;
        if(session.getAttribute(cartAttribute) == null){
            ShoppingCart newCart = new ShoppingCart(); 
            session.setAttribute(cartAttribute, newCart);
        }
        cart = (ShoppingCart) session.getAttribute(cartAttribute);
        if(request.getMethod().equalsIgnoreCase("POST")){
            String productId = request.getParameter("id");
            String amountString = request.getParameter("amount");
            Product newProduct = inventory.getProductById(productId);
            int amount = Integer.parseInt(amountString);
            Transaction newTransaction = new Transaction(newProduct,amount); 
            cart.addTransactionToCart(newTransaction);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/shoppingCart.jsp");
        requestDispatcher.forward(request, response);
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
