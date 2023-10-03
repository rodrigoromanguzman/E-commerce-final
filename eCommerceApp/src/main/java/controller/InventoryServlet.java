/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Inventory;
import model.Product;

/**
 *
 * @author rodrigoroman
 */
@WebServlet(name = "InventoryServlet", urlPatterns = {"/InventoryServlet"})
public class InventoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();
        String attributeName = "inventory";
        Inventory inventory;
        if(servletContext.getAttribute(attributeName)==null){
            Inventory newInventory = new Inventory();
            servletContext.setAttribute(attributeName, newInventory);
        }
        inventory = (Inventory) servletContext.getAttribute(attributeName);
        if(request.getMethod().equalsIgnoreCase("POST")){
            String name = request.getParameter("name");
            String imgUrl = request.getParameter("imgUrl");
            String category = request.getParameter("category");
            String priceString = request.getParameter("price");
            double price = Double.parseDouble(priceString);
            Product newProduct = new Product(name,imgUrl,category,price);
            inventory.addProductToInventory(newProduct); 
            
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/inventory.jsp");
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


}
