package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Producto;
import com.uca.capas.domain.Robot;


@Controller
public class MainController {
	@RequestMapping("/producto")
	public ModelAndView initMain() {
		Producto producto = new Producto();
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("producto", producto);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/formProducto")
	public ModelAndView formProdcto(@Valid @ModelAttribute Producto producto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(!result.hasErrors()) {
			Robot robot = new Robot();
			
			mav.addObject("robot", robot);
			mav.setViewName("robot");
			
			return mav;
		}
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/seguridad")
	public ModelAndView formSeguridad(@Valid @ModelAttribute Robot robot, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(!result.hasErrors()) {
			mav.setViewName("exito");
			return mav;
		}
		
		mav.setViewName("robot");
		
		return mav;
	}

}
