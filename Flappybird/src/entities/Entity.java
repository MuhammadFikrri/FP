package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Main;

public abstract class Entity {

	protected double x, y;
	protected Rectangle boundingBox;
	protected int width, height;
	protected double speedX, speedY;
	protected Main game;
	
	public Entity(Main game) {
		boundingBox = new Rectangle(0, 0, width, height);
		this.game = game;
	}
	
	protected void move() {
		x += (int) speedX;
		y += (int) speedY;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, boundingBox.width, boundingBox.height);
	}
	
	public boolean checkEntityCollisions() {
		for(Entity e : game.getManager().getEntities()) {
			if(e.equals(this)) {
				continue;
				}
			if(e.getBounds().intersects(getBounds())) {
				return true;
			}
		}
		return false;
	}
}
