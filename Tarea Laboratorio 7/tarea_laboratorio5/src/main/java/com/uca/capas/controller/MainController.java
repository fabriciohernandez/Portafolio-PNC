package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		Estudiante estudiante = new Estudiante();
		ModelAndView mav = new ModelAndView();	
		
		mav.addObject("estudiante",estudiante);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/formEstudiante")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		if(!result.hasErrors()) {
			try {
				estudianteService.insert(estudiante);
				estudiantes = estudianteService.findAll();
				mav.addObject("estudiantes",estudiantes);
				mav.setViewName("listado");
				return mav;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		//System.out.println(result.getFieldErrors());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/formBorrarEstudiante")
	public ModelAndView formBorrarEstudiante(@RequestParam(value="codigo") int codigo) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(codigo);
			estudiantes = estudianteService.findAll();
			mav.addObject("estudiantes",estudiantes);
			mav.setViewName("listado");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/formFiltrarEstudiante")
	public ModelAndView formFiltrarEstudiante(@RequestParam(value="cadena") String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.empiezaCon(cadena);
			mav.addObject("estudiantes",estudiantes);
			mav.setViewName("listado");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/formPreEditarEstudiante")
	public ModelAndView formPreEditarEstudiante(@RequestParam(value="id") Integer id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteService.findOne(id);
			mav.addObject("estudiante",estudiante);
			mav.setViewName("edit");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("index");
		return mav;
	}
}
