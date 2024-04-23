package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	private int id;
	private String contrasena;
	private ArrayList<Libro> librosPrestados;
	
	
	public Usuario(String nombre, int id,String contrasena, ArrayList<Libro> librosPrestados) {
		this.nombre = nombre;
		this.id = id;
		this.contrasena = contrasena;
		this.librosPrestados = new ArrayList<>();
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public Usuario() {
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}


	public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", id=" + id + ", librosPrestados=" + librosPrestados + "]";
	}

	
	
	
	
}
