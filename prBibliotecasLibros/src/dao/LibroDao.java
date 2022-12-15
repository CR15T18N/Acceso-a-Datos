package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Biblioteca;
import pojo.Libro;

public class LibroDao extends ObjetoDao implements InterfazDao<Libro> {
	
	private static Connection connection;
	
	public LibroDao () {
		
	}


	@Override
	public ArrayList<Libro> buscarTodos() {
		ArrayList<Libro> libros = new ArrayList<>();

        connection = openConnection();

        String query = "select * from libros";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Libro libro = new Libro(
                		rs.getInt("id"), 
                		rs.getString("titulo"), 
                		rs.getString("seccion"), 
                		null
                );

                String query_biblioteca = "select * from bibliotecas where id = ?";
                PreparedStatement ps_biblioteca = connection.prepareStatement(query_biblioteca);
                ps_biblioteca.setInt(1, rs.getInt("id")); 
                ResultSet rs_biblioteca = ps_biblioteca.executeQuery();

                 while(rs_biblioteca.next()) {

                    Biblioteca biblioteca = new Biblioteca(
                    		rs_biblioteca.getInt("id"), 
                    		rs_biblioteca.getString("nombre"), 
                    		rs_biblioteca.getInt("telefono"), 
                    		libros
                    );

                     if(rs_biblioteca.getInt("id") == rs.getInt("id")) {
                         libro.setBiblioteca(biblioteca); 
                     }
                 }

                 libros.add(libro);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return libros;
	}

	@Override
	public Libro buscarPorId(int id) {
		connection = openConnection();

        String query = "select * from libros where id = ?";
        Libro libro = null;

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int bibliotecas_id = rs.getInt("bibliotecas_id");
                Biblioteca biblioteca = null;

                String query_biblioteca = "select * from bibliotecas where id = ?";
                PreparedStatement ps_biblioteca = connection.prepareStatement(query_biblioteca);
                ps_biblioteca.setInt(1, bibliotecas_id); 
                ResultSet rs_biblioteca = ps_biblioteca.executeQuery();

                while(rs_biblioteca.next()) {
                	biblioteca = new Biblioteca(
                			rs_biblioteca.getInt("id"), 
                			rs_biblioteca.getString("nombre"), 
                			rs_biblioteca.getInt("telefono"), 
                			null
                	);
                }

                libro = new Libro(
                		rs.getInt("id"), 
                		rs.getString("titulo"), 
                		rs.getString("seccion"), 
                		biblioteca
                );
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        closeConnection();

        return libro;
	}

	@Override
	public void insertar(Libro libro) {
		connection = openConnection();
		
		String query = "insert into libros (titulo, seccion, bibliotecas_id) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getSeccion());
			ps.setInt(3, libro.getBiblioteca().getId()); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Libro libro) {
		connection = openConnection();

        int id = libro.getId();
        String nuevoTitulo = libro.getTitulo();
        String nuevaSeccion = libro.getSeccion();
        Biblioteca biblioteca = libro.getBiblioteca();

        String query = "update libros set titulo = ?, seccion = ?, bibliotecas_id = ? where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nuevoTitulo);
            ps.setString(2, nuevaSeccion);
            ps.setInt(3, biblioteca.getId());
            ps.setInt(4, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();
	}

	@Override
	public void borrar(Libro libros) {
		connection = openConnection();
		
		int id = libros.getId();
		
		String query = "DELETE FROM libros WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	public void borrarPorBiblioteca (int bibliotecas_id) {
		connection = openConnection();
		
		String query = "DELETE FROM libros WHERE bibliotecas_id = ?";
		
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

}
