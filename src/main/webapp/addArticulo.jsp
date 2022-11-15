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

<div class="annadir">
	<form action="addArticulo" method="post">
		<p>Name: </p>
		<input type="text" id="name" name="name">
		<p>Description: </p>
		<input type="text" id="description" name="description">
		<p>Price: </p>
		<input type="number" step="0.01" id="price" name="price">
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

</div>

</body>
</html>