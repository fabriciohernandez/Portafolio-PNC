package com.uca.capas.tarea3.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	@RequestMapping("/ingresar")
	public ModelAndView nuevoAlumno() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/parametros")
	public ModelAndView parametros(HttpServletRequest request) throws ParseException{
		ModelAndView mav = new ModelAndView();
		
		String nombres = request.getParameter("nombres");
		
		String apellidos = request.getParameter("apellidos");
		
		String fecha_nacimiento = request.getParameter("fecha_nacimiento");
		
		System.out.println(fecha_nacimiento);
		
		Date fechaNacimientoDate=new SimpleDateFormat("dd-MM-yyyy").parse(fecha_nacimiento);  
		Date limiteEdad=new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2003");  
		
		String lugar_nacimiento = request.getParameter("lugar_nacimiento");
		
		String colegio = request.getParameter("colegio");
		
		String telefono_fijo = request.getParameter("telefono_fijo");
		
		String telefono_movil = request.getParameter("telefono_movil");
		
		System.out.println(nombres);
		
		List<String> errores = new ArrayList<>();
		
		if(nombres.length() < 1 || nombres.length() > 25) {
			errores.add("El campo nombres debe ser mayor a un caracter y menor a 25 caracteres.");
		}
		if(apellidos.length() < 1 || apellidos.length() > 25) {
			errores.add("El campo apellidos debe ser mayor a un caracter y menor a 25 caracteres.");
		}
		if(fechaNacimientoDate.after(limiteEdad)) {
			errores.add("El campo fecha de nacimiento no puede ser mayor al 1 de Enero de 2003");
		}
		if(lugar_nacimiento.length() < 1 || lugar_nacimiento.length() > 25) {
			errores.add("El campo lugar de nacimiento debe ser mayor a un caracter y menor a 25 caracteres.");
		}
		if(colegio.length() < 1 || colegio.length() > 25) {
			errores.add("El campo Instituto o colegio de procedencia no debe ser mayor a un caracter y menor a 100 caracteres.");
		}
		if(telefono_fijo.length() != 8) {
			errores.add("El campo telefono fijo debe tener exactamente 8 digitos");
		}
		if(telefono_movil.length() != 8) {
			errores.add("El campo telefono movil debe tener exactamente 8 digitos");
		}
		
		
	
		if(errores.size() != 0) {
			mav.addObject("errores",errores);
			mav.setViewName("errores");
		}else {
			mav.setViewName("success");
		}
		
		return mav;
		
	}
	
}
