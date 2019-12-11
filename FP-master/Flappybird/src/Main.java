import javax.swing.JFrame;

public class Main {
	
	private JFrame frame;
	
	public Main() {
		createFrame();
	}
	
	private void createFrame() {
		frame = new JFrame("Flappy Bird");
		frame.setSize(300, 900);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
}
