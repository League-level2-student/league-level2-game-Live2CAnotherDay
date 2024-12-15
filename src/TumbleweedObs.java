import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class TumbleweedObs extends GameObject{
	
	public static BufferedImage[] images = new BufferedImage[8];

	public static boolean gotImage = false;	
	Color color;
	Random rand = new Random();
	int frame = 0;
	int xSpeed = 20;
	int ySpeed = 0;
	int gravity = 1;
	
	static {
		loadImages();
		
	}
	
	public TumbleweedObs(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		speed = 10;
		this.color = color;
		
		respawn();
	}
	static void loadImages() {
		for(int i = 1; i < 9; i ++) {
			try {
				images[i-1]= ImageIO.read(TumbleweedObs.class.getResourceAsStream("TWObs/tw"+ i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
            
	}
	
	void update() {
		x += xSpeed;
		
		if(xSpeed > 0 && x > 2000) {
			respawn();
		}else if(xSpeed < 0 && x < 0){
			respawn();
		}
		
		if(y < 885){
			y += ySpeed;
			ySpeed += gravity;
		}else if(y >= 885) {			
			ySpeed = -25;
			y += ySpeed;
		}
		
		super.update();
	}
	
	void respawn() {
		int xSpawn = rand.nextInt(2);
		if (xSpawn == 0) {
			x = -55;
			xSpeed = Math.abs(xSpeed);
		}else if (xSpawn == 1){
			x = 1955;
			xSpeed = - Math.abs(xSpeed);
		}
		y = rand.nextInt(275)+700;
		
		super.update();
	}
	
	

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		//g.fillRect(x, y, width, height);
		g.drawImage(images[frame],x ,y, 55, 55, null);
		frame ++;
		if (frame == 8) {
			frame = 0;
		}
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

//
//}
