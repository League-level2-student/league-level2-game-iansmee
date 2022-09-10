
public class Bird extends GameObject {
	
	
	int speed = 10;
	
	
	
	
	
	
	
Bird(int x, int y, int width, int height) {
super(x, y, width, height);
}


public void up() {
y-=speed;
}







}
