<%-- 
    Document   : selectProducts
    Created on : Sep 18, 2023, 8:34:05 PM
    Author     : rodrigoroman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               
        <h1>Agregar a Carrito</h1>
        <table border ="1">
            <tr>
            <th>
                Imagen
            </th>
             <th>
                Nombre
            </th>
             <th>
                Categoria
            </th>
             <th>
                Precio
            </th>
            <th>
                Cantidad
            </th>
            <th>
                Agregar
            </th>
            </tr>
            <c:forEach items="${inventory.getInventory()}" var="product" >
                <tr>
                    <form action="${pageContext.request.servletContext.contextPath}/ShoppingCartServlet" method="post">
                        <input type="hidden" name="id" value="${product.getId()}"/>
                    <td>
                        <img src="${product.getImgUrl()}" width="100" height="100" alt="alt"/>
                    </td>
                    <td>
                        <h2>${product.getName()}</h2>
                    </td>
                    <td>
                        <h2>${product.getCategory()}</h2>
                    </td>
                    <td>
                        <h2>${product.getPrice()}</h2>
                    </td>
                    <td>
                        <input name="amount"/>
                    </td>
                    <td>
                            <button type="submit">Agregar</button>
                    </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        <a href="/eCommerceApp">Regresar</a>
    </body>
</html>
