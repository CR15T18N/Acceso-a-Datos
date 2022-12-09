package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import pojo.Animal;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		/*Animal a1 = new Animal("Kuokka", "Jungla", new BigDecimal(2));
		session.save(a1);
		
		int id = 1;
		Animal a = (Animal) session.get(Animal.class, id);
		System.out.println(a.getNombre());*/	
		
		//List animales = session.createQuery("FROM Animal").getResultList();
		/*String hql = "FROM Animal WHERE habitat = :habitat";
		Query query = session.createQuery(hql);
		query.setParameter("habitat" , "Casa");
		List animales = query.getResultList();
		
		for(Iterator i = animales.iterator(); i.hasNext();) {
			Animal a = (Animal) i.next();
			System.out.println(a.getNombre());
		}*/
		
		session.getTransaction().commit();
		session.close();
	}

}
