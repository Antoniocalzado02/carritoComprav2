package com.miTienda.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miTienda.Articles.Articles;
import com.miTienda.CarritoCompra.Carrito;
import com.miTienda.CarritoCompra.itemCarrito;
import com.miTienda.Crud.CrudUser;
import com.miTienda.User.User;

/**
 * Servlet implementation class carritoExec
 */
@WebServlet("/carritoExec")
public class carritoExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public carritoExec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		
		User u=CrudUser.readUser((String)session.getAttribute("usuario"));
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
				+ "<p align=\"center\">Bienvenido "+ u.getNickname() + "</p>"
				+ "<img src=\"imagenes/logo.png\" class=\"logo\" width=\"50px\" align=\"center\">\n"
				+ "<br>"
				+ "<br>"
				+"</header>"
				+"<body>"
				+"<div>"
				+"<h1>Tengo que hacer el jsp</h1>"
				+"<div>"
				+ "</body>"
				+ "</html>  ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		Carrito carritoCompra;
		
		HttpSession session=request.getSession();
		
		
		User u=CrudUser.readUser((String)session.getAttribute("usuario"));
		
		carritoCompra=(Carrito) session.getAttribute("carroCompra");
		
		if(carritoCompra==null) {
			carritoCompra=new Carrito();
			session.setAttribute("carroCompra", carritoCompra);
			
		}
		
		String userName=request.getParameter("nameUser");
		int id=Integer.parseInt(request.getParameter("id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		double price=Double.parseDouble(request.getParameter("price"));
		
		itemCarrito c=new itemCarrito(userName,id,quantity,price);
		
		carritoCompra.addItemCarrito(c);
		
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
				+ "<p align=\"center\">Bienvenido "+ u.getNickname() + "</p>"
				+ "<img src=\"imagenes/logo.png\" class=\"logo\" width=\"50px\" align=\"center\">\n"
				+ "<br>"
				+ "<br>"
				+"</header>"
				+"<body>"
				+"<div>"
				+"<h1>Añadido correctamente</h1>"
				+"<a href='loginExec'>Volver al inicio</a>"
				+"<div>"
				+ "</body>"
				+ "</html>  ");
		
	}

}
