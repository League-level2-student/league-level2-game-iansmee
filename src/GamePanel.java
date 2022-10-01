import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

	 
	 	public static final int MENU = 0;
	 	public static final int GAME = 1;
	 	public static final int END = 2;
	    public static int currentState = MENU;
	    
	    public static Random rng = new Random();
	    ObjectManager objectmanager = new ObjectManager();
	    
	   
	   Timer frameDraw;
	   Font titleFont = new Font("Arial", Font.PLAIN, 40);
	
	   
	   
		GamePanel(){
			frameDraw = new Timer(1000/60,this);
		    frameDraw.start();
	}
		void updateMenuState() {
	    	
	    }
	    void updateGameState() {
	    	objectmanager.update();
	    	
	    }
	    void updateEndState()  {
	    	
	    }
	    void drawMenuState(Graphics g) {
	    	g.setColor(Color.BLUE);
	    	g.fillRect(0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
	    	g.setFont(titleFont);
	    	g.setColor(Color.YELLOW);
	    	g.drawString("Press enter to begin", 50, 400);
	    	g.drawString("Press space to move", 50, 500);
	    }
	    void drawGameState(Graphics g) {
	    	g.setColor(Color.WHITE);
	    	g.fillRect(0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
	    	objectmanager.draw(g);
	    	
	    	
	    }
	    void drawEndState(Graphics g)  {
	    	g.setColor(Color.RED);
	    	g.fillRect(0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
	    	g.setFont(titleFont);
	    	g.setColor(Color.YELLOW);
	    	g.drawString("GAME OVER", 150,400 );
	    	g.drawString("Press enter to restart", 50, 500);
	    	g.drawString("Your score was " + Bird.score,75 ,600 );
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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		    	objectmanager.reset();
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		    
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		    
		    }
		repaint();
	}

}
