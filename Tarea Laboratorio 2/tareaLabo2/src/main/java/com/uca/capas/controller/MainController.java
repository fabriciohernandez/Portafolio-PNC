package com.uca.capas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.uca.capas.domain.Usuario;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String enviarForm(Usuario usuario) {
		return "Login";
	}
	
	@PostMapping("/validacion")
	public String procesarForm(Usuario usuario) {
		//user = admin
		//pass = admin
		
		if(usuario.getUsuario().equals("admin") && usuario.getContrasena().equals("admin")) 
		{
			return "MostrarMensajeV";
		}
		else 
		{
			return "MostrarMensajeF";
		}
		
	}

}