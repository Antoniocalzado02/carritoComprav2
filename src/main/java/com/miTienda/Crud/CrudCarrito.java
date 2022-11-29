package com.miTienda.Crud;

import org.hibernate.Session;

import com.miTienda.Articles.Articles;
import com.miTienda.UsuarioArticles.UsuarioArticles;

public class CrudCarrito {
	public CrudCarrito() {
		super();
	}
	
	public static boolean addUsuarioArticle(UsuarioArticles s) {
		boolean resultado=false;
		Session session = connection.getSession();
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(s);
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

}
