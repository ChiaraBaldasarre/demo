package com.modeladosoftware.dao;

import java.util.List;

import com.modeladosoftware.entity.Usuario;

import jakarta.transaction.Transactional;

@Transactional
public interface UsuarioDao {

	List<Usuario> obtenerListaUsuarios();
	
}
