import java.awt.Color;
import java.awt.Graphics;

public class Bird extends GameObject {
	
	
	double speed = 10;
	double velocity;
	double acceleration = 0.5;
	
	
	
	
	
	
Bird(int x, double y, int width, int height) {
super(x, y, width, height);
}


public void up() {
velocity=-10;
}
public void draw(Graphics g){
	g.setColor(Color.YELLOW);
    g.fillRect(x, (int)y, width, height);
}
public void update() {
	velocity+=acceleration;
	y+=velocity;
	
	
}









}
