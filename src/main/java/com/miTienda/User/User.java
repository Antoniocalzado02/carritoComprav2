package com.miTienda.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USUARIO")

public class User {
	@Id
	@Column (name="nickname")
	private String nickname;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellidos")
	private String apellidos;
	@Column (name="email")
	private String email;
	@Column (name="contrasena")
	private String contrasena;
	@Column (name="fecha_nac")
	private Date fecha_nac;
	@Column (name="genero")
	private String genero;
	@Column (name="es_admin")
	private boolean es_admin;
	
	
	public User(String userName, String passWord) {
		super();
		this.nickname = userName;
		this.contrasena = passWord;
	}
	
	
	
	public User(String nickname, String nombre, String apellidos, String email, String contrasena, Date fecha_nac,
			String genero) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasena = contrasena;
		this.fecha_nac = fecha_nac;
		this.genero = genero;
		this.es_admin = false;
	}





	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getContrasena() {
		return contrasena;
	}




	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}




	public Date getFecha_nac() {
		return fecha_nac;
	}




	public void setFecha_nac(Date releasedate) {
		this.fecha_nac = releasedate;
	}




	public String getGenero() {
		return genero;
	}




	public void setGenero(String genero) {
		this.genero = genero;
	}




	public boolean isEs_admin() {
		return es_admin;
	}




	public void setEs_admin(boolean es_admin) {
		this.es_admin = es_admin;
	}




	@Override
	public int hashCode() {
		return Objects.hash(contrasena, nickname);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contrasena, other.contrasena) && Objects.equals(nickname, other.nickname);
	}




	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", contrasena=" + contrasena + ", fecha_nac=" + fecha_nac + ", genero=" + genero + ", es_admin="
				+ es_admin + "]";
	}
	
	
	




}

