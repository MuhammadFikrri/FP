package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
	
	Main game;
	
	public MouseInput(Main main) {
		game = main;
	}

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mousex = e.getX();
        int mousey = e.getY();

        //playButton
        if(mousex >= 250 && mousex <= 350){
            if(mousey >= 250 && mousey <= 300){
                Main.State = Main.STATE.GAME;
                game.play();
                game.getFrame().requestFocus();
            }
        }

        //quitButton
        if(mousex >= 250 && mousex <= 350){
            if(mousey >= 350 && mousey <= 400){
                System.exit(1);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
