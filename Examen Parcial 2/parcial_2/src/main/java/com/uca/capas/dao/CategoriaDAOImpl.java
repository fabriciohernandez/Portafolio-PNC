package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> resulset = query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void insert(Categoria categoria) throws DataAccessException {
		entityManager.persist(categoria);	
		
	}

}
