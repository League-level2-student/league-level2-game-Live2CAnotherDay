import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class TumbleweedObstacle extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public TumbleweedObstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 1;
		if (needImage) {
		    loadImage ("TumbleweedObstacle, floor-1.png.png");
		    loadImage ("TumbleweedObstacle, floor-2.png.png");
		    loadImage ("TumbleweedObstacle, floor-3.png.png");
		    loadImage ("TumbleweedObstacle, floor-4.png.png");
		    loadImage ("TumbleweedObstacle, floor-5.png.png");
		    loadImage ("TumbleweedObstacle, floor-6.png.png");
		    loadImage ("TumbleweedObstacle, floor-7.png.png");
		    loadImage ("TumbleweedObstacle, floor-8.png.png");
		}
	}
	
	void update() {
		x += speed;
		super.update();
	}
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

}
