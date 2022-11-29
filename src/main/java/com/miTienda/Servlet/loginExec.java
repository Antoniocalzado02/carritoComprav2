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
import com.miTienda.CarritoCompra.Carrito;
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
				
				int contador=0;
				
				HttpSession sesion=request.getSession();
				
				Carrito carritoCompra;
				carritoCompra=(Carrito) sesion.getAttribute("carroCompra");
				
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
						if(carritoCompra==null) {
							carritoCompra=new Carrito();
							sesion.setAttribute("carroCompra", carritoCompra);
						}
						
					}
				}
				
		
		if (!error) {			
			
			PrintWriter out=response.getWriter();
			List<Articles> listaArticulos= CrudArticles.loadList();
			
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
					+ "<header class=\"cabecera\">"
					+ "<p align=\"center\">Logueado: "+ name + "</p>"
					+ "<img src=\"imagenes/logo.png\" class=\"logo\" width=\"50px\" align=\"center\">\n"
					+ "<br>"
					+ "<br>"
					+ "<a href=mostrarListado.jsp align=\"center\"><button class=\"btn\">Mostrar Listado</button></a>)"
					+ "<a href=cerrarSesion.jsp align=\"center\"><button class=\"btn\">Cerrar Sesion</button></a>");
					if(u.isEs_admin()==true) {
						response.getWriter().append("<a href=addArticulo.jsp align=\"center\"><button class=\"btn\">Add Articulo</button></a>");
					}
					out.println("<br>"
					+"<a href=CarritoCompra.jsp><img src=\"imagenes/carrito.png\" class=\"carrito\" width=\"50px\" align=\"center\"></a>\n"
					+"<p>"+carritoCompra.getCantidadTotal()+"</p>");
					out.println("</header>");
			out.println(
					"<table border='1' class=\"tabla\">\n"
					+"<div class=\"padre\">");
			for(Articles a:listaArticulos) {
				out.print(
							"<div class=\"hijo\">"
								
								+"<h3>Name:  "+a.getNombre()+"</h3>"+"<br>"
								
								+"<p>Description:  "+a.getDescripcion()+"</p>"+"<br>"
								
								+"<p>Price:  "+a.getPrecio()+"$</p>"+"<br>"
								
								+"<p>Categorie:  "+a.getCategoria().getNombre()+"</p>"+"<br>"
								
								+"<p>Quantity:  "+(a.getQuantity())+"</p>"+"<br>"
								+"<form id=\"form\" method=\"post\" action=\"carritoExec\" border=\"3px\">"
								+	"<input type='text' value="+u.getNickname()+" hidden name='nameUser'>"
								+	"<input type='number' value="+a.getId()+" hidden name='id'>"
								+	"<input type='number' name='quantity' value='1' min='1' max="+a.getQuantity()+">"
								+	"<input type='number' value="+a.getPrecio()+" hidden name='price'>"
								+	"<input type='submit' value='Comprar'>"
								+"</form>"
								+"<br>"
							+"</div>"
						);
				
			}
			out.println("</div>\n");
			contador+=1;
					
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
