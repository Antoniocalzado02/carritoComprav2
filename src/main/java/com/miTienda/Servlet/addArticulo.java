package com.miTienda.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

import com.miTienda.Articles.Articles;
import com.miTienda.Categoria.Categoria;
import com.miTienda.Crud.CrudArticles;
import com.miTienda.Crud.CrudCategoria;

/**
 * Servlet implementation class addArticulo
 */
@WebServlet("/addArticulo")
public class addArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addArticulo() {
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
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Double price=Double.parseDouble(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		Categoria c=CrudCategoria.readCategoria(Integer.parseInt(request.getParameter("categorie")));
		
		
		
		
		PrintWriter out=response.getWriter();
		Boolean error=false;
		int msgError=0;
		
		
		if(name==null || name.isEmpty() || description==null || description.isEmpty() || price==null) {
			error=true;
			msgError=5;
		}
		
		if(error) {
			response.sendRedirect("error.jsp?msg="+msgError);
		}
		else {
			Articles a= new Articles(name, description, price,quantity, c);
			CrudArticles.addArticle(a);
			response.sendRedirect("loginExec");
			
		}
	}

}
