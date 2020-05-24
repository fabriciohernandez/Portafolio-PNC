package com.uca.capas.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)
	@Column(name="c_contribuyente")
	private Integer c_contribuyente;
	
	@Column(name="c_importancia")
	private Integer c_importancia;
	
	@Column(name="s_nombre")
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El nombre no debe tener mas de 30 caracteres", max=30)
	private String s_nombre;
	
	@Column(name="s_apellido")
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El apellido no debe tener mas de 30 caracteres", max=30)
	private String s_apellido;
	
	@Column(name="s_nit")
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El nombre no debe tener mas de 14 caracteres", max=14)
	private String s_nit;
	
	@Column(name="f_fecha_ingreso")
	private Date f_fecha_ingreso = this.getFechaActualDelegate();
	
	//Relacion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia", insertable = false, updatable = false)
	private Importancia importancia;
	
	public Contribuyente() {
		
	}

	public Integer getC_contribuyente() {
		return c_contribuyente;
	}

	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public Integer getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public String getS_nit() {
		return s_nit;
	}

	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}

	public Date getF_fecha_ingreso() {
		return f_fecha_ingreso;
	}

	public void setF_fecha_ingreso(Date f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}
	
	
	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	//Funcion delegate para asignar fecha actual
	public Date getFechaActualDelegate() {
		Date date = new Date();
		return date;
	}
	
	public String getImportanciaDelegate() {
		return this.getImportancia().getS_importancia();
	}
	
	
}
