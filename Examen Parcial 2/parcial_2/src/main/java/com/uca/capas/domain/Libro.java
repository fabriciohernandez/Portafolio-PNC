package com.uca.capas.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
	@Column(name="c_libro")
	private Integer c_libro;
	
	@Column(name="s_titulo")
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El título no debe tener mas de 500 caracteres", max=500)
	private String s_titulo;
	
	@Column(name="s_autor")
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "El nombre del autor no debe tener mas de 150 caracteres", max=150)
	private String s_autor;
	
	@Column(name="c_categoria")
	private Integer c_categoria;
	
	@Column(name="f_ingreso")
	private Date f_ingreso = this.getFechaActualDelegate();
	
	@Column(name="b_estado")
	private Boolean b_estado;
	
	@Column(name="s_isbn")
	@NotEmpty(message = "Este campo no puede estar vacio.")
	@Size(message = "ISBN no debe tener mas de 10 caracteres", max=10)
	private String s_isbn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria", insertable = false, updatable = false)
	private Categoria categoria;
	
	public Libro() {
		
	
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public Date getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoriaDelegate() {
		return this.getCategoria().getS_categoria();
	}
	
	public Date getFechaActualDelegate() {
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");  
	    String strDate= formatter.format(date);  
	    System.out.println(strDate);
	    
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy hh:mm a").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	    
	    return date1; 
	}
	
	public String getFechaFormated() {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");  
	    String strDate= formatter.format(this.f_ingreso);  
	    System.out.println(strDate);
	    
	    return strDate; 
	}
	
	
}
