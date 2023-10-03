<%-- 
    Document   : createProduct
    Created on : Sep 18, 2023, 8:29:39 PM
    Author     : rodrigoroman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear un nuevo producto</h1>       
         <form action ="${pageContext.request.servletContext.contextPath}/InventoryServlet" method="post">
             <label for="name">Nombre</label><br/>
             <input name="name" id="name"/><br/>
             <label for="img">Imagen</label><br/>
             <input name="imgUrl" id="img"/><br/>
             <label for="category">Categoria</label><br/>
             <input name="category" id="category"/><br/>
             <label for="price">Precio</label><br/>
             <input name="price" id="price"/><br/>
             <button type="submit">Crear</button>    
         </form>
         <a href="/eCommerceApp">Regresar</a>

    </body>
</html>
