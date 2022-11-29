package com.miTienda.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miTienda.CarritoCompra.Carrito;
import com.miTienda.CarritoCompra.itemCarrito;
import com.miTienda.Crud.CrudUser;
import com.miTienda.User.User;

/**
 * Servlet implementation class updateQuantity
 */
@WebServlet("/updateQuantity")
public class updateQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateQuantity() {
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
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession();
		
		//Obtengo el usuario de la seison
		User u=CrudUser.readUser((String)sesion.getAttribute("usuario"));
		
		Carrito carritoCompra;
		carritoCompra=(Carrito) sesion.getAttribute("carroCompra");
	
		//Recojo los valores del item
		String cantidad=request.getParameter("updateQuantity");
		String idItem=request.getParameter("idItem");
		
		for(itemCarrito c: carritoCompra.getListCarrito()) {
			if(c.getId_article()==Integer.parseInt(idItem)) {
				c.setQuantity(Integer.parseInt(cantidad));
			}
		}
		response.sendRedirect("CarritoCompra.jsp");

	}

}
