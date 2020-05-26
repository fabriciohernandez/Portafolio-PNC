package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("index");
		return mav;
	}	
	
	@RequestMapping("/nuevaCategoria")
	public ModelAndView nuevaCategoria() {
		
		Categoria categoria = new Categoria();
		
		ModelAndView mav = new ModelAndView();	
		mav.addObject("categoria",categoria);
		mav.setViewName("nuevaCategoria");
		return mav;
	}	
	
	@RequestMapping("/formCategoria")
	public ModelAndView formCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				categoriaService.insert(categoria);
				mav.addObject("success_msg","Categoria guardada con éxito.");
				mav.setViewName("index");
				return mav;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		//System.out.println(result.getFieldErrors());
		mav.setViewName("nuevaCategoria");
		return mav;
	}
	
	@RequestMapping("/nuevoLibro")
	public ModelAndView nuevoLibro() {
		Libro libro = new Libro();
		List<Categoria> categorias = null;
		
		categorias = categoriaService.findAll();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("libro",libro);
		mav.addObject("categorias",categorias);
		
		mav.setViewName("nuevoLibro");
		return mav;
	}	
	
	@RequestMapping("/formLibro")
	public ModelAndView formLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				libroService.insert(libro);
				mav.addObject("success_msg","Libro guardado con éxito.");
				mav.setViewName("index");
				return mav;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		//System.out.println(result.getFieldErrors());
		List<Categoria> categorias = null;
		categorias = categoriaService.findAll();
		mav.addObject("categorias",categorias);
		mav.setViewName("nuevoLibro");
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView verLibros() {
		
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		
		try {
			libros = libroService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libros",libros);
		mav.setViewName("verLibros");
		return mav;
	}	
	
}
