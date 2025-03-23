package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

// Component annotation creates an object of it to be injected
@Component
public class GameDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// @SuppressWarnings("deprecation") -> if using session.save(object)
	@Transactional
	public void addGame(Game game) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(game);
	}
	
	@Transactional
	public Game getGame(int gameId) {
		Session session = sessionFactory.getCurrentSession();
//		String query = "FROM Game WHERE id = " + Integer.toString(gameId);
//		List<Game> game = session.createQuery(query, Game.class).list();
		
		// Since we are using Spring ORM, we can use session.get to get required row in table instead of writing query manually.
		Game game = session.get(Game.class, gameId);
		return game;
	}
	
	// @Transactional: Takes care of creating and commiting a new transaction while communicating with DB
	@Transactional
	public List<Game> getGames(){
		Session session = sessionFactory.getCurrentSession(); 
		// When writing the query, we have to mention the Entity(class) Name, not the table name in SQL database 
		// The name of the SQL database is mentioned using @Table(name="table_name") with the Entity Class
		String query = "FROM Game";	
		// list() is used to convert result into a list.
		List<Game> games =  session.createQuery(query, Game.class).list();  
		return games; 
	}
	
}
