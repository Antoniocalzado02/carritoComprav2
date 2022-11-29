package com.miTienda.Servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miTienda.Articles.Articles;
import com.miTienda.CarritoCompra.Carrito;
import com.miTienda.CarritoCompra.itemCarrito;
import com.miTienda.Crud.CrudArticles;
import com.miTienda.Crud.CrudCarrito;
import com.miTienda.Crud.CrudUser;
import com.miTienda.User.User;
import com.miTienda.UsuarioArticles.UsuarioArticles;

/**
 * Servlet implementation class addListaCompra
 */
@WebServlet("/addListaCompra")
public class addListaCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addListaCompra() {
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
		
		//Obtengo el usuario de la sesison
		User u=CrudUser.readUser((String)sesion.getAttribute("usuario"));
		
		
		Carrito carritoCompra=(Carrito) sesion.getAttribute("carroCompra");
		
		for(itemCarrito a: carritoCompra.getListCarrito()) {
			Articles article=CrudArticles.readArticle(a.getId_article());
			
			UsuarioArticles c=new UsuarioArticles(article, u, a.getPrice(), a.getQuantity(), a.getFecha());
			CrudArticles.updateArticleStock(article.getId(), a.getQuantity());
			CrudCarrito.addUsuarioArticle(c);
			
			
		}
		carritoCompra.vaciarLista();
		response.sendRedirect("annadidoCorrectamente.jsp");
	}

}
