package com.miTienda.Crud;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.miTienda.User.User;



public class CrudUser {
	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private static Session session;
	
	public CrudUser() {
		super();
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	
	public static User readUser(String username) {
		User u=null;
		try {
			u= (User) session.get(User.class,username);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}
	public boolean addUser(User s) {
		boolean resultado=false;
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
	
	public boolean deleteUser(User s) {
		boolean resultado=false;
		try {
			User sNew= (User) session.get(User.class,s.getNickname());
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
	
	public static List<User> loadList(){

		List<User> list= new ArrayList<>();
		Query query=session.createQuery("SELECT u FROM USUARIO u");
		list= query.getResultList();
		return list;
		
	}
	
}
