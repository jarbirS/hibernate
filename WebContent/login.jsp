<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="LoginServlet" method="post">
<ul>
<li><label for="name">Usuario: </label> <input type="text" id="usuario" name="usuario" > </li>

<li> <label for="mail">Clave</label><input type="password" id="mail" nombre="clave"></li>

<li class="button">
<button type="submit">Ingresar</button>
</li>



</ul>
</form>

</body>
</html>