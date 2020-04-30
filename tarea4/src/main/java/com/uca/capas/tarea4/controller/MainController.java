package com.uca.capas.tarea4.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea4.domain.Producto;


@Controller
public class MainController {
	@RequestMapping("/producto")
	public ModelAndView nuevoAlumno() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto",new Producto());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/parametros")
	public ModelAndView parametros(@Valid @ModelAttribute Producto producto, BindingResult result){
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("index");
		}else {
			mav.addObject("codigo",producto.getCodigo());
			mav.addObject("nombre",producto.getNombreProducto());
			mav.addObject("marca",producto.getMarca());
			mav.addObject("descripcion",producto.getDescripcion());
			mav.addObject("existencias",producto.getExistencias());
			mav.addObject("ingreso",producto.getFechaDeIngreso());
			mav.setViewName("success");
		}
		
		return mav;
		
	}
	
}
