import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TumbleweedObs extends GameObject{
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Color color;
	private boolean onGround = false;
	private boolean jumpE = true;
	public TumbleweedObs(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		speed = 10;
		this.color = color;
		if(needImage) {
		//	loadImage("rocket.png");
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
