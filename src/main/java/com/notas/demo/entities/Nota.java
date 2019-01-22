package com.notas.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author desarrollo9
 *
 */
@Table(name="Nota")
@Entity
public class Nota implements Serializable {

	//se pone de Private para poder acceder a ellos por medio de get and set
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="contenido")
	private String contenido;
	
	//Generar Constructor vacio
	public Nota() {
		
	}
	
	public Nota(long id, String nombre, String titulo, String contenido) {
		//Se debe borar el super 
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", nombre=" + nombre + ", titulo=" + titulo + ", contenido=" + contenido + "]";
	}


	
	

	
}
