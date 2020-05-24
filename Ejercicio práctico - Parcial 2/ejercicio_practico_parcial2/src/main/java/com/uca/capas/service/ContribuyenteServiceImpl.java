package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	private ContribuyenteDAO contribuyenteDAO;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		contribuyenteDAO.insert(contribuyente);
		
	}

}
