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
	<%session.invalidate(); %>
	<header class="cabecera">
	<div class="titulo" align="center"><h1>Construcciones ACS</h1></div>
	<div class="titulo" align="center"><img src="imagenes/logo2.jpg" width="100px"></div>
	</header>
    <div class="container">
		 <form id="form" method="post" action="loginExec" border="3px">
		     <div class="form-field">
			     <label for="nombre">Nickname</label>
			     <input type="text" id="nombre" name="nombre" required>
			            
			
			     <br>
			     <br>
			     
			     <label for="password">Password</label>
			     <input type="password" id="password" name="password" required>
			     <br>
			     <br>
			     <button class="btn" type="submit">Entrar</button><br><br><br>
				<br>
			            
		     </div><br>
		 </form>
				<a href="registerWeb.jsp"><button class="btn">Registrate aqui</button></a>
    
    </div>

    <script src="login.js"></script>
</body>
</html>
