package com.uca.capas.tarea3.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea3.domain.Product;


@Controller
public class ProductoController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView nuevoProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0,"MW",50));
		productos.add(new Product(1,"Minecraft",10));
		productos.add(new Product(2,"RE3",30));
		productos.add(new Product(3,"Overwatch",20));
		productos.add(new Product(4,"MW3",5));
		
		mav.setViewName("index");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView parametros(Product product){
		ModelAndView mav = new ModelAndView();
	
		
		Integer cantidad = productos.get(product.getId()).getCantidad();
		Integer cantidadIngresada = product.getCantidad();
		
		if(cantidadIngresada > cantidad) {
			mav.setViewName("error");
			mav.addObject("error", "El producto " + productos.get(product.getId()).getNombre() + " no se puede comprar");
			return mav;
		}
		
		mav.setViewName("compra");
		mav.addObject("comprado", "El producto " + productos.get(product.getId()).getNombre() + " se adquirio");
		
		return mav;
		
	}
}
