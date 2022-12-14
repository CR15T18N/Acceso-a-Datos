package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import pojo.Serie;
import util.DatabaseConnection;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie>{

	private static Connection connection;
	
	public SerieDao() {
		
	}
	
	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<Serie> series = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "select * from series";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				serie = new Serie(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null
				);
			series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return series;
	}

	@Override
	public Serie buscarPorId(int i) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		Serie serie = null;
		
		String query = "select * from series where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				serie = new Serie(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		return serie;
	}
	

	@Override
	public void insert(Serie serie) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query = "insert into series (titulo, edad, plataforma)"
				+ " values(?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
	}

	@Override
	public void modificar(Serie serie) {
		// TODO Auto-generated method stub
		int id = serie.getId();
		String titulo = serie.getTitulo();
		int edad = serie.getEdad();
		String plataforma = serie.getPlataforma();
		
		connection = openConnection();
		
		String query = "UPDATE series SET titulo = ?, edad = ?, plataforma = ? "
				+ "WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.setInt(2, edad);
			ps.setString(3, plataforma);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	public ArrayList<Temporada> obtenerTemporadas(Serie serie){
		ArrayList<Temporada> temporadas = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM temporadas WHERE serie_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Temporada temporada = new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo"),
						serie
					);
				temporadas.add(temporada);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return temporadas;
	}
	
	@Override
	public void borrar(Serie serie) {
		// TODO Auto-generated method stub
		
		int serie_id = serie.getId();
		
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.borrarPorSerie(serie_id);
		
		connection = openConnection();
		
		String query = "DELETE FROM series WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
}
