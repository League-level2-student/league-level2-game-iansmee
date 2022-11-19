import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class PowerUp extends GameObject {
	
public static BufferedImage image;
		public static boolean needImage = true;
		public static boolean gotImage = false;	
		
	int speed = 2;	
	PowerUp(int x, double y, int width, int height) {
		super(x, y, width, height);
	
		if (needImage) {
		    loadImage ("StarPowerUp.png");
		}
		
		
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, (int) y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, (int) y, width, height);
		}
	}
	public void update() {
		super.update();
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
