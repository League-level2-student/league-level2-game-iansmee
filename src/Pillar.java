import java.awt.Color;
import java.awt.Graphics;

public class Pillar extends GameObject {

	Pillar top;

	Pillar(double y, int height, Pillar top) {
		super(FlappyBird.WIDTH, y, 100, height);
		this.top = top;
	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, (int) y, width, height);
	}

	public void update() {
		x -= 2;
		if (x <= -100) {
			x = FlappyBird.WIDTH;
			if (top == null) {
				height = GamePanel.rng.nextInt(200) + 200;
			} else {
				y = top.height + 200;
			}
		}
	}

}
