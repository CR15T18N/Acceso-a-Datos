package pojo;

import java.util.ArrayList;

public class Biblioteca {

	private int id;
	private String nombre;
	private int telefono;
	private ArrayList<Libro> libros;
	
	public Biblioteca(String nombre, int telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Biblioteca(int id, String nombre, int telefono, ArrayList<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.libros = libros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Biblioteca [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}