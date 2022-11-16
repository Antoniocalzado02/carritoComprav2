package com.miTienda.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miTienda.Articles.Articles;
import com.miTienda.Categoria.Categoria;
import com.miTienda.Crud.CrudArticles;
import com.miTienda.Crud.CrudCategoria;
import com.miTienda.Crud.CrudUser;
import com.miTienda.User.User;

/**
 * Servlet implementation class miTiendaCalzado
 */
@WebServlet("/loginExec")
public class loginExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginExec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				String name = request.getParameter("nombre");
				String password = request.getParameter("password");
				
				
				HttpSession sesion=request.getSession();
				
				
				Boolean error=false;
				int msgError=0;
				User u = null;
				
				if (name==null || password==null || name.isEmpty() || password.isEmpty()) { 
					name = (String) sesion.getAttribute("usuario");
					password = (String) sesion.getAttribute("password");
					if (name==null || password==null) { 
						error=true;
						msgError=4;
					}
					else { 
						u=CrudUser.readUser(name);
					}
				}
				else {
					u=CrudUser.readUser(name);
					if (u==null || (!u.getContrasena().equals(MD5(password)))) { 
						error=true;
						msgError=1;
					}
					else { 
						sesion.setAttribute("login", "True");
						sesion.setAttribute("usuario", name);
						sesion.setAttribute("password", password);
						
					}
				}
		
		if (!error) {			
			
			PrintWriter out=response.getWriter();
			response.getWriter().append("<a href=cerrarSesion.jsp>Cerrar sesion</a>");
			List<Articles> listaArticulos= CrudArticles.loadList();
			if(u.isEs_admin()==true) {
				response.getWriter().append("<a href=addArticulo.jsp>Annadir articulo</a>");
			}
			out.println("  <!DOCTYPE html>\n"
					+ "<html lang=\"en\">\n"
					+ "<head>\n"
					+ "    <meta charset=\"UTF-8\">\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
					+ "    <title>Document</title>\n"
					+ "    <link href=\"style.css\" rel=\"stylesheet\"></link>"
					+ "</head>\n"
					+ "<body>\n"
					+ "<p>Bienvenido "+ name + "</p>");
			out.println(
					"<table border='1' class=\"tabla\">\n"
					+ "	<tr>\n"
					+ "		<td>\n"
					+ "			Id_Articulo\n"
					+ "		</td>\n"
					+ "		<td>\n"
					+ "			Nombre\n"
					+ "		</td>\n"
					+ "		<td>\n"
					+ "			Descripcion\n"
					+ "		</td>\n"
					+ "		<td>\n"
					+ "			Precio\n"
					+ "		</td>\n"
					+ "		<td>\n"
					+ "			Categoria\n"
					+ "		</td>	\n"
					+ "	</tr>\n");
			for(Articles a:listaArticulos) {
				out.print("<tr>\n"
						+"<td>\n"
						+a.getId()+"\n"
						+"</td>\n"
						+"<td>\n"
						+a.getNombre()+"\n"
						+"</td>\n"
						+"<td>\n"
						+a.getDescripcion()+"\n"
						+"</td>\n"
						+"<td>\n"
						+a.getPrecio()+"\n"
						+"</td>\n"
						+"<td>\n"
						+a.getCategoria().getNombre()+"\n"
						+"</td>\n"
						+"</tr>\n"
						);
				
			}
					
					out.println("\n"
					+ "</table>"
					+ "</body>\n"
					+ "</html>  ");
		}
		else {
			response.sendRedirect("error.jsp");
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
