package com.uca.capas.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;


@Service
public class EstudianteServiceImpl implements EstudianteService {
	@Autowired
	private EstudianteRepo estudianteRepo;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteRepo.findAll();
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.save(estudiante);
		
	}

	@Override
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		estudianteRepo.deleteById(codigoEstudiante);
		
	}
	
	@Override
	public List<Estudiante> filtrar(String cadena) throws DataAccessException {
		return estudianteRepo.findByNombre(cadena);
		
	}

	@Override
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException {
		return estudianteRepo.mostrarTodos(cadena);
	}

	@Override
	public Estudiante findOne(Integer id) throws DataAccessException {
		return estudianteRepo.getOne(id);
	}

}
