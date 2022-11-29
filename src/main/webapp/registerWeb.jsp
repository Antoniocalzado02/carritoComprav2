<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Construcciones ACS</title>
<link href="style.css" rel="stylesheet"></link>
</head>
<body>
<div class="container">
    <form id="form" method="post" action="registerExec">
        <div class="form-field">
            <label for="nickname">Nickname</label>
            <input type="text" id="nickname" name="nickname" required>
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="nombre">Nombre</label>
            <input type="text" id="nombre" name="nombre" required minlength="1" maxlength="20">
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="apellidos">Apellidos</label>
            <input type="text" id="apellidos" name="apellidos" required >
            <small></small>

        </div><br>
        <div class="form-field">
            <label for="gmail">Email</label>
            <input type="email" id="gmail" name="gmail" required>
            <small></small>
        </div><br>
        <div class="form-field">
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" required minleght="6">
            <small></small>
        </div><br>
        <div class="form-field">
            <label for="fecha_nac">Fecha_nac</label>
            <input type="date" id="fecha_nac" name="fecha_nac" required>
            <small></small>
        </div><br>
        <div class="form-field">
        <p>Selecciona tu genero</p>
        	<input type="radio" class="radio" name="Genero" id="Genero" value="M" checked>Hombre
            <input type="radio" class="radio" name="Genero" id="Genero" value="F">Mujer
        </div><br>
        <div class="form-field">
        <button class="btn" type="submit">Enviar</button><br><br><br>
    </form>
    
    </div>

    <script src="login.js"></script>

</body>
</html>