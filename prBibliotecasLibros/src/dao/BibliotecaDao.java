package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Biblioteca;
import pojo.Libro;
import util.DatabaseConnection;

public class BibliotecaDao extends ObjetoDao implements InterfazDao<Biblioteca> {

	private static Connection connection;
	
	public BibliotecaDao () {
		
	}

	
	@Override
	public ArrayList<Biblioteca> buscarTodos() {
		ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM bibliotecas";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList<Libro> libros = new ArrayList<Libro>();
				
				Biblioteca biblioteca = new Biblioteca(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getInt("telefono"),
							null
				);
				
				String query_libros = "select * from libros where bibliotecas_id = ?";
				PreparedStatement ps_libros = connection.prepareStatement(query_libros);
				ps_libros.setInt(1, rs.getInt("id")); 
				ResultSet rs_libros = ps_libros.executeQuery();
				
				while(rs_libros.next()) {
					Libro libro = new Libro(
							rs_libros.getInt("id"),
							rs_libros.getString("titulo"),
							rs_libros.getString("seccion")
					);
					libros.add(libro);
				}
				
				biblioteca.setLibros(libros); 
				
				bibliotecas.add(biblioteca);
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return bibliotecas;
	}

	@Override
	public Biblioteca buscarPorId(int id) {
		connection = openConnection();
		
		
		
		String query = "select * from bibliotecas where id = ?";
		Biblioteca biblioteca = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				biblioteca = new Biblioteca(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("telefono"),
						null
				);
				biblioteca.setLibros(obtenerLibros(biblioteca));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return biblioteca;
	}

	@Override
	public void insertar(Biblioteca biblioteca) {
		connection = openConnection();
		
		String query = "insert into bibliotecas (nombre, telefono)"
							+ " values (?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, biblioteca.getNombre());
			ps.setInt(2, biblioteca.getTelefono());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Biblioteca biblioteca) {
		int id = biblioteca.getId();
		String nombre = biblioteca.getNombre();
		int telefono = biblioteca.getTelefono();
		
		connection = openConnection();
		
		String query = "UPDATE bibliotecas SET nombre = ?, telefono = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setInt(2, telefono);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void borrar(Biblioteca biblioteca) {
		int bibliotecas_id = biblioteca.getId();
		
		LibroDao libroDao = new LibroDao();
		libroDao.borrarPorBiblioteca(bibliotecas_id); 
		
		connection = openConnection();
		
		String query = "DELETE FROM bibliotecas WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, bibliotecas_id); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public ArrayList<Libro> obtenerLibros(Biblioteca biblioteca) {
		ArrayList<Libro> libros = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM libros WHERE bibliotecas_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, biblioteca.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Libro libro = new Libro(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getString("seccion"),
						biblioteca
						);
				libros.add(libro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//closeConnection();
		
		return libros;
	}
	
}
