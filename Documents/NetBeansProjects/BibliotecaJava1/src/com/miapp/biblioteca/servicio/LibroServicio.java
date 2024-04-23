package com.miapp.biblioteca.servicio;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

public class LibroServicio {

	private ArrayList<Libro> biblioteca;
	
	public LibroServicio(ArrayList<Libro>biblioteca) {
		this.biblioteca= biblioteca;
	}

	public void AgregarLibro(
			String titulo,
			String autor,
			String ISBN,
			String genero,
			Boolean Disponible) 
	{
		Libro libroAgregado = new Libro();
		libroAgregado.setTitulo(titulo);
		libroAgregado.setAutor(autor);
		libroAgregado.setISBN(ISBN);
		libroAgregado.setGenero(genero);
		libroAgregado.setDisponible(true);
		biblioteca.add(libroAgregado);
		
	}
	
	public ArrayList<Libro> MostrarLibros() {
		return biblioteca;
	}
	
	
	
	public void  MostrarGenero( String genero){
		
		for (Libro libro : biblioteca) {
			if(libro.getGenero().equals(genero)) {
				System.out.println(libro);
			}
		}
	}
	
	
	public void EditarLibro(
			String nuevoTitulo,
			String nuevoAutor,
			String ISBN,
			String nuevoGenero
			) {
		for (Libro libro : biblioteca) {
			if (libro.getISBN().equals(ISBN)) {
				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setGenero(nuevoGenero);
				
			}
		}
	}
	
	public void eliminarLibro(String ISBN) {
		Iterator<Libro> it=  biblioteca.iterator();
		
		while(it.hasNext()) {
			if (it.next().getISBN().equals(ISBN)) {
				it.remove();
			}
		}	
	}
	
	
	public Libro buscarLibroISBN(String ISBN) {
		for (Libro libro : biblioteca) {
			if (libro.getISBN().equals(ISBN)) {
				return libro;
			}
		}
		return null;
	}
		
	
	
	public Libro buscarLibroGenero(String genero) {
		for (Libro libro : biblioteca) {
			if (libro.getGenero().equals(genero)) {
				return libro;
			}
		}	
		return null;
	}
	
	public ArrayList<Libro> BuscarLibroTitulo(String titulo){
		ArrayList<Libro>encontrados = new ArrayList();
		for (Libro libro : biblioteca) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				encontrados.add(libro);
			}
		}
		return encontrados;
	}
	
	public ArrayList<Libro> BuscarLibroAutor(String autor){
		ArrayList<Libro>encontrados = new ArrayList();
		for (Libro libro : biblioteca) {
			if (libro.getAutor().equalsIgnoreCase(autor)) {
				encontrados.add(libro);
			}
		}
		return encontrados;
	}
	
	public boolean verificarDisponibilidad(Libro libro){
		return libro.getDisponible();
	}

	public void prestarLibro(Usuario usuario, Libro libro) {
	
		if (libro.getDisponible()) {
			usuario.getLibrosPrestados().add(libro);
			libro.setDisponible(false);
		}else {
			System.out.println("El libro no esta disponible para el prestamo");
		}
		
	}
	
public void devolverLibro(Usuario usuario,Libro libro) {
	if (usuario.getLibrosPrestados().contains(libro)) {
		usuario.getLibrosPrestados().remove(libro);
		libro.setDisponible(true);
	}
	 else{
		System.out.println("El libro no se encuentra en el inventario del alumno");
		 }	
	}
	
}
