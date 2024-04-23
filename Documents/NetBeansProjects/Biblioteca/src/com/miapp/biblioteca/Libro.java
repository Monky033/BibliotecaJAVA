package com.miapp.biblioteca;

public class Libro {
	
	private String titulo;
	private String autor;
	private String ISBN;
	private String genero;
	private Boolean Disponible;
	
	
	public Libro(String titulo, String autor, String iSBN, String genero, Boolean disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = iSBN;
		this.genero = genero;
		this.Disponible = true;
	}


	public Libro() {
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Boolean getDisponible() {
		return Disponible;
	}


	public void setDisponible(Boolean disponible) {
		Disponible = disponible;
	}
	
	public void buscarLibro() {}


	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", genero=" + genero
				+ ", Disponible=" + Disponible + "]";
	}
	

	
	
	
	
	
	
	
}
