import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class TumbleweedObs extends GameObject{
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Color color;
	Random rand = new Random();
	int xSpeed = 25;
	int ySpeed = 25;
	private boolean bounce = false; 
	public TumbleweedObs(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		speed = 10;
		this.color = color;
		if(needImage) {
		//	loadImage("rocket.png");
		}
		respawn();
	}
	
	void update() {
		x += xSpeed;
		
		if(xSpeed > 0 && x > 1800) {
			respawn();
		}else if(xSpeed < 0 && x < 0){
			respawn();
		}
		
	}
	
	void respawn() {
		int xSpawn = rand.nextInt(1);
		if (xSpawn == 0) {
			x = -50;
			xSpeed = Math.abs(xSpeed);
		}else if (xSpawn == 1){
			x = 1850;
			xSpeed = -Math.abs(xSpeed);
		}
		y = rand.nextInt(500);
	}
	
	

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect(x, y, width, height);

	}
}
//
//import javax.imageio.ImageIO;
//
//public class TumbleweedObs extends GameObject{
//	public static BufferedImage image;
//	public static boolean needImage = true;
//	public static boolean gotImage = false;	
//	
//	public TumbleweedObs (int x, int y, int width, int height) {
//		super(x, y, width, height);
//		// TODO Auto-generated constructor stub
//		speed = 10;
//		if (needImage) {
//		    loadImage ("bullet.png");
//		}
//	}
//	
//	void update() {
//		y -= speed;
//		super.update();
//	}
//	
//	void draw(Graphics g) {
//		
//		if (gotImage) {
//			g.drawImage(image, x, y, width, height, null);
//		} else {
//			g.setColor(Color.BLUE);
//			g.fillRect(x, y, width, height);
//		}
//	}
//	
//	void loadImage(String imageFile) {
//	    if (needImage) {
//	        try {
//	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
//		    gotImage = true;
//	        } catch (Exception e) {
//	            
//	        }
//	        needImage = false;
//	    }
//	}
//
//}
