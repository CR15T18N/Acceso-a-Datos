package main;

import java.util.ArrayList;

import dao.BibliotecaDao;
import dao.LibroDao;
import pojo.Biblioteca;
import pojo.Libro;



public class Main {

	public static void main(String[] args) {
		//Serie serie = new Serie("Los Simpsons", 7, "Disney Plus");
		//Biblioteca biblioteca = new Biblioteca("Cervantes", 6525545);
		//BibliotecaDao bibliotecaDao = new BibliotecaDao();
		//bibliotecaDao.insertar(biblioteca);
		//SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		//System.out.println(serieDao.buscarPorId(1)); 
		//Serie serie = serieDao.buscarPorId(1);
		//System.out.println(serie); 
		//Temporada t1 = new Temporada(1, "Temporada 1", serie);
		//Temporada t2 = new Temporada(2, "Temporada 2", serie);
		
		//TemporadaDao temporadaDao = new TemporadaDao();
		//temporadaDao.insertar(t1);
		//temporadaDao.insertar(t2); 
		
		//Serie s = new Serie("The Mandalorian", 12, "Disney Plus");
		//serieDao.insertar(s); 
		
		//Serie los_simpsons = serieDao.buscarPorId(1);
		//los_simpsons.setPlataforma("Netflix"); 
		//serieDao.modificar(los_simpsons); 
		
		//ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(los_simpsons);
		
		/*ArrayList<Temporada> temporadas = los_simpsons.getTemporadas();
		
		for (Temporada temporada : temporadas) {
			System.out.println(temporada); 
		}*/
		
		/*ArrayList<Serie> series = serieDao.buscarTodos();
		
		for (Serie serie : series) {
			System.out.println("SERIE: " + serie.getTitulo()); 
			for (Temporada temporada : serie.getTemporadas()) {
				System.out.println("TEMPORADA: " + temporada.getTitulo()); 
			}
		}*/
		
		//	Insertar temporadas para The Mandalorian
		//SerieDao serieDao = new SerieDao();
		//TemporadaDao temporadaDao = new TemporadaDao();
		
		/*Serie s = serieDao.buscarPorId(2);
		Temporada t1 = new Temporada(1, "The Mandalorian Season 1", s);
		Temporada t2 = new Temporada(2, "The Mandalorian Season 2", s);
		Temporada t3 = new Temporada(3, "The Mandalorian Final Season", s);
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		temporadaDao.insertar(t3); */
		
		//temporadaDao.borrarPorSerie(2); 
		
		//Serie s = serieDao.buscarPorId(2);
		//serieDao.borrar(s); 
		
		BibliotecaDao bibliotecaDao = new BibliotecaDao();
		LibroDao libroDao = new LibroDao();
		
		//INSERCION
        System.out.println("\n\nINSERCION DE DATOS:");
		Biblioteca c = new Biblioteca("Cervantes", 951926104);
		bibliotecaDao.insertar(c);
		Biblioteca cc = bibliotecaDao.buscarPorId(2);
		Libro l1 = new Libro(1, "El apagaon", "FILOSOFIA", cc);
		Libro l2 = new Libro(2, "Tormenta de espadas", "NARRATIVA", cc);
		Libro l3 = new Libro(3, "La inercia del silencio", "POESIA", cc);
		libroDao.insertar(l1);
		libroDao.insertar(l2);
		libroDao.insertar(l3);
		/*Biblioteca p = new Biblioteca("Provincial", 951920530);
		bibliotecaDao.insertar(p);
		Libro b1 = new Libro(1, "Hamlet", "TEATRO", p);
		Libro b2 = new Libro(2, "Churchill: La biografia", "BIOGRAFIAS", p);
		Libro b3 = new Libro(3, "Prisioneros de la geografía", "GEOGRAFIA", p);
		libroDao.insertar(b1);
		libroDao.insertar(b2);
		libroDao.insertar(b3);*/
		
		//CONSULTA
        System.out.println("\n\nCONSULTA DE DATOS: ");
        System.out.println("Bibliotecas de la base de datos con sus libros correspondientes: ");
        ArrayList<Biblioteca> bibliotecas = bibliotecaDao.buscarTodos();
        for (Biblioteca biblioteca : bibliotecas) {
            System.out.println("Biblioteca: "+biblioteca.getNombre());
            for (Libro libro : biblioteca.getLibros()) {
                System.out.println("Libro: "+libro.getTitulo());
            }
        }
        
        /*
		//MODIFICACION
        System.out.println("\n\nMODIFICACIÓN DE DATOS:");
        razaGato.setNombre("Gato Azul ruso");
        razaDao.modificar(razaGato);
        Raza razaGatoModificada = razaDao.buscarPorId(razaGato.getId());
        System.out.println("Raza de gato modificada: " + razaGatoModificada);

		//ELIMINACION
        perro1.setRaza(razaPerro2);
        animalDao.modificar(perro1);
        Animal perroModificado = animalDao.buscarPorId(perro1.getId());
		int idAnimalParaBorrar = gato1.getId();
        animalDao.borrar(gato1);
        Animal animalBorrado = animalDao.buscarPorId(idAnimalParaBorrar);
        if (animalBorrado == null) {
            System.out.println("Animal con id " + idAnimalParaBorrar + " borrado con éxito.");
        } else {
            System.err.println("Animal con id " + idAnimalParaBorrar + " no borrado.");
        }
		 */
	}

}