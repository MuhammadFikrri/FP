package main;

import java.awt.*;

public class Menu {

    public Rectangle playButton = new Rectangle(250, 250, 100, 50);
    public Rectangle quitButton = new Rectangle(250, 350, 100, 50);

    public void render (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Font font0 = new Font("arial", Font.BOLD, 40);
        g.setFont(font0);
        g.setColor(Color.black);
        g.drawString("FLAPPY FLAPPY", 150,100 );

        Font font1 = new Font("arial", Font.BOLD, 30);
        g.setFont(font1);
        g.drawString("Play",playButton.x + 19, playButton.y + 30 );
        g2d.draw(playButton);
        g.drawString("Quit",quitButton.x + 19, quitButton.y + 30 );
        g2d.draw(quitButton);

        Font font2 = new Font("arial", Font.BOLD, 20);
        g.setFont(font2);
        g.drawString("press [SPACE] to jump", 200,200);
    }

}
