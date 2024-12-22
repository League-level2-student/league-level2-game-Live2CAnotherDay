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
public class PinkGGPT extends GameObject{
	
	int yVelocity = -5;
	int gravity = 1;
	int dCounter = 0;
	int frame = 0;
	int side = 0;
	int opp = 1;


	public static BufferedImage[] images = new BufferedImage[10];
	Color color;
	private boolean onGround = false;
	private boolean jumpE = true;
	
	static {
		loadImages();
	}
	
	public PinkGGPT(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		speed = 10;
		this.color = color;
		
	}
	
	static void loadImages() {
		for(int i = 1; i < 4; i ++) {
			
			try {
				images[i-1]= ImageIO.read(WizardPO.class.getResourceAsStream("PGNGP/pgngp"+ i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		for(int i = 4; i < 11; i ++) {
			
			try {
				images[i-1]= ImageIO.read(WizardPO.class.getResourceAsStream("PGNGJP/pgngjp"+ (i-3) + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
	}
	
	public void update() {
		
		// Boundaries//
		if (y > 850) {
			y = 849;
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
		
		if (x < 150) {
			x = 151;
		}else if(x > 1850) {
			x = 1849;
		}
		
		super.update();
	}
	
	public void jump(){
		if (jumpE) {
			yVelocity  = -10;
			onGround = false;
		}
		

		
	}

	public void moveLeft(){
		if (opp == 1) {
			x -= 100;
		}
			x -= 20;
			opp = 0;
		
			super.update();
	}
	
	public void moveRight(){
		if (opp == 0) {
			x += 100;
		}
			x += 20;
			opp = 1;
		
			super.update();
	}
	

	void draw(Graphics g) {
		// TODO Auto-generated method stub
				
				g.setColor(Color.black);
				g.drawRect(x, y, 1, 20);
				
			g.setColor(color);
				
				
				
				//g.fillRect(x, y, width, height);
				if(side == 0 && onGround == true) {
				
					if(opp == 0) {
						g.drawImage(images[frame/3],x ,y, 100, 100, null);
						g.drawString("Player 2", x + 33, y - 1);
					}else {
						g.drawImage(images[frame/3],x ,y, -100, 100, null);
						g.drawString("Player 2", x - 99, y - 1);
					}
					
					frame ++;
					
					if (frame == 12) {
						frame = 0;
					}
					
				}else {
					if(opp == 0) {
						g.drawImage(images[frame/3+3],x ,y, 100, 100, null);
						g.drawString("Player 2", x + 33, y - 1);
					}else {
						g.drawImage(images[frame/3+3],x ,y, -100, 100, null);
						g.drawString("Player 2", x - 99, y - 1);
					}
					
					frame ++;
					if (frame == 12) {
						frame = 0;
					}
				}
				

			}
}

