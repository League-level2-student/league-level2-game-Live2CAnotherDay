import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class NyanCatObs extends GameObject{

	public NyanCatObs(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

}



//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//
//import javax.imageio.ImageIO;
//

//	public static BufferedImage image;
//	public static boolean needImage = true;
//	public static boolean gotImage = false;	
//	
//	public NyanCatObs(int x, int y, int width, int height) {
//		super(x, y, width, height);
//		// TODO Auto-generated constructor stub
//		speed = 1;
//		if (needImage) {
//		    loadImage ("alien.png");
//		}
//	}
//	
//	void update() {
//		y += speed;
//		super.update();
//	}
//	
//	void draw(Graphics g) {
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
