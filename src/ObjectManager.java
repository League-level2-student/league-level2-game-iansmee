import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class ObjectManager implements KeyListener {

	public static Random rng = new Random();
	public static Enemy enemy = new Enemy(0,400,50,50);
	public static Bird bird = new Bird(200,400,50,50);
	public static Pillar pillar = new Pillar(0, 200 + rng.nextInt(200),null);
	public static Pillar pillar2 = new Pillar(pillar.height + 200, 400,pillar);
    public static PowerUp powerup = new PowerUp(0,0,50,50);
    long lastOccurred = 0;
    
    
    
    
	void checkCollisions(){
		if(bird.CollisionBox.intersects(pillar.CollisionBox )&& lastOccurred + 1000 < System.currentTimeMillis()) {
			pillar.speed = pillar.speed/2;
			pillar2.speed = pillar2.speed/2;
			if(pillar.speed <= 1) {
				pillar.speed = 1;
			}
			if(pillar2.speed <= 1) {
				pillar2.speed = 1;
			}
			enemy.x +=25;
			lastOccurred = System.currentTimeMillis();
		}
		if(bird.CollisionBox.intersects(pillar2.CollisionBox)&& lastOccurred + 1000 < System.currentTimeMillis()) {
			pillar.speed = pillar.speed/2;
			pillar2.speed = pillar2.speed/2;
			if(pillar.speed <= 1) {
				pillar.speed = 1;
			}
			if(pillar2.speed <= 1) {
				pillar2.speed = 1;
			}
			enemy.x +=25;
			lastOccurred = System.currentTimeMillis();
		}
		if(bird.CollisionBox.intersects(enemy.CollisionBox)) {
			bird.isActive = false;
		}
		if(bird.CollisionBox.intersects(powerup.CollisionBox)) {
			enemy.x=0;
			powerup.y -= 800;
		}
	}
	

	
	
		public void reset() {
			bird = new Bird(200,400,50,50);
			Bird.score = 0;
	    	pillar = new Pillar(0, 200 + rng.nextInt(200),null);
	    	pillar2 = new Pillar(pillar.height + 200, 400,pillar);
	    	enemy = new Enemy(0,400,50,50);
	    	powerup = new PowerUp(0,0,50,50);
	    	
		}

	void draw(Graphics g) {
		pillar.draw(g);
    	pillar2.draw(g);
    	bird.draw(g);
    	enemy.draw(g);
    	powerup.draw(g);
	}
	void update() {
		powerup.update();
		pillar.update();
		pillar2.update();
		bird.update();
		enemy.update();
		
		if(enemy.x <= 0) {
			enemy.x +=2;
		}
		
		enemy.y = bird.y;
		
		
		if(bird.y >= 800) {
			bird.isActive = false;
		}
		if(bird.y <= 0) {
			bird.isActive = false;
		}
		
		
		
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
