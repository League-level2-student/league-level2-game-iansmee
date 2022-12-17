import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

	 
	 	public static final int MENU = 0;
	 	public static final int GAME = 1;
	 	public static final int END = 2;
	    public static int currentState = MENU;
	    public static BufferedImage image;
	    public static boolean needImage = true;
	    public static boolean gotImage = false;	
	    
	    public static Random rng = new Random();
	    ObjectManager objectmanager = new ObjectManager();
	    
	   
	   Timer frameDraw;
	   Font titleFont = new Font("Arial", Font.PLAIN, 40);
	
	   
	   
		GamePanel(){
			frameDraw = new Timer(1000/60,this);
		    frameDraw.start();
		    if (needImage) {
		        loadImage ("flappybirdbackground.png");
		    }
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
	    	g.drawString("Press space to jump", 50, 500);
	    	g.drawString("press i for instructions", 50, 600);
	    }
	    void drawGameState(Graphics g) {
	    	if (gotImage) {
	    		g.drawImage(image, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT, null);
	    	} else {
	    		g.setColor(Color.BLUE);
	    		g.fillRect(0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
	    	}
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
	    void loadImage(String imageFile) {
	        if (needImage) {
	            try {
	                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    	    gotImage = true;
	            } catch (Exception e) {
	                
	            }
	            needImage = false;
	        }
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
		if(e.getKeyCode()==KeyEvent.VK_I) {
			JOptionPane.showMessageDialog(null, "In this game you are a bird running from another bird. If that other bird catches up to you, you lose. Touching pillars will bring that bird closer to you.\n Every 10 levels, a star will appear that, when touched, will bring that bird back to its original location.\n Use the space bar to jump and avoid the pillars, and try to survive as long as possible. Good Luck!");
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
