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

import com.miTienda.Categoria.Categoria;
import com.miTienda.User.User;

public class CrudCategoria {

	
	public CrudCategoria() {
		super();
	
	}
	
	public static Categoria readCategoria(int id) {
		Session session = connection.getSession();
		Categoria u=null;
		try {
			u= (Categoria) session.get(Categoria.class,id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}
	public static boolean addCategoria(Categoria s) {
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
	
	public static boolean deleteCategoria(Categoria s) {
		boolean resultado=false;
		Session session = connection.getSession();
		try {
			Categoria sNew= (Categoria) session.get(Categoria.class,s.getId());
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
	
	public static List<Categoria> loadList(){
		Session session = connection.getSession();
		List<Categoria> list= new ArrayList<>();
		Query query=session.createQuery("SELECT u FROM CATEGORIA u");
		list= query.getResultList();
		return list;
		
	}
}
