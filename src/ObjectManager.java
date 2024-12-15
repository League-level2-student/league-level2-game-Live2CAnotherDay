import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ObjectManager implements ActionListener{
	WizardPO wizard;
	PinkGGPT pinkie;
	NyanCatObs meowie;
	TumbleweedObs brownie;
	int p1Lives = 4;
	int p2Lives = 4;
	
//	public int getScore() {
//		
//		endScore = score;
//		return endScore;
//	}

	public ObjectManager(WizardPO wizard,PinkGGPT pinkie){
		this.wizard = wizard;
		this.pinkie = pinkie;
	}
	
	void update() {
		checkCollision();
	}
	
	void draw(Graphics g) {
		wizard.draw(g);
		pinkie.draw(g);
	}
	
	void checkCollision() {
		if(wizard.collisionBox.intersects(meowie.collisionBox) || wizard.collisionBox.intersects(brownie.collisionBox)) {
			p1Lives --;
			System.out.println("p1 Hit with obstacle!");
		}
		
		if(pinkie.collisionBox.intersects(meowie.collisionBox) || pinkie.collisionBox.intersects(brownie.collisionBox)) {
			p2Lives --;
			System.out.println("p2 Hit with obstacle!");
		}
		
		if(wizard.collisionBox.intersects(pinkie.collisionBox)) {
			if(wizard.collisionBox.getY() < pinkie.collisionBox.getY()) {
				p2Lives = p2Lives - 2;
				System.out.println("p1 crited p2!");
			}else if(wizard.collisionBox.getY() == pinkie.collisionBox.getY()) {
				p1Lives = p1Lives - 1;
				p2Lives = p2Lives - 1;
				System.out.println("an eye for an eye");
			}else {
				p1Lives = p1Lives - 2;
				System.out.println("p2 crited p1!");
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}