import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if(needImage) {
			loadImage("rocket.png");
		}
	}
	
	public Projectile getProjectile() {
		return new Projectile(x+width/2, y, 10, 10);
	}
	
	void draw(Graphics g) {
		
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
			
//			g.setColor(Color.red);
//			g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void right() {
		x+= speed;
		update();
	}
	
	public void left() {
		x-= speed;
		update();
	}
	
	public void up() {
		y-= speed;
		update();
	}
	
	public void down() {
		y+= speed;
		update();
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
