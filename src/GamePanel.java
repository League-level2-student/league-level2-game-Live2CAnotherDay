import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class GamePanel extends JPanel implements KeyListener, ActionListener{
	
	JFrame frame = new JFrame();
	Timer timer;

	WizardPO wizard = new WizardPO(100, 400, 50, 50, Color.yellow);
	PinkGGPT pinkie = new PinkGGPT(1650, 400, 50, 50, Color.blue);
	NyanCatObs meowie = new NyanCatObs(-100, -100, 80, 40, Color.pink);
	TumbleweedObs brownie = new TumbleweedObs(-100, -100, 35, 35, Color.BLACK);
	
	GamePanel(){
		timer = new Timer(1000/60, this);
	
		setPreferredSize(new Dimension(1800, 800));
		frame.add(this);
		frame.pack();
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		timer.start();

		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		wizard.draw(g);
		pinkie.draw(g);
		brownie.draw(g);
		meowie.draw(g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
		wizard.update();
		pinkie.update();
		brownie.update();
		
		
			meowie.update();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		System.out.println(e.getExtendedKeyCode());
		//System.out.println(e.getKeyChar());
//		System.out.println(e.getExtendedKeyCode());
		// TODO Auto-generated method stub
//		if(e.getExtendedKeyCode() == KeyEvent.VK_W) {
//			System.out.println("P1 Jumped!");
//			wizard.jump();
//		}
//		
//		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
//			System.out.println("P2 Jumped!");
//			pinkie.jump();
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getExtendedKeyCode() == KeyEvent.VK_D) {
			System.out.println("P1 Moved right!");
			wizard.moveRight();
			wizard.dCounter++;
			
		}
		if(e.getExtendedKeyCode() == KeyEvent.VK_A) {
			System.out.println("P1 Moved left!");
			wizard.moveLeft();
			wizard.dCounter++;
		}
		
		if(e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("P2 Moved right!");
			pinkie.moveRight();
			pinkie.dCounter++;
		}
		if(e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("P2 Moved left!");
			pinkie.moveLeft();
			pinkie.dCounter++;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_W) {
			System.out.println("P1 Jumped!");
			wizard.jump();
		}
		
		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
			System.out.println("P2 Jumped!");
			pinkie.jump();
		}

	}
	
	
}



//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//
//import javax.imageio.ImageIO;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
//class GamePanel extends JPanel implements KeyListener, ActionListener{
//
//	Font normalFont;
//	Timer frameDraw;
//	Timer catSpawn;
//
//	WizardPO wizard = new WizardPO(250, 700, 50, 50);
//	ObjectManager objectManager = new ObjectManager(wizard));
//	public static BufferedImage image;
//	public static boolean needImage = true;
//	public static boolean gotImage = false;
//
//	public void startGame() {
//		catSpawn = new Timer(1000, objectManager);
//		catSpawn.start();
//	}
//
//	public GamePanel(){
//		titleFont = new Font("Arial", Font.PLAIN, 48);
//		normalFont = new Font("Arial", Font.PLAIN, 24);
//		frameDraw = new Timer(1000/60, this);
//		frameDraw.start();
//		if (needImage) {
//			loadImage ("space.png");
//		}
//
//	}
//
//	void updateMenuState() {
//
//	}
//
//	void updateGameState() {
//		objectManager.update();
//		if(rocketShip.isActive == false) {
//			currentState = END;
//
//		}
//	}
//
//
//
//	void updateEndState() {
//		rocketShip.isActive = true;
//	}
//
//	void loadImage(String imageFile) {
//		if (needImage) {
//			try {
//				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
//				gotImage = true;
//			} catch (Exception e) {
//
//			}
//			needImage = false;
//		}
//	}
//
//	void drawMenuState(Graphics g) {
//		g.setColor(Color.BLUE);
//		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
//		g.setFont(titleFont);
//		g.setColor(Color.YELLOW);
//		g.drawString("League Invaders", 75, 100);
//		g.setFont(normalFont);
//		g.drawString("Press ENTER to start", 125, 250);
//		g.drawString("Press SPACE for instructions", 90, 550);
//	}
//
//	void drawGameState(Graphics g) {
//
//		if (gotImage) {
//			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
//		} else {
//			g.setColor(Color.BLACK);
//			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
//		}
//		objectManager.draw(g);
//		String scoreString = "score: " +  objectManager.getScore();
//		g.setColor(Color.WHITE);
//		g.drawString(scoreString, 20 , 20);
//	}
//
//	void drawEndState(Graphics g) {
//		g.setColor(Color.RED);
//		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
//		g.setFont(titleFont);
//		g.setColor(Color.CYAN);
//		g.drawString("GAME OVER", 100, 100);
//		g.setFont(normalFont);
//		g.drawString("You destroyed " + objectManager.getScore() + " enemies", 125, 250);
//		g.drawString("Press ENTER to restart", 130, 550);
//	}
//
//	@Override
//	public void paintComponent(Graphics g) {
//		if(currentState == MENU) {
//			drawMenuState(g);
//		}else if(currentState == GAME) {
//			drawGameState(g);
//		}else if(currentState == END) {
//			drawEndState(g);
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(currentState == MENU) {
//			updateMenuState();
//		}else if(currentState == GAME) {
//			updateGameState();
//		}else if(currentState == END) {
//			updateEndState();
//		}
//		//System.out.println("action");
//		repaint();
//
//	}
//
//	@Override
//	public void keyPressed(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
//			if(currentState == END) {
//				currentState = MENU;
//				rocketShip = new Rocketship(250, 700, 50, 50);
//				objectManager = new ObjectManager(rocketShip);
//
//			}
//			else if (currentState == MENU){
//				currentState = GAME;
//				startGame();
//			}
//
//		}
//		if(arg0.getKeyCode() == KeyEvent.VK_UP) {	
//			if (rocketShip.y > 0) {
//				System.out.println("UP");
//				rocketShip.up();
//			}
//		}else if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {			
//			if (rocketShip.y < LeagueInvaders.HEIGHT-rocketShip.height) {
//				System.out.println("DOWN");
//				rocketShip.down();
//			}
//		}else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {			
//			if (rocketShip.x < LeagueInvaders.WIDTH -rocketShip.width) {
//				System.out.println("RIGHT");
//				rocketShip.right();
//			}
//		}else if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {			
//			if (rocketShip.x > 0) {
//				System.out.println("LEFT");
//				rocketShip.left();
//			}
//		}
//		if (currentState == GAME) {
//			if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
//				System.out.println("add projectile");
//				objectManager.addProjectile(rocketShip.getProjectile());
//			}
//
//		}else if(currentState == END) {
//			alienSpawn.stop();
//		}
//
//		if(currentState == MENU) {
//			if(arg0.getKeyCode()== KeyEvent.VK_SPACE) {
//				//System.out.println("Instructions: \n Press the Arrow Keys to move the RocketShip \n Press Space to shoot \n OBJECTIVE: Shoot the Aliens that are attempting to invade earth. \n Tip: Earth has unlimited health bar, so in sticky situations just avoid colliding with the aliens");
//				JOptionPane.showMessageDialog(null, "Instructions: \n Press the Arrow Keys to move the RocketShip \n Press Space to shoot \n OBJECTIVE: Shoot the Aliens that are attempting to invade earth. \n Tip: Earth has unlimited health bar, so in sticky situations just avoid colliding with the aliens");
//			}
//		}
//
//
//	}
//
//	@Override
//	public void keyReleased(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void keyTyped(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//
//	}
//}
//}