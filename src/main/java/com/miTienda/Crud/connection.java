package com.miTienda.Crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class connection {
	
	private  static StandardServiceRegistry sr =new StandardServiceRegistryBuilder().configure().build();
	private static SessionFactory sf=new MetadataSources(sr).buildMetadata().buildSessionFactory();
	private static Session session =sf.openSession();
	
	public static Session getSession() {
		return session;
	}

}
