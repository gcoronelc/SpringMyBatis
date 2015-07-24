<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>Ingreso al Sistema</h1>
  <p>${error}</p>
  <form method="post" action="ingreso.htm">
    Usuario: <input type="text" name="usuario" /><br/>
    Clave: <input type="password" name="clave" /><br/>
    <input type="submit" value="Ingresar" />
  </form>
</body>
</html>
