import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class NyanCatObs extends GameObject{
	
	public static BufferedImage[] images = new BufferedImage[10];
	
	public static boolean gotImage = false;	
	Color color;
	Random rand = new Random();
	int xSpeed = 25; 
	int frame = 0;
	int side = 0;
	
	static {
		loadImages();
	}
	
	public NyanCatObs(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		speed = 10;
		this.color = color;
		
		respawn();
	}
	
	static void loadImages() {
		
		for(int i = 1; i < 6; i ++) {
				
			try {
				images[i-1]= ImageIO.read(NyanCatObs.class.getResourceAsStream("UNCObs/unc"+ i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		for(int i = 6; i < 10; i ++) {
			
			try {
				images[i-1]= ImageIO.read(NyanCatObs.class.getResourceAsStream("UNCFObs/uncf"+ (i-5) + ".png"));
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
		}else if(xSpeed < 0 && x < -120){
			respawn();
		}

	}

	void respawn() {
		
		int xSpawn = rand.nextInt(2);
		if (xSpawn == 0) {
			x = -120;
			xSpeed = Math.abs(xSpeed);
			side = 0;
			
		}else if (xSpawn == 1){
			x = 2120;
			xSpeed = - Math.abs(xSpeed);
			side = 1;
		}
		y = rand.nextInt(475);
	}



	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		//g.fillRect(x, y, width, height);
		if(side == 0) {
			g.drawImage(images[frame/3],x ,y, 120, 55, null);
			frame ++;
			if (frame == 12) {
				frame = 0;
			}
		}else {
			g.drawImage(images[(frame/3)+5],x ,y, 120, 55, null);
			frame ++;
			if (frame == 12) {
				frame = 0;
			}
		}
		

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
