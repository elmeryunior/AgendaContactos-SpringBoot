package com.agendacontactos.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Contactos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	@NotBlank(message = "Debe Ingresar su Nombre")
	private String nombre;
	
	@Column(name = "email")
	@NotEmpty(message = "Debe Ingresar su Correo")
	@Email
	private String email;
	
	@Column(name = "celular")
	@NotBlank(message = "Debe Ingresar su Celular")
	private String celular;
	
	@Column(name = "fechaNacimiento")
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe Ingresar la Fecha de nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "fechaReg")
	private LocalDateTime fechaReg;

	public Contactos() {
	}

	public Contactos(Integer id, @NotBlank String nombre, @NotBlank @Email String email, @NotBlank String celular,
			@NotBlank LocalDate fechaNacimiento, @NotBlank LocalDateTime fechaReg) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.celular = celular;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaReg = fechaReg;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDateTime fechaReg) {
		this.fechaReg = fechaReg;
	}
	
	@PrePersist
	public void asignarFechaRegistro() {
		fechaReg = LocalDateTime.now();
	}
	
}
