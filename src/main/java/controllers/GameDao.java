package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import models.Game;

// Component annotation makes spring create an object of it to be injected
@Component
public class GameDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addGame() {
		
	}
	
	@Transactional
	public List<Game> getGames(){
		Session session = sessionFactory.getCurrentSession();
		// list() is used to convert result into a list.
		List<Game> games = session.createQuery("from gamedb", Game.class).list();
		return games;
	}
	
}
