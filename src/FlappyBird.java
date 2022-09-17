import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlappyBird {

	JFrame frame = new JFrame();

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	void setup() {
		GamePanel panel = new GamePanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.pack();

	}
}
