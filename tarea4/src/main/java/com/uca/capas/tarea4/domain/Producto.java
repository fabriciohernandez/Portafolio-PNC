package com.uca.capas.tarea4.domain;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class Producto {
	@NotNull(message = "El campo Codigo no puede quedar vacio.")
	@Size(min=12, max=12, message = "El campo codigo debe tener exactamente 12 digitos.")
	String codigo;
	
	@NotNull(message = "El campo Nombre Prdoucto no puede quedar vacio.")
	@Size(min=1, max=100, message = "El campo Nombre Producto debe tener una longitud entre 1 y 100 caracteres..")
	String nombreProducto;
	
	@NotNull(message = "El campo Marca no puede quedar vacio.")
	@Size(min=1, max=100, message = "El campo Marca debe tener una longitud entre 1 y 100 caracteres.")
	String marca;
	
	@NotNull(message = "El campo Descripcion no puede quedar vacio.")
	@Size(min=1, max=500, message = "El campo Descripcion debe tener una longitud entre 1 y 500 caracteres.")
	String descripcion;
	
	@Digits(fraction=0, integer = 100, message = "El campo existencias debe ser un numero entero y no estar vacio.")
	String existencias;
	
	@NotNull(message = "El campo fecha no puede quedar vacio.")
	@Pattern(regexp = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$", message = "El campo de fecha debe tener el formato dd/MM/yyyy")
	String fechaDeIngreso;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getExistencias() {
		return existencias;
	}
	public void setExistencias(String existencias) {
		this.existencias = existencias;
	}
	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	
}
