package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.*;
import com.miapp.biblioteca.servicio.LibroServicio;
import com.miapp.biblioteca.servicio.UsuarioServicio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		
		ArrayList<Libro> biblioteca = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
		
        LibroServicio libroServicio = new LibroServicio(biblioteca);
        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarios);
        
        usuarios.add(new Usuario("San Martín", 1, "contraseña1", new ArrayList<>()));
        usuarios.add(new Usuario("Belgrano", 2, "contraseña2", new ArrayList<>()));
        usuarios.add(new Usuario("Moreno", 3, "contraseña3", new ArrayList<>()));
        usuarios.add(new Usuario("Sarmiento", 4, "contraseña4", new ArrayList<>()));
        usuarios.add(new Usuario("Pueyrredón", 5, "contraseña5", new ArrayList<>()));
        
        biblioteca.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "9788424920763", "Novela", true));
        biblioteca.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "9788437604947", "Realismo mágico", true));
        biblioteca.add(new Libro("El principito", "Antoine de Saint-Exupéry", "9788424919491", "Fábula", true));
        biblioteca.add(new Libro("1984", "George Orwell", "9780451524935", "Distopía", true));
        biblioteca.add(new Libro("Moby Dick", "Herman Melville", "9789871165178", "Novela", true));
        biblioteca.add(new Libro("El ingenioso hidalgo Don Quijote de la Mancha", "Miguel de Cervantes", "9788420687016", "Novela", true));
        biblioteca.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "9788478884452", "Fantasía", true));
        biblioteca.add(new Libro("Orgullo y prejuicio", "Jane Austen", "9788497940867", "Novela romántica", true));
        biblioteca.add(new Libro("Crimen y castigo", "Fyodor Dostoyevsky", "9780143058143", "Novela", true));
        biblioteca.add(new Libro("La metamorfosis", "Franz Kafka", "9789877415043", "Ficción", true));

        
        int id = 5;
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenidos a bibliotela los libros");
		System.out.println("Inicio de sesion");
		boolean ingreso= true;
		do {
			System.out.println("elija la opcion");
			System.out.println("Registrarse (1)");
			System.out.println("Ingresar (2)");
		int opcion=0;
		opcion=scan.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Ingrese los datos solicitados para registrarse");
				System.out.println("Nombre");
				scan.nextLine();
				String nombreRegistro=scan.nextLine();
				System.out.println("Contrseña");
				String contrasenaRegistro=scan.nextLine();
				boolean nombreExistente = false;
				for (Usuario usuario : usuarios) {
					if (usuario.getNombre().equals(nombreRegistro)) {
						nombreExistente = true;
			            break;
					}
				}
				
				if (nombreExistente) {
					System.out.println("Este Nombre de usuario ya existe");
					System.out.println("Intenta con otro");
				}else {
				ArrayList<Libro> librosPrestados = new ArrayList<>();
				id ++;
				usuarioServicio.AgregarUsuario(nombreRegistro,id,contrasenaRegistro,librosPrestados);
				System.out.println("Usuario creado con éxito");
				}
				break;
			case 2:
				System.out.println("Ingrese los datos solicitados para ingresar");
				System.out.println("Nombre");
				scan.nextLine();
				String nombreIngreso=scan.nextLine();
				System.out.println("Contrseña");
				String contrasenaIngreso=scan.nextLine();
				boolean usuarioValido = false;
				for (Usuario usuario : usuarios) {
					if (usuario.getNombre().equals(nombreIngreso) && usuario.getContrasena().equals(contrasenaIngreso)) {
						usuarioValido = true;
				        break;	
					}	
				}
				if (usuarioValido) {
				    System.out.println("¡Inicio de sesión exitoso!");
				    ingreso = false;
				} else {
				    System.out.println("Nombre de usuario o contraseña incorrectos.");
				}
				break;
			}	
		} while (ingreso);
		
		
		boolean salir= true;
		while (salir) {
			System.out.println("¿Que desea realizar?");
			System.out.println("Ver libros (1)");
			System.out.println("Agregar libro (2)");
			System.out.println("Editar libro (3)");
			System.out.println("Llevar libro (4)");
			System.out.println("Devolver libro (5)");
			System.out.println("Eliminar libro (6)");
			System.out.println("Ver usuarios (7)");
			System.out.println("Buscar (8)");
			System.out.println("Editar Usuario (9)");
			System.out.println("Eliminar usuario(10)");
			System.out.println("Salir(11)");
			int accion = 0;
			System.out.println("Ingrese la aaccion a realizar con el numero");
			accion = scan.nextInt();
			
			switch(accion) {
			case 1:
				System.out.println("Estos son todos los libros de nuestra biblioteca");
				System.out.println(libroServicio.MostrarLibros());
                  break;
			case 2:
				System.out.println("AGREGAR LIBRO");
				System.out.println("Ingrese los datos a medida que se van solicitando");
				System.out.println("Titulo de la obra");
				scan.nextLine();
				String titulo = scan.nextLine();
				System.out.println("Autor de la obra");
				String autor = scan.nextLine();
				System.out.println("Codigo ISBN");
				String ISBN = scan.nextLine();
				System.out.println("Genero de la obra");
				String genero = scan.nextLine();
				
				libroServicio.AgregarLibro(titulo,autor,ISBN,genero,true);
				break;
				
			case 3:
				System.out.println("Ingrese los datos solicitados para editar un libro");
			    System.out.print("ISBN del libro a editar: ");
			    scan.nextLine();
			    String isbnEditar = scan.nextLine();
			    System.out.print("Nuevo título: ");
			    String nuevoTitulo = scan.nextLine();
			    System.out.print("Nuevo autor: ");
			    String nuevoAutor = scan.nextLine();
			    System.out.print("Nuevo género: ");
			    String nuevoGenero = scan.nextLine();

			    boolean libroEncontrado = false;
			    for (Libro libro : biblioteca) {
			        if (libro.getISBN().equals(isbnEditar)) {
			            libroEncontrado = true;
			            libroServicio.EditarLibro(nuevoTitulo, nuevoAutor, isbnEditar, nuevoGenero);
			            System.out.println("Libro editado exitosamente.");
			            break; 
			        }
			    }

			    if (!libroEncontrado) {
			        System.out.println("El libro con ISBN " + isbnEditar + " no se encontró en la biblioteca.");
			    }
			    break;
			case 4:
				System.out.print("Ingrese el número de ID del usuario: ");
				scan.nextLine();
				String idUsuario = scan.nextLine();
				Usuario usuarioPrestamo = usuarioServicio.buscquedaId(idUsuario);
				if (usuarioPrestamo != null) {
				System.out.print("Ingrese el ISBN del libro a prestar: ");
				String isbnPrestamo = scan.nextLine();
				Libro libroPrestamo = libroServicio.buscarLibroISBN(isbnPrestamo);
				if (libroPrestamo != null) {
				if (libroServicio.verificarDisponibilidad (libroPrestamo)) { libroServicio.prestarLibro (usuarioPrestamo, libroPrestamo);
				System.out.println("Préstamo exitoso. Libro prestado a "+ usuarioPrestamo.getNombre());
				} else {
				System.out.println("El libro no está disponible para préstamo.");
				}
				} else {
				System.out.println("Libro no encontrado.");
				}
				} else {
				System.out.println("Usuario no encontrado.");
				}
				break;
			case 5:	
				System.out.print("Ingrese el número de identificación del usuario: ");
				scan.nextLine();
				String idUsuariol = scan.nextLine();
				Usuario usuarioDevolucion = usuarioServicio.buscquedaId(idUsuariol);
				if (usuarioDevolucion != null) {
				System.out.print("Ingrese el ISBN del libro a devolver: ");
				String isbnDevolucion = scan.nextLine();
				Libro libroDevolucion = libroServicio.buscarLibroISBN(isbnDevolucion);
				if (libroDevolucion != null) {
				libroServicio.devolverLibro (usuarioDevolucion, libroDevolucion);
				System.out.println("Devolución exitosa. Libro devuelto por " + usuarioDevolucion.getNombre());
				} else {
				System.out.println("Libro no encontrado.");
				}
				} else {
				System.out.println("Usuario no encontrado.");
				}
				break;
			case 6: 
				System.out.println("Ingrese el ISBN del libro a eliminar:");
				scan.nextLine();
			    String ISBNAEliminar = scan.nextLine();
			    Iterator<Libro> it = biblioteca.iterator();
			    boolean libroEliminado = false;
			    while (it.hasNext()) {
			        Libro libro = it.next();
			        if (libro.getISBN().equals(ISBNAEliminar)) {
			            it.remove();
			            System.out.println("Libro eliminado con éxito.");
			            libroEliminado = true;
			            break;
			        }
			    }
			    if (!libroEliminado) {
			        System.out.println("No se encontró ningún libro con ese ISBN.");
			    }
				break;
			case 7: 
				System.out.println("Estos son todos los libros de nuestra biblioteca");
				System.out.println(usuarioServicio.MostrarUsuarios());
				break;
			case 8: System.out.println("¿Qué desea buscar?");
            System.out.println("Buscar libro por autor (1)");
            System.out.println("Buscar libro por titulo(2)");
            System.out.println("Buscar libro por genero (3)");
            System.out.println("Buscar libro por ISBN (4)");
            System.out.println("Buscar usuario por nombre(5)");
            System.out.println("Buscar usuario por ID(6)");
            int accionBusqueda = 0;
            System.out.println("Ingrese la acción a realizar con el número");
            accionBusqueda = scan.nextInt();
            switch (accionBusqueda) {
                case 1:
                	System.out.println("Ingrese el autor a buscar:");
                	scan.nextLine();
                	String autorBuscar = scan.nextLine();
                	System.out.println();
                	System.out.println(libroServicio.BuscarLibroAutor(autorBuscar));        
                    break;
                case 2:
                	System.out.println("Ingrese el título a buscar:");
                	scan.nextLine();
                	String tituloBuscar = scan.nextLine();
                	System.out.println(libroServicio.BuscarLibroTitulo(tituloBuscar));
                    break;
                case 3:
                	System.out.println("Ingrese el género a buscar:");
                	scan.nextLine();
                	String generoBuscar = scan.nextLine();
                	System.out.println(libroServicio.buscarLibroGenero(generoBuscar));
                    break;
                case 4:
                	System.out.println("Ingrese el ISBN a buscar:");
                	scan.nextLine();
                	String ISBNBuscar = scan.nextLine();
                	System.out.println(libroServicio.buscarLibroISBN(ISBNBuscar));
                    break;
                case 5:
                	System.out.println("Ingrese el nombre a buscar:");
                	scan.nextLine();
                	String nombreABuscar = scan.nextLine();
                    Usuario usuarioEncontradoPorNombre = usuarioServicio.buscquedaNombre(nombreABuscar);
                    if (usuarioEncontradoPorNombre != null) {
                        System.out.println("Usuario encontrado: " + usuarioEncontradoPorNombre);
                    } else {
                        System.out.println("No se encontró ningún usuario con ese nombre.");
                    }
                    break;
                case 6:
                	System.out.println("Ingrese el ID a buscar:");
                	scan.nextLine();
                    String idABuscar = scan.nextLine();
                    Usuario usuarioEncontradoPorId = usuarioServicio.buscquedaId(idABuscar);
                    if (usuarioEncontradoPorId != null) {
                        System.out.println("Usuario encontrado: " + usuarioEncontradoPorId);
                    } else {
                        System.out.println("No se encontró ningún usuario con ese ID.");
                    }
                    break;
                default:
                    System.out.println("Opción de búsqueda no válida.");
            }
            break;
			case 9: 
				System.out.println("Ingrese el ID del usuario que desea editar:");
			    int idUsuarioEditar = scan.nextInt();
			    scan.nextLine(); 
			    System.out.println("Ingrese el nuevo nombre del usuario:");
			    String nuevoNombreUsuario = scan.nextLine();
			    usuarioServicio.EditarUsuario(nuevoNombreUsuario, idUsuarioEditar);
			    System.out.println("Usuario editado con éxito.");
			    break;
			case 10: 
				System.out.println("Ingrese el ID del usuario que desea eliminar:");
			    int idUsuarioEliminar = scan.nextInt();
			    scan.nextLine();
			    usuarioServicio.EliminarUsuario(idUsuarioEliminar);
			    System.out.println("Usuario eliminado con éxito.");
			    break;
			case 11: 
				salir=!true;
			default:
                System.out.println("ingrese una accion valida");
			}	
		}
		
		System.out.println("Gracias vuelva prontos");
		
	}

	
	
	
}
