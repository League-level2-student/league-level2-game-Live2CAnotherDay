import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Color color;
	private boolean onGround = false;
	private boolean jumpE = true;
	public WizardPO(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		speed = 10;
		this.color = color;
		if(needImage) {
			loadImage("Wizard On Dino Idle-1.png.png");
		}
	}
	
	public void update() {
		
		
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
			System.out.println("Dashed!");
		}else{
			x -= 10;
		}
		
	}
	
	public void moveRight(){
		if (dCounter % 3 == 0) {
			x += 100;
			System.out.println("Dashed!");
		}else{
			x += 10;
		}
	}
	
	
//	public Projectile getProjectile() {
//		return new Projectile(x+width/2, y, 10, 10);
//	}
//	
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