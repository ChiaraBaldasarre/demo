package com.modeladosoftware.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modeladosoftware.dao.UsuarioDao;
import com.modeladosoftware.entity.Usuario;

@RestController	// Ejecuta en 2° plano como CONTROLADOR
				// Los Arrays se muestran como Json

// El CONTROLADOR es el MOTOR de una aplicación Rest
// Administra Urls
// Controla accesos desde el Front al manejar datos provenientes de la DB

public class UsuarioController {
	
	// INYECCIÓN DE DEPENDENCIAS
	@Autowired		// Automáticamente se crea un objeto UsuarioDao sin necesidad de crear un " = new UsuarioDao (); "
	private UsuarioDao usuarioDao;


// ----------------------------------------------------------------------------------------------------- //
	// Mapeamos la ruta (URL)						//(http://localhost:8080/personas)
	@RequestMapping(value="mensaje")	
	public String mensaje() {
		return "Hola mundo";
	}
// ___________________________________________________________________________________ //
	
	@RequestMapping(value="personas")				//(http://localhost:8080/personas)
	public List<String> listarPersonas(){
		return List.of("Diego", "Juan", "Jose");
	}
	
// ------------------------------------------------------------------------------------------------------ //
// ___________________________________________________________________________________ //
	
	@RequestMapping(value="usuario")
	public Usuario listarUsuarios() {				//(http://localhost:8080/usuario)
		
		// Instanciamos
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Diego");
		usuario1.setApellido("Vargas");
		usuario1.setEmail("dvargasgodoy@gmail.com");
		usuario1.setTelefono("155619965");
		
		return usuario1;
	}
// ___________________________________________________________________________________ //
	
	// --- * --- SIN INYECCIÓN DE DEPENDENCIAS --- * --- //
	// Función @PathVariable
	// Harcodeamos el id
	// Buscamos usuarios por n° de id en la URL con las {llaves}
	// Hardcodear: incrustar datos
	
	@RequestMapping(value="usuario/{id}")				//(http://localhost:8080/usuario/6)
	public Usuario getUsuario(@PathVariable Long id) {
		
		// Instanciamos
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre("Diego");
		usuario.setApellido("Vargas");
		usuario.setEmail("dvargasgodoy@gmail.com");
		usuario.setTelefono("155619965");
		
		return usuario;	
	}
// ___________________________________________________________________________________ //	
	
	@RequestMapping(value="usuarios")				//(http://localhost:8080/usuarios)
	public List<Usuario> getUsuario() {
		
		// Creamos arreglo a mostrar
		List<Usuario> usuarios=new ArrayList<>();
		
		// Instanciamos
		Usuario usuario1 = new Usuario();
		usuario1.setId(1L);		// Colocamos L para indicar que es Long
		usuario1.setNombre("Diego");
		usuario1.setApellido("Vargas");
		usuario1.setEmail("dvargasgodoy@gmail.com");
		usuario1.setTelefono("155619965");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2L);		
		usuario2.setNombre("Jose");
		usuario2.setApellido("Puentes");
		usuario2.setEmail("joseey@gmail.com");
		usuario2.setTelefono("155655565");
		
		Usuario usuario3 = new Usuario();
		usuario3.setId(3L);		
		usuario3.setNombre("Fulano");
		usuario3.setApellido("Mengua");
		usuario3.setEmail("fulame2@gmail.com");
		usuario3.setTelefono("155747665");
		
		// Agregamos los objetos al arreglo
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		return usuarios;
	}
// ___________________________________________________________________________________ //
		
	@RequestMapping(value="api/usuarios")
	public List<Usuario> getUsuarios(){
			
			List<Usuario> listaUsuarios = usuarioDao.obtenerListaUsuarios();
			
			return listaUsuarios;
		}

	

}
