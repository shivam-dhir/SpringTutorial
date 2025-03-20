package models;

public class Game {
	
	private int id;
	private String name;
	private int metascore;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMetascore() {
		return metascore;
	}
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", metascore=" + metascore + "]";
	}
	
	
	
}
