package com.miTienda.Crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.miTienda.Articles.Articles;
import com.miTienda.Categoria.Categoria;
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
	
	public static List<UsuarioArticles> loadList(){
		Session session = connection.getSession();
		List<UsuarioArticles> list= new ArrayList<>();
		Query query=session.createQuery("SELECT ua FROM USUARIO_ARTICLES ua ORDER BY date_buy ASC");
		list= query.getResultList();
		return list;
		
	}

}
