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
	private String Nombre;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El apellido no debe tener mas de 50 caracteres", max=50)
	@Column(name="apellido")
	private String Apellido;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El carnet debe tener exactamente 8 caracteres", min=8, max=8)
	@Column(name="carne")
	private String Carnet;
	
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "La carrera no debe tener mas de 100 caracteres", max=100)
	@Column(name="carrera")
	private String Carrera;
	
	public Estudiante() {
		
	}
	
	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCarnet() {
		return Carnet;
	}
	public void setCarnet(String carnet) {
		Carnet = carnet;
	}
	public String getCarrera() {
		return Carrera;
	}
	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	
}
