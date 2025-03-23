package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

// Component annotation makes spring create an object of it to be injected
@Component
public class GameDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addGame(Game game) {
		Session session = sessionFactory.getCurrentSession();
		session.save(game);
	}
	
	// @Transactional: Takes care of creating and commiting a new transaction while communicating with DB
	@Transactional
	public List<Game> getGames(){
		Session session = sessionFactory.getCurrentSession();
		// list() is used to convert result into a list.
		List<Game> games = session.createQuery("FROM Game", Game.class).list();  
		return games; 
	}
	
}
