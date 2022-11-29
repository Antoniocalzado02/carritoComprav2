package com.miTienda.CarritoCompra;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class itemCarrito {
	
	private String name_usuario;
	private int id_article;
	private int quantity;
	private double price;
	private LocalDateTime fecha;
	
	
	
	
	public itemCarrito(String name_usuario, int id_article, int quantity, double price) {
		super();
		this.name_usuario = name_usuario;
		this.id_article = id_article;
		this.quantity = quantity;
		this.price = price;
		this.fecha = LocalDateTime.now();
	}
	
	public itemCarrito() {
		super();
	}
	
	
	
	public String getName_usuario() {
		return name_usuario;
	}
	public void setName_usuario(String name_usuario) {
		this.name_usuario = name_usuario;
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_article, name_usuario);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itemCarrito other = (itemCarrito) obj;
		return id_article == other.id_article && Objects.equals(name_usuario, other.name_usuario);
	}



	@Override
	public String toString() {
		return "itemCarrito [name_usuario=" + name_usuario + ", id_article=" + id_article + ", quantity=" + quantity
				+ ", price=" + price + ", fecha=" + fecha + "]";
	}
	
	

}
