import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bird extends GameObject {
	
	
	double speed = 10;
	double velocity;
	double acceleration = 0.5;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public static int score = 0;
	
	
	
Bird(int x, double y, int width, int height) {
super(x, y, width, height);

if (needImage) {
    loadImage ("flappybird.png");
}

}


public void up() {
velocity=-10;
}
public void draw(Graphics g){
	g.setColor(Color.YELLOW);
    g.fillRect(x, (int)y, width, height);
    if (gotImage) {
    	g.drawImage(image, x, (int)y, width, height, null);
    } else {
    	g.setColor(Color.BLUE);
    	g.fillRect(x, (int)y, width, height);
    }
}
public void update() {
	velocity+=acceleration;
	y+=velocity;
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
