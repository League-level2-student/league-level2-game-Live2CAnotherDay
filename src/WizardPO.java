import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//
//import javax.imageio.ImageIO;
//
public class WizardPO extends GameObject{
	
	int yVelocity = -5;
	int gravity = 1;
	int dCounter = 0;

	public static BufferedImage[] images = new BufferedImage[6];
	Color color;
	private boolean onGround = false;
	private boolean jumpE = true;
	
	static {
		loadImages();
	}
	
	public WizardPO(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		speed = 10;
		this.color = color;

	}
	
	static void loadImages() {
		
		for(int i = 1; i < 3; i ++) {
				
			try {
				images[i-1]= ImageIO.read(WizardPO.class.getResourceAsStream("WODIP/unc"+ i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		for(int i = 3; i < 7; i ++) {
			
			try {
				images[i-1]= ImageIO.read(WizardPO.class.getResourceAsStream("WODJP/uncf"+ (i-5) + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
	
	public void update() {
		
		// Boundaries//
		if (y > 740) {
			y = 739;
			onGround = true;
			
		}
		if(!onGround || !jumpE) {
			y += yVelocity;
			yVelocity += gravity;
			jumpE = true;
		}
		while (y < 0) {
			jumpE = false;
			y = 0;
		}
		
		if (x < 0) {
			x = 1;
		}else if(x > 1750) {
			x = 1749;
		}
		
		
	}
	
	public void jump(){
		if (jumpE) {
			yVelocity  = -10;
			onGround = false;
		}
		

		
	}

	public void moveLeft(){
		if (dCounter % 3 == 0) {
			x -= 100;
			System.out.println("P1 Dashed!");
		}else{
			x -= 10;
		}
		
	}
	
	public void moveRight(){
		if (dCounter % 3 == 0) {
			x += 100;
			System.out.println("P1 Dashed!");
		}else{
			x += 10;
		}
	}
	
	
	void draw(Graphics g) {
		
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
			
			g.setColor(Color.red);
			g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		} else {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}

	void loadImage(String imageFile) {
		if(needImage) {
			try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
		}
	}
}

	