import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	
	 	final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	
	    void updateMenuState() {
	    	
	    }
	    void updateGameState() {
	    	
	    }
	    void updateEndState()  {
	    	
	    }
	    void drawMenuState(Graphics g) {
	    	g.setColor(Color.BLUE);
	    	g.fillRect(0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
	    }
	    void drawGameState(Graphics g) {
	    	
	    }
	    void drawEndState(Graphics g)  {
	    	
	    }
	
	
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
