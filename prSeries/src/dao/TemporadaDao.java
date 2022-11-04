package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao implements InterfazDao<Temporada>{

	
	private static Connection connection;
	
	public TemporadaDao() {
		
	}
	
	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Temporada t) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query = "insert into temporadas (num_temporada, titulo,"
				+ " serie_id) values(?, ?, ?)";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, temporada.getNum_temporadas());
			ps.setString(2, temporada.getTitulo());
			ps.setInt(3, temporada.getSerie().getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	
	}

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub
		int id = temporada.getId();
		int num_temporada = getNum_temporadas();
		String titulo = temporada.getTitulo());
		
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

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub
		
	}
	
	private static Connection openConnection() {
		DatabaseConnection dbConnection=new DatabaseConnection();
		connection =dbConnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		
		try {
			connection.close();
			connection=null;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
