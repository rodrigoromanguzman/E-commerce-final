<%-- 
    Document   : inventory
    Created on : Sep 6, 2023, 8:36:38 PM
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
        <h1>Inventario</h1>
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
                Borrar
            </th>
            </tr>
            <c:forEach items="${inventory.getInventory()}" var="product" >
                <tr>
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
                        <form action="${pageContext.request.servletContext.contextPath}/DeleteProductServlet" method="post">
                            <input name="id" type="hidden" value="${product.getId()}"/>
                            <button type="submit">Borrar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/eCommerceApp/view/createProduct.jsp">Crear producto</a>
         <a href="/eCommerceApp">Regresar</a>

    </body>
</html>
