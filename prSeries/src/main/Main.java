package main;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				/*//Serie  serie = new Serie("Los Simpsons", 7, "Disney Plus");
				SerieDao serieDao = new SerieDao();
				//serieDao.insert(serie);
				//System.out.println(serieDao.buscarPorId(1));
				//Serie serie = serieDao.buscarPorId(1);
				//Temporada t1 = new Temporada(1, "Temporada 1", serie);
				//Temporada t2 = new Temporada(2, "Temporada 2", serie);
				
				//TemporadaDao temporadaDao = new TemporadaDao();
				//temporadaDao.insert(t1);
				//temporadaDao.insert(t2);
				
				//Serie s = new Serie("The Mandalorian", 13, "Disney Plus");
				//serieDao.insert(s);
				
				//Serie los_simpsons = serieDao.buscarPorId(1);
				//los_simpsons.setPlataforma("Netflix");
				//serieDao.modificar(los_simpsons);
				
				ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(los_simpsons);
				
				for (Temporada temporada : temporadas) {
					System.out.println(temporada);
				}
				
				ArrayList<Serie> series = serieDao.buscarTodos();
				
				for (Serie serie : series) {
					System.out.println(serie.getTitulo());
				}*/
		
				SerieDao serieDao = new SerieDao();
				TemporadaDao temporadaDao = new TemporadaDao();
				
				/*Serie s = serieDa.buscarPorId(2);
				Temporada t1 = new Temporada(1, "The Mandalorian Season 1", s);
				Temporada t2 = new Temporada(2, "The Mandalorian Season 2", s);
				Temporada t3 = new Temporada(3, "The Mandalorian Final Season", s);
				temporadaDao.insert(t1);
				temporadaDao.insert(t2);
				temporadaDao.insert(t3);*/
				
				//temporadaDao.borrarPorSerie(2);
				
				Serie s = serieDao.buscarPorId(1);
				serieDao.borrar(s);
	}

}
