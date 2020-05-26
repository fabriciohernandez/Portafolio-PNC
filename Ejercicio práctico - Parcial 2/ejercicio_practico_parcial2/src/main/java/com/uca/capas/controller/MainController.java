package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@Autowired
	private ImportanciaService importanciaService;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> importancias = null;
		
		ModelAndView mav = new ModelAndView();	
		importancias = importanciaService.findAll();
		
		System.out.println(contribuyente.getFechaActualDelegate().toString());
		
		mav.addObject("contribuyente",contribuyente);
		mav.addObject("importancias",importancias);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/contribuyentes")
	public ModelAndView verContribuyentes() {
		
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		
		try {
			contribuyentes = contribuyenteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes",contribuyentes);
		mav.setViewName("contribuyentes");
		return mav;
	}
	
	@RequestMapping("/formContribuyente")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				contribuyenteService.insert(contribuyente);
				mav.setViewName("success");
				return mav;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		//System.out.println(result.getFieldErrors());
		List<Importancia> importancias = null;
		importancias = importanciaService.findAll();
		mav.addObject("importancias",importancias);
		mav.setViewName("index");
		return mav;
	}
	
}
