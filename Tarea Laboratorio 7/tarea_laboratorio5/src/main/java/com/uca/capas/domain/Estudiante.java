package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoUsuario;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El nombre no debe tener mas de 50 caracteres", max=50)
	@Column(name="nombre")
	private String nombre;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El apellido no debe tener mas de 50 caracteres", max=50)
	@Column(name="apellido")
	private String apellido;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El carnet debe tener exactamente 8 caracteres", min=8, max=8)
	@Column(name="carne")
	private String carnet;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "La carrera no debe tener mas de 100 caracteres", max=100)
	@Column(name="carrera")
	private String carrera;
	
	public Estudiante() {
		
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
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

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
	
	
}
