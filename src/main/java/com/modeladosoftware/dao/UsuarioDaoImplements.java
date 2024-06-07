package com.modeladosoftware.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.modeladosoftware.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioDaoImplements implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Usuario> obtenerListaUsuarios() {
		
		// Consulta HIBERNATE, simula consulta SQL
		// No trabaja con DB real, sino con Usuario.java
		String query = "from Usuario";
		
		return entityManager.createQuery(query).getResultList();	
	}
}
