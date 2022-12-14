package pojo;

public class Libro {

	private int id;
	private String titulo;
	private String seccion;
	private Biblioteca biblioteca;
	
	public Libro(int id, String titulo, String seccion, Biblioteca biblioteca) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.seccion = seccion;
		this.biblioteca = biblioteca;
	}

	public Libro(String titulo, String seccion, Biblioteca biblioteca) {
		super();
		this.titulo = titulo;
		this.seccion = seccion;
		this.biblioteca = biblioteca;
	}
	
	public Libro(int id, String titulo, String seccion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.seccion = seccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", seccion=" + seccion + ", biblioteca=" + biblioteca.getNombre() + "]";
	}

	
}
