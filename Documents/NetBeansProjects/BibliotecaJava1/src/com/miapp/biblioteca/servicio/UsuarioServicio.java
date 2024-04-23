package com.miapp.biblioteca.servicio;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

public class UsuarioServicio {

	private ArrayList<Usuario> usuarios;
	
	public UsuarioServicio(ArrayList<Usuario>usuarios) {
		this.usuarios=usuarios;
	}
	
	public void AgregarUsuario(
			String nombre,
			 int id,
			 String contrasena,
			 ArrayList<Libro> librosPrestados
			) {
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre(nombre);
		nuevoUsuario.setId(id);
		nuevoUsuario.setContrasena(contrasena);
		nuevoUsuario.setLibrosPrestados(librosPrestados);
		usuarios.add(nuevoUsuario);
	}
	
	public ArrayList<Usuario> MostrarUsuarios() {
		return usuarios;
	}
	
	public void EditarUsuario(
			String nuevoNombre,
			int id
			) {
		for (Usuario usuario : usuarios) {
			if (usuario.getId().equals(id)) {
				usuario.setNombre(nuevoNombre);
			}
		}
	}
	
	public void EliminarUsuario(int id) {
		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {
				it.remove();
			}
		}
	}
	
	
	public Usuario buscquedaId(String id) {
		for (Usuario usuario : usuarios) {
			if (String.valueOf(usuario.getId()).equals(id)) {
				return usuario;
			}
		}
		return null;
	}
	
	public Usuario buscquedaNombre(String nombre) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre)) {
				return usuario;
			}
		}
		return null;
	}
	
	public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario){
		return usuario.getLibrosPrestados();
	}
	
}
//sadasdasd