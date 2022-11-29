package com.miTienda.UsuarioArticles;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Usuario_ArticlesJoin implements Serializable{
	
	private String name_usuario;
	private int id_article;
	private LocalDateTime date_buy;
	

	public Usuario_ArticlesJoin() {
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




	public LocalDateTime getDate_buy() {
		return date_buy;
	}




	public void setDate_buy(LocalDateTime date_buy) {
		this.date_buy = date_buy;
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
		Usuario_ArticlesJoin other = (Usuario_ArticlesJoin) obj;
		return Objects.equals(id_article, other.id_article) && Objects.equals(name_usuario, other.name_usuario);
	}
	
	

}
