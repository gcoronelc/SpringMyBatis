<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>LISTADO DE PRODUCTOS</h1>
  <a href="main.htm">Retornar</a>
  <table border="1">
    <tr>
      <th>IDPROD</th>
      <th>NOMBRE</th>
      <th>IDCAT</th>
      <th>CATEGORIA</th>
      <th>PRECIO</th>
      <th>STOCK</th>
    </tr>
    
    <c:forEach items="${lista}" var="r">
    <tr>
      <td>${r.idprod}</td>
      <td>${r.nombre}</td>
      <td>${r.idcat}</td>
      <td>${r.categoria}</td>
      <td>${r.precio}</td>
      <td>${r.stock}</td>
    </tr>
    </c:forEach>
  </table>
</body>
</html>