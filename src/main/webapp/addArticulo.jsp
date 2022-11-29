<%@page import="com.miTienda.Crud.CrudCategoria"%>
<%@page import="com.miTienda.Categoria.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String bienvenido="";
HttpSession sesion=request.getSession();
String isSesion = (String) sesion.getAttribute("login");
String userSesion= (String) sesion.getAttribute("usuario");
if(isSesion != null && userSesion!=null && isSesion.equals("True")){
	bienvenido=("Sesion: "+userSesion);
}
else{
%> <jsp:forward page="error.jsp"></jsp:forward> <%
} %>

<div class="annadir">
	<p><%= bienvenido %></p>
	<form action="addArticulo" method="post">
		
		<p>Name: </p>
		<input type="text" id="name" name="name" required>
		<p>Description: </p>
		<input type="text" id="description" name="description" required>
		<p>Price: </p>
		<input type="number" step="0.01" id="price" name="price" required>
		<p>Quantity: </p>
		<input type="number" step="form-control number" id="quantity" name="quantity" required>
		<p>Categorie: </p>
		<select id="categorie" name="categorie">
		<%List<Categoria> lista=CrudCategoria.loadList();  
		for(Categoria cat: lista){
			%><option value="<%=cat.getId()%>"><%=cat.getNombre()%></option> <%
		}
		
		%>
		</select>
		<input type="submit" value="Enviar">
	</form>

<a href="loginExec"><button type="button">Pulsa para volver</button></a>

</div>

</body>
</html>