package com.midominio.evaluable2.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Has metidos un nombre muy largo, máximo 15 carácteres")
	@Size(min = 4, max = 15) // Número de caracteres
	@Column(name = "nombre")
	private String nombre;

	@NotEmpty(message = "Has metidos unos apellidos muy largos, máximo 32 carácteres")
	@Size(min = 4, max = 32)
	@Column(name = "apellidos")
	private String apellidos;

	@NotNull // equivalente a NotEmpty pero para los que no son String
	@Column(name = "edad")
	private int edad;

	@NotNull // equivalente a NotEmpty pero para los que no son String
	@Column(name = "fecha_alta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha_alta;
	
	@NotNull // equivalente a NotEmpty pero para los que no son String
	@Column(name = "fecha_retirada_libro")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha_retirada_libro;
	
	@NotNull // equivalente a NotEmpty pero para los que no son String
	@Column(name = "fecha_entrega_libro")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha_entrega_libro;
	
	private String foto;

	@PrePersist
	// Antes de persistir en base de datos los objetos aladen la fecha de inserción
	public void prePersist1() {
		fecha_alta = fecha_alta != null ? fecha_alta : LocalDate.now();
		fecha_retirada_libro = fecha_retirada_libro != null ? fecha_retirada_libro : LocalDate.now();
		fecha_entrega_libro = fecha_entrega_libro != null ? fecha_entrega_libro : LocalDate.now();
	}
	

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

	

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public LocalDate getFecha_retirada_libro() {
		return fecha_retirada_libro;
	}

	public void setFecha_retirada_libro(LocalDate fecha_retirada_libro) {
		this.fecha_retirada_libro = fecha_retirada_libro;
	}

	public LocalDate getFecha_entrega_libro() {
		return fecha_entrega_libro;
	}

	public void setFecha_entrega_libro(LocalDate fecha_entrega_libro) {
		this.fecha_entrega_libro = fecha_entrega_libro;
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

	public Usuario() {

	}

}
