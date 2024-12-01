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
	int frame = 0;
	int side = 0;

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
				images[i-1]= ImageIO.read(WizardPO.class.getResourceAsStream("WODIP/wodp"+ i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		for(int i = 3; i < 7; i ++) {
			
			try {
				images[i-1]= ImageIO.read(WizardPO.class.getResourceAsStream("WODJP/wodjp"+ (i-5) + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
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
	
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		//g.fillRect(x, y, width, height);
		if(side == 0) {
			g.drawImage(images[frame/3],x ,y, 100, 50, null);
			frame ++;
			if (frame == 12) {
				frame = 0;
			}
		}else {
			g.drawImage(images[(frame/3)+5],x ,y, 100, 50, null);
			frame ++;
			if (frame == 12) {
				frame = 0;
			}
		}
		

	}
	
	
}

	