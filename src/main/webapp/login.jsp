<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>miTiendaCalzado</title>
	<link href="style.css" rel="stylesheet"></link>
</head>
<body>
    <div class="container">
    <form id="form" method="post" action="loginExec">
        <div class="form-field">
            <label for="nombre">Nickname</label>
            <input type="text" id="nombre" name="nombre" >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" >
            <small></small>
        </div><br>
        <button class="btn" type="submit">Entrar</button><br><br><br>
    </form>
	<a href="registerWeb.jsp"><button class="btn">Registrate aqui</button></a>
    
    </div>

    <script src="login.js"></script>
</body>
</html>
