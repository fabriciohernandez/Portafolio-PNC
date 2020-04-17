package com.uca.capas.tarea2.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/alumno")
	public @ResponseBody String ejemplo() {
		String nombre = "Fabricio";
		String apellido = "Hernandez";
		String carnet = "00163217";
		String carrera = "Ing. Informatica";
		String anio = "4 Anio";
		
		return "Nombre: " + nombre 
				+ "<br/> Apellido: " + apellido 
				+ "<br/> Carnet: " + carnet 
				+ "<br/>Carrera: " + carrera 
				+ "<br/> año: " + anio ;
	}
	
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer dia = Integer.parseInt(request.getParameter("dia"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer año = Integer.parseInt(request.getParameter("año"));
		
		String diObtenido = diaSemana(dia,mes,año);
		
		
		return "Dia se la semana enviado para la fecha " +dia+"-"+mes+"-"+año+ " es: "+ diObtenido;
		
	}
	
	private String diaSemana (int dia, int mes, int ano)
    {
        String letraD="";
        TimeZone timezone = TimeZone.getDefault();
        Calendar calendar = new GregorianCalendar(timezone);
        calendar.set(ano, mes-1, dia);
        int nD=calendar.get(Calendar.DAY_OF_WEEK);
        switch (nD){
            case 1: letraD = "DOMINGO";
                break;
            case 2: letraD = "LUNES";
                break;
            case 3: letraD = "MARTES";
                break;
            case 4: letraD = "MIERCOLES";
                break;
            case 5: letraD = "JUEVES";
                break;
            case 6: letraD = "VIERNES";
                break;
            case 7: letraD = "SABADO";
                break;
        }

        return letraD;
    }

}
