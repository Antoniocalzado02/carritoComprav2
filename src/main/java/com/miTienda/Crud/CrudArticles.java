package com.miTienda.Crud;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.miTienda.Articles.Articles;
import com.miTienda.User.User;

public class CrudArticles {
	
	
	public CrudArticles() {
		super();
	}
	
	public static Articles readArticle(int id) {
		Session session = connection.getSession();
		Articles u=null;
		try {
			u= (Articles) session.get(Articles.class,id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}
	public static boolean addArticle(Articles s) {
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
	
	public boolean deleteUser(Articles s) {
		boolean resultado=false;
		Session session = connection.getSession();
		try {
			Articles sNew= (Articles) session.get(Articles.class,s.getId());
			session.getTransaction().begin();
			session.delete(sNew);	
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public boolean updateShoe(User s, String nombre, String apellido, String email, Date releasedate, boolean stock) {
		boolean resultado=false;
		Session session = connection.getSession();
		try {
			User sNew= (User) session.get(User.class,s.getNickname());
			sNew.setNombre(nombre);
			sNew.setApellidos(apellido);
			sNew.setEmail(email);
			sNew.setFecha_nac(releasedate);
			sNew.setEs_admin(stock);
			
			session.getTransaction().begin();
			session.saveOrUpdate(sNew);
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public static List<Articles> loadList(){
		Session session = connection.getSession();
		List<Articles> list= new ArrayList<>();
		Query query=session.createQuery("SELECT u FROM ARTICLES u");
		list= query.getResultList();
		return list;
		
	}
	
	public static void updateArticleStock(int id, Integer stock) {
        Session session = connection.getSession();
        Articles p = (Articles) session.get(Articles.class, id);
        System.out.println(p.getQuantity()-stock);
        p.setQuantity(p.getQuantity()-stock);
        System.out.println(p.getQuantity()-stock);
        try {
            session.getTransaction().begin();
            session.save(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

}
