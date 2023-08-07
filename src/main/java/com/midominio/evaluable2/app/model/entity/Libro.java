package com.midominio.evaluable2.app.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Has metido un nombre muy largo, máximo 15 carácteres")
	@Size(min = 4, max = 15) // Número de caracteres
	@Column(name = "nombre")
	private String nombre;

	@NotEmpty(message = "Has metido unos apellidos muy largos, máximo 32 carácteres")
	@Size(min = 4, max = 32)
	@Column(name = "autor")
	private String autor;

	@NotEmpty(message = "Has metido un nombre muy largo, máximo 15 carácteres")
	@Size(min = 4, max = 15) // Número de caracteres
	@Column(name = "genero")
	private String genero;

	@NotNull // equivalente a NotEmpty pero para los que no son String
	@Column(name = "numero_ejemplares")
	private int numero_ejemplares;

	@NotEmpty(message = "Has metido un nombre muy largo, máximo 15 carácteres")
	@Size(min = 10, max = 15) // Número de caracteres
	@Column(name = "ISBN")
	private String ISBN;

	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumero_ejemplares() {
		return numero_ejemplares;
	}

	public void setNumero_ejemplares(int numero_ejemplares) {
		this.numero_ejemplares = numero_ejemplares;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Libro() {

	}

}
