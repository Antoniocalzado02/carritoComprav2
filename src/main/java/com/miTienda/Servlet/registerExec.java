package com.miTienda.Servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miTienda.Crud.CrudUser;
import com.miTienda.User.User;

/**
 * Servlet implementation class registerExec
 */
@WebServlet("/registerExec")
public class registerExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerExec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname=request.getParameter("nickname");
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String email=request.getParameter("gmail");
		String contrasena=request.getParameter("password");
		Date fecha_nac=Date.valueOf(request.getParameter("fecha_nac"));
		String genero=request.getParameter("Genero");
		
		CrudUser c=new CrudUser();
		
		boolean error=false;
		int msgError=0;
		
		if(nickname!=null && contrasena!=null && email!=null && nombre!=null && apellidos!=null && fecha_nac!=null && genero!=null && !nickname.isEmpty() && !contrasena.isEmpty() && !email.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() &&  !genero.isEmpty()) {
			if(CrudUser.readUser(nickname)!=null) {
				error=true;
				msgError=2;
			}
			else {
				User u=new User(nickname,nombre,apellidos,email,MD5(contrasena),fecha_nac,genero);
				c.addUser(u);
			}
		}
		else {
			error=true;
			msgError=4;
			
		}
		if(error) {
			response.sendRedirect("error.jsp?msg="+msgError);
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
	}
	
	public static String MD5(String cadena) {
		if (cadena == null || cadena.length() == 0) {
			return null;
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(cadena.getBytes());
			byte[] byteArray = md5.digest();

			BigInteger bigInt = new BigInteger(1, byteArray);
			
			String result = bigInt.toString(16);
			
			while (result.length() < 32) {
				result = "0" + result;
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
