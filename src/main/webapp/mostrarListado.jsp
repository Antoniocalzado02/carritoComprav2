<%@page import="com.miTienda.Crud.*"%>
<%@page import="com.miTienda.UsuarioArticles.*"%>
<%@page import="com.miTienda.User.*"%>
<%@page import="com.miTienda.CarritoCompra.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>mostrarListado</title>
<link href="style.css" rel="stylesheet"></link>
</head>
<body>
<header class="cabecera">
		<div class="titulo" align="center"><h1>Construcciones ACS</h1></div>
		<div class="titulo" align="center"><img src="imagenes/logo2.jpg" width="100px"></div>
<form method="post" action="loginExec" class="form">
	<button type="submit" >Volver a la lista</button>
</form>
</header>
<%
String bienvenida="";
HttpSession sesion=request.getSession();
String isSesion = (String) sesion.getAttribute("login");
String userSesion= (String) sesion.getAttribute("usuario");
if(isSesion != null && userSesion!=null && isSesion.equals("True")){
	bienvenida=userSesion;
}
else{
%> <jsp:forward page="error.jsp?msg=3"></jsp:forward> <%
}
%>
<%
int contador=0;
Carrito carritoCompra=(Carrito) sesion.getAttribute("carroCompra");
if(carritoCompra!=null){
	contador=carritoCompra.getCantidadTotal();
}
%>
<div class="padre">
	
	<%if(CrudCarrito.loadList().size()>0){
		for(UsuarioArticles u: CrudCarrito.loadList()){
			if(u.getName_usuario()==CrudUser.readUser(userSesion)){
				%>
				<div class="hijo">
					<p>Articulo: <%=u.getId_article().getNombre()%></p>
					<p>Descripcion: <%=u.getId_article().getDescripcion() %></p>
					<p>Cantidad: <%=u.getQuantity() %> Articles</p>
					<p>Precio: <%=u.getPrice() %> €</p>
					<p>Fecha: <%=u.getDate_buy()%></p>
				</div>
				<%
			}
			
		}
	} 
	%>
</div>

</body>
</html>