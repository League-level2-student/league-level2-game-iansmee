import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Pillar extends GameObject {

	Pillar top;
	public static int speed = 2;
	
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;	

	Pillar(double y, int height, Pillar top) {
		super(FlappyBird.WIDTH, y, 100, height);
		this.top = top;
		
		
		if (needImage) {
		    
		    if(top == null) {
		    	loadImage ("pipe.png");
		    }
		    else {
		    	loadImage("pipe copy.png");
		    }
		}

	}


	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, (int) y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, (int)y, width, height);
		}
		
	}

	public void update() {
		super.update();
	
		
		
		
	
		x -= speed;
		if (x <= -100) {
			speed +=1;
			
			x = FlappyBird.WIDTH;
			if (top == null) {
				Bird.score += 1;
				height = GamePanel.rng.nextInt(200) + 200;
				if(ObjectManager.bird.score >= 1) {
					if(ObjectManager.bird.score % 10 == 0) {
				ObjectManager.powerup.x = ObjectManager.pillar.x + 20;
				ObjectManager.powerup.y = height + 75;
					}
				}
				
			} else {
				y = top.height + 200;
			}
		}
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

}
