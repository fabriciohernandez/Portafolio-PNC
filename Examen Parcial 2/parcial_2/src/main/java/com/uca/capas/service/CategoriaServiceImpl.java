package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Categoria categoria) throws DataAccessException {
		categoriaDAO.insert(categoria);
		
	}

}
