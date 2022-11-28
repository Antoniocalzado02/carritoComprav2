<%@page import="com.miTienda.Articles.Articles"%>
<%@page import="com.miTienda.Crud.CrudArticles"%>
<%@page import="com.miTienda.CarritoCompra.itemCarrito"%>
<%@page import="com.miTienda.CarritoCompra.Carrito"%>
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
Carrito carritoCompra;
carritoCompra=(Carrito) sesion.getAttribute("carroCompra");



%>
	<div class="container">
	<div class="compra" overflow: scroll>
		<%for(itemCarrito i: carritoCompra.getListCarrito()){
			%><div class="inform"><%=i.toString()%></div><br><% 
		
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
		<button type="submit">Comprar ya</button>
		</form>
	</div>
	</div>

</body>
</html>