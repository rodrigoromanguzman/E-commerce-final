<%-- 
    Document   : shoppingCart
    Created on : Sep 13, 2023, 8:43:48 PM
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
        <h1>Carrito De Compras</h1>
        <c:choose>
            <c:when test= "${shoppingCart ==null}">
                <h2>No se ha creado Carrito de compras</h2>
            </c:when>
            <c:when test="${shoppingCart.getCart().isEmpty()}">
                <h2>El carrito esta vacio</h2>
            </c:when>
            <c:otherwise>
                <table border="1">
                    <tr>
                        <th>Imagen</th>
                        <th>Nombre</th>
                        <th>Categoria</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th>Quitar</th>
                    </tr>
                    <c:forEach items="${shoppingCart.getCart()}" var="transaction">
                        <tr>
                            <td><img src="${transaction.product.getImgUrl()}" height="100" width="100" alt="alt"/></td>
                            <td>${transaction.product.getName()}</td>
                            <td>${transaction.product.getCategory()}</td>
                            <td>${transaction.product.getPrice()}</td>
                            <td>${transaction.getAmount()}</td>
                            <td>${transaction.getAmount()*transaction.product.getPrice()}</td>
                            <td>
                                <form action="${pageContext.request.servletContext.contextPath}/DeleteTransaction" method="post">
                                    <input type="hidden" name="id" value="${transaction.getId()}" />
                                    <button type="submit">Quitar</button>
                                </form>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>   
        <a href="/eCommerceApp/view/selectProducts.jsp">Agregar productos a carrito de compras</a>
        <a href="/eCommerceApp">Regresar</a>
    </body>
</html>
