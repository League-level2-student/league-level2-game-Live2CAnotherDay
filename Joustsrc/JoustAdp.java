import javax.swing.JFrame;

public class JoustAdp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JoustAdp joustAdp = new JoustAdp();
		joustAdp.setup();
	}
	
	GamePanel gamePanel;
	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	
	public JoustAdp() {
		frame.getMaximumSize();
		gamePanel = new GamePanel();
	}
	
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePanel);
	}
	
	
	
}