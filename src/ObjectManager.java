import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class ObjectManager implements KeyListener {

	public static Random rng = new Random();
	Bird bird = new Bird(200,400,50,50);
	Pillar pillar = new Pillar(0, 200 + rng.nextInt(200),null);
    Pillar pillar2 = new Pillar(pillar.height + 200, 400,pillar);
	
	void checkCollisions(){
		if(bird.CollisionBox.intersects(pillar.CollisionBox)) {
			bird.isActive = false;
		}
		if(bird.CollisionBox.intersects(pillar2.CollisionBox)) {
			bird.isActive = false;
	}
		}
		public void reset() {
			bird = new Bird(200,400,50,50);
			Bird.score = 0;
	    	pillar = new Pillar(0, 200 + rng.nextInt(200),null);
	    	pillar2 = new Pillar(pillar.height + 200, 400,pillar);
	    	
		}

	void draw(Graphics g) {
		pillar.draw(g);
    	pillar2.draw(g);
    	bird.draw(g);
	}
	void update() {
		pillar.update();
		pillar2.update();
		bird.update();
    	if(bird.isActive == false) {
    		GamePanel.currentState = GamePanel.END;
    		
    	}
    	checkCollisions();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		    System.out.println("Space");
		    bird.up();
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
