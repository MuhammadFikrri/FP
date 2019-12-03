package entities;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class Bird extends Entity{
	
	private double gravity = (double) 0.3;
	
	public Bird(int x, int y, Main game) {
		super(game);
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 10;
		this.speedX = 0;
		this.speedY = 0;
		this.boundingBox.width = width;
		this.boundingBox.height = height;
	}

	@Override
	public void tick() {
		if(checkEntityCollisions()) {
			game.gameOver();
		}
		this.speedY += gravity;
		if(this.y >= 500 - this.height) {
			y = 500 - this.height;
			speedY = 0;
			game.gameOver();
		}
		if(this.y <= 30) {
			y = 30;
		}
		if(game.km.jump) {
			speedY = -7;
		}
		
		move();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)this.x, (int)this.y, this.width, this.height);
	}

}
