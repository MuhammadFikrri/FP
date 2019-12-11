package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import entities.Bird;
import entities.EntityManager;
import entities.Pipe;

public class Main{
	
	private JFrame frame;
	public int width = 600;
	public int height = 500;
	private boolean running = false;
	private Graphics g;
	private Bird b;
	public KeyManager km;
	private int counter, fps;
	private EntityManager manager;
	private int score;
	private Menu menu;
	
	private Timer t;

	public static enum STATE{
		MENU, GAME
	};

	public static STATE State;

	public Main() {
		fps = 30;
		createFrame();
		State = STATE.MENU;
		g = frame.getGraphics();
		menu = new Menu();
		counter = 0;
		running = true;
		b = new Bird(50, height/2, this);
		score = 0;
		manager = new EntityManager(this, b);
		km = new KeyManager(this);
		frame.addKeyListener(km);
		frame.addMouseListener(new MouseInput(this));
		
		t=new Timer(1000/30, new ActionListener() {

			    @Override
			    public void actionPerformed(ActionEvent e) {
			      tick();
			      render(g);
			    }
		});
	}

	private void createFrame() {
		frame = new JFrame("Flappy Bird");
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.requestFocus();
	}
	
	public void play() {
		if(State == STATE.GAME) {
		t.start();
		}else if(State == STATE.MENU){
			menu.render(g);
		}
		
		/*
		int fps = this.fps;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		if(State == STATE.GAME) {
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
				if (delta >= 1) {
					tick();
					render(g);
					delta--;
					ticks++;
				}
				if (timer >= 1000000000) {
					System.out.println("Ticks and Frames : " + ticks);
					ticks = 0;
					timer = 0;
				}
			}drawEndGame(g);

			}else if (State == STATE.MENU){

			menu.render(g);
			//
		}*/

	}

	private void tick() {
		counter++;
			if (counter >= fps * 2) {
				counter = 0;
				int randomHole = (int) (Math.random() * 300 + 100);

				manager.addEntity(new Pipe(0, randomHole, this, true));
				manager.addEntity(new Pipe(randomHole + 150, 500 - randomHole - 150, this, false));
			}
		km.tick();
		manager.tick();
	}

	private void render(Graphics g) {
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, width, height);
		g.clearRect(0, 0, width, width);
		manager.render(g);
		g.setColor(Color.BLACK);
		g.drawString("Score : " + score, 20, 50);
		if(!running) {
			drawEndGame(g);
		}
	}
	
	private void drawEndGame(Graphics g) {
		g.clearRect(0, 0, width, height);
		g.drawString("Game Over", width/2 - 30, height/2);
		g.drawString("Score : " + score, width/2 -25, height/2 + 20); 
	}
	
	public void addScore() {
		score++;
	}
	
	public void gameOver() {
		running = false;
		
		t.stop();
		drawEndGame(g);
		
	}
	
	public void restart() {
		play();
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Bird getB() {
		return b;
	}

	public void setB(Bird b) {
		this.b = b;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Timer getT() {
		return t;
	}

	public void setT(Timer t) {
		this.t = t;
	}




	
	
}
