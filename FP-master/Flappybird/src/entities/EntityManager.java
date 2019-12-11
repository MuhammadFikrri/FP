package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.Main;

public class EntityManager {

	private Main game;
	private Bird b;
	private ArrayList<Entity> entities;
	
	public EntityManager(Main game, Bird b) {
		this.game = game;
		this.b = b;
		entities = new ArrayList<Entity>();
		entities.add(b);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if (e instanceof Pipe) {
				Pipe pipes = (Pipe) e;
				if(pipes.isPassed() && pipes.x + pipes.width < 0) {
					it.remove(); 
				}
			}
		}
//		for(Entity e : entities) {
//			e.tick();
//			if (e instanceof Pipe) {
//				Pipe pipes = (Pipe) e;
//				if(pipes.isPassed() && pipes.x + pipes.width < 0) {
//					entities.remove(pipes); 
//				}
//			}
//		}
		
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
