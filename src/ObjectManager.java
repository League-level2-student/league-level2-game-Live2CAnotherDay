import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ObjectManager implements ActionListener{
	WizardPO wizard;
	PinkGGPT pinkie;
	NyanCatObs meowie;
	TumbleweedObs brownie;
	int p1Lives = 4;
	int p2Lives = 4;
	int p1MikuI = 0;
	int p1WeedI = 0;
	int p2MikuI = 0;
	int p2WeedI = 0;
	int pWait = 0;
	int endScore;
	int score = 0;
	static int winner = 0;
	private ImageIcon heart;
	private ImageIcon deadHeart;
	ImageIcon[] p1;
	ImageIcon[] p2;
	
	public int getScore() {
		
		endScore = score;
		return endScore;
	}

	public ObjectManager(WizardPO wizard, PinkGGPT pinkie, NyanCatObs meowie, TumbleweedObs brownie){
		this.wizard = wizard;
		this.pinkie = pinkie;
		this.meowie = meowie;
		this.brownie = brownie;
		URL bheartURL = getClass().getResource("Heart.gif");
        heart = new ImageIcon(bheartURL);
        URL dHeartURL = getClass().getResource("DeadHeart.gif");
        deadHeart = new ImageIcon(dHeartURL);
        
        p1 = new ImageIcon[4];
        p2 = new ImageIcon[4];
        
	}
	
	void update() {
		checkCollision();
		if (p1Lives > 0 && p2Lives > 0) {
			
			if (p1MikuI > 0) {
				p1MikuI --;
			}else if(p1WeedI > 0) {
				p1WeedI --;
			}

			if (p2MikuI > 0) {
				p2MikuI --;
			}else if(p2WeedI > 0) {
				p2WeedI --;
			}

			if(pWait > 0) {
				pWait --;
			}
			
		}else if (p1Lives <= 0 && p2Lives > 0){
			System.out.println("p2 won!");
			winner = 2;
			GamePanel.currentState = GamePanel.END;
			return;
		}else if(p2Lives <= 0 && p1Lives > 0 ){
			System.out.println("p1 won!");
			winner = 1;
			GamePanel.currentState = GamePanel.END;
			return;
		}else {
			System.out.println("How did both of you guys die???");
			GamePanel.currentState = GamePanel.END;
			return;
		}
		
		
		
	}
	
	void draw(Graphics g) {
		//wizard.draw(g);
		//pinkie.draw(g);
		heart.paintIcon(null, g, 0, 20);
		
		//deadHeart.paintIcon(null, g, 0, 0);
	}
	
	
	void checkCollision() {
		if(p1MikuI == 0 && wizard.collisionBox.intersects(meowie.collisionBox)) {
			p1Lives --;
			System.out.println("p1 Hit with Miku's Cat!");
			p1MikuI = 120;
		}else if(p1WeedI == 0 && wizard.collisionBox.intersects(brownie.collisionBox)) {
			p1Lives --;
			System.out.println("p1 Hit with Spiky Weed!");
			p1WeedI = 120;
		}
		
		
		
		if(p2MikuI == 0 && pinkie.collisionBox.intersects(meowie.collisionBox) ) {
			p2Lives --;
			System.out.println("p2 Hit with Miku's Cat!");
			p2MikuI = 120;
		}else if(p2WeedI == 0 && pinkie.collisionBox.intersects(brownie.collisionBox)){
			p2Lives --;
			System.out.println("p2 Hit with Spiky Weed!");
			p2WeedI = 120;
		}
		
		if(pWait == 0 && wizard.collisionBox.intersects(pinkie.collisionBox)) {
			if(wizard.collisionBox.getY() < pinkie.collisionBox.getY()) {
				p2Lives = p2Lives - 2;
				System.out.println("p1 crited p2!");
				pWait = 180;
			}else if(wizard.collisionBox.getY() == pinkie.collisionBox.getY()) {
				p1Lives = p1Lives - 1;
				p2Lives = p2Lives - 1;
				System.out.println("an eye for an eye");
				pWait = 120;
			}else {
				p1Lives = p1Lives - 2;
				System.out.println("p2 crited p1!");
				pWait = 180;
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}