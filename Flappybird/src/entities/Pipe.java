package entities;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class Pipe extends Entity{
	
	private Main game;
	private boolean isPassed = false;
	private boolean isMain;
	
	public Pipe(int y, int height, Main game, boolean isMain) {
		super(game);
		this.speedX = -3;
		this.x = 600;
		this.y = y;
		this.speedY = 0;
		this.width = 50;
		this.height = height;
		this.game = game;
		this.isMain = isMain;
		boundingBox.width = width;
		boundingBox.height = height;
	}

	@Override
	public void tick() {
		if(this.x + (int) (this.width / 2) <= game.getB().x + (int)(game.getB().width / 2) && !isPassed) {
			isPassed = true;
			if(isMain) {
				game.addScore();
			}
		}
		move();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)this.x, (int)this.y, this.width, this.height);
		g.setColor(Color.BLACK);
//		g.drawString((int)getBounds().x +" "+(int) getBounds().y +" "+ getBounds().width +" "+ getBounds().height, (int)x, (int) y);
//		g.setColor(Color.BLACK);
//		g.drawString(x +" " + y,  (int)x,(int) y);
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}

}
