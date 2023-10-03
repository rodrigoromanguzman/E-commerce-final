/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author rodrigoroman
 */
@WebFilter(filterName="UserTypeFilter",urlPatterns={"/view/inventory.jsp","/view/createProduct.jsp"})
public class UserTypeFilter implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest httpServletRequest =(HttpServletRequest) request;
        HttpServletResponse httpServletResponse =  (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);
       User user;
        if(session!=null){
            user = (User) session.getAttribute("user");
            if("admin".equals(user.getUserType())){
                System.out.print("The user is Admin");
                chain.doFilter(request, response);
            }else{
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
            }
        } 
    }
    
}
