<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet"></link>
</head>
<body>
<%String msg=request.getParameter("msg");
String error="Error";
String redirect="login.jsp";
if (msg!=null){
	
	switch (msg){
	case "1":
		error="Usuario o Contraseña incorrectos";
		break;
	case "2":
		error="Este usuario ya existe";
		redirect="registerWeb.jsp";
		break;
	case "3":
		error="Debe iniciar sesion";
		break;
	case "4":
		error="No se han completado todos los campos";
		break;
	case "5":
		error="No se han completado todos los campos";
		redirect="addArticulo.jsp";
		break;
	}
}
%>
<header class="header">
		<h1>HOLA</h1>
</header>
<div class="container">
	<div class="divNormal">	
		<h1>Parece que algo ha fallado</h1><br><br>
		<h3><%=error %> 404</h3><br>
		<a href="<%=redirect%>">Volver</a>
	</div>
</div>

</body>
</html>