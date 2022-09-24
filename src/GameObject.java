import java.awt.Rectangle;

public class GameObject {
	
	
	
	
	int x;
	double y;
	int width;
	int height;
	int speed;
	Rectangle CollisionBox;
	
	
	
GameObject(int x, double y, int width, int height) {
	CollisionBox = new Rectangle(x, (int)y, width, height);
	
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	
}
void update() {
	CollisionBox.setBounds(x, (int)y, width, height);
}




}
