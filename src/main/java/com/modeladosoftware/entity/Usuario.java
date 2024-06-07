package com.modeladosoftware.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Anotaciones para que HIBERNATE se comunique con con la DB de MySQL
@Entity
@Table(name="usuario")
public class Usuario {
	
	// Atributos
	
	@Id			// Identificar la clave primaria en el mapeo relacional de objetos (ORM)	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	// La clave primaria se generará automáticamente a través de la DB.
	@Column(name="id")			// Mapea un campo Java a una columna en la tabla de la DB.
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	// Métodos
	
	@Override
	public String toString() {		// Convierte al objeto en una cadena de texto
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", password=" + password + "]";
	}
	
	// Constructor vacío
	public Usuario() {
		
	}
	
	// Constuctor con parámetros
	public Usuario(Long id, String nombre, String apellido, String telefono, String email, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}
	public void setId(Long i) {
		this.id = i;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
