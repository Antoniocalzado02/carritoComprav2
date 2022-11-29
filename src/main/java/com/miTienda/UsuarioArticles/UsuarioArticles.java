package com.miTienda.UsuarioArticles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.miTienda.Articles.Articles;
import com.miTienda.User.User;


@Entity (name="USUARIO_ARTICLES")
@IdClass(Usuario_ArticlesJoin.class)
public class UsuarioArticles {
	@Id
	@ManyToOne
	@JoinColumn (name="id_article", insertable=false, updatable=false)
	private Articles id_article;
	
	
	@Id
	@ManyToOne
	@JoinColumn (name="name_usuario", insertable=false, updatable=false)
	private User name_usuario;
	
	@Id
	@Column (name="date_buy")
	private LocalDateTime date_buy;
	
	@Column (name="price")
	private Double price;
	@Column (name="quantity")
	private int quantity;
	
	
	public UsuarioArticles(Articles id_article, User name_usuario, Double price, int quantity, LocalDateTime date_buy) {
		super();
		this.id_article = id_article;
		this.name_usuario = name_usuario;
		this.price = price;
		this.quantity = quantity;
		this.date_buy = date_buy;
	}
	
	public UsuarioArticles() {
		super();
	}



	public Articles getId_article() {
		return id_article;
	}



	public void setId_article(Articles id_article) {
		this.id_article = id_article;
	}



	public User getName_usuario() {
		return name_usuario;
	}



	public void setName_usuario(User name_usuario) {
		this.name_usuario = name_usuario;
	}



	public LocalDateTime getDate_buy() {
		return date_buy;
	}



	public void setDate_buy(LocalDateTime date_buy) {
		this.date_buy = date_buy;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_article);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioArticles other = (UsuarioArticles) obj;
		return Objects.equals(id_article, other.id_article);
	}


	@Override
	public String toString() {
		return "UsuarioArticles [id_article=" + id_article + ", name_usuario=" + name_usuario + ", price=" + price
				+ ", quantity=" + quantity + ", date_buy=" + date_buy + "]";
	}
	
	
	
	

}
