<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.miTienda.Articles.Articles"%>
<%@page import="com.miTienda.Crud.CrudArticles"%>
<%@page import="com.miTienda.CarritoCompra.itemCarrito"%>
<%@page import="com.miTienda.CarritoCompra.Carrito"%>
<%@page import="com.miTienda.User.User" %>
<%@page import="com.miTienda.Crud.CrudUser" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>miTiendaCalzado</title>
<link href="style.css" rel="stylesheet"></link>
</head>
<body>
	<header class="cabecera">
		<div class="titulo" align="center"><h1>Construcciones ACS</h1></div>
		<div class="titulo" align="center"><img src="imagenes/logo2.jpg" width="100px"></div>
	</header>
<%
HttpSession sesion=request.getSession();

//Obtengo el usuario de la seison
User u=CrudUser.readUser((String)sesion.getAttribute("usuario"));

Carrito carritoCompra;
carritoCompra=(Carrito) sesion.getAttribute("carroCompra");

if(carritoCompra!=null){
%>
	<div class="container">
	<div class="compra" overflow: scroll>
		<%for(itemCarrito i: carritoCompra.getListCarrito()){
		%><%Articles a= CrudArticles.readArticle(i.getId_article());%>
			<div class="inform">
				<p><%=i.getId_article() %></p>
				<p><%=i.getName_usuario() %></p>
				<p><%=i.getPrice() %></p>
				<p><%=i.getQuantity() %></p>
				<p><%=DateTimeFormatter.ISO_LOCAL_DATE.format(i.getFecha())+"   "+ DateTimeFormatter.ISO_LOCAL_TIME.format(i.getFecha().minusNanos(i.getFecha().getNano()))%></p>
				<form method="post" action="updateQuantity">
					Quantity: <input type="number" name="updateQuantity" id="updateQuantity" value="<%=i.getQuantity() %>" min="1" max="<%=a.getQuantity()%>">
					<input type="text" value="<%=a.getId() %>" hidden name="idItem" id="idItem">
					<button type="submit">Update quantity</button>
				</form>
			</div><br><% 
		}%>
	</div>
	<br>
	<div class="venta">
		<h1>Su pedido:</h1>
		<form method="post" action="loginExec">
		<%double cantidad=0;
		double contador=0;
		for(itemCarrito i: carritoCompra.getListCarrito()){
			%><%for(Articles a: CrudArticles.loadList()){
				if(i.getId_article()==a.getId()){
					%><%=a.getNombre() %><% 
				}
			}%>
			<%cantidad=i.getQuantity()*i.getPrice(); %>	
			<%=cantidad+"$"%><br><% 
			%><%contador+=cantidad;%><% 
		
		}%>
			<%="-------------------------------------"%><br>
			<br>
			<%="Total a pagar: "+ contador+ " $" %>
		</form>
		<form method="post" action="addListaCompra">
		<button type="submit">Comprar ya</button>
		</form>
		<button type="button"><a href="loginExec">Volver al menú</a></button>
	</div>
	</div>
<%}else{ %>
	
<%
response.sendRedirect("loginExec");
}%>
</body>
</html>