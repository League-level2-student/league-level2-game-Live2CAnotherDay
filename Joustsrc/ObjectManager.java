import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocketship;
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;
	int endScore = 0;
	
	
	public int getScore() {
		
		endScore = score;
		return endScore;
	}


	public ObjectManager(Rocketship rocketship){
		this.rocketship = rocketship;
		projectiles = new ArrayList <Projectile>();
	}
	
	
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}
	
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if(aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
			
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		
		checkCollision();
		purgeObjects();
	}
	
	void draw(Graphics g) {
		rocketship.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if(!aliens.get(i).isActive) {
				aliens.remove(i);
				i--;
			}
			
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isActive) {
				projectiles.remove(i);
				i--;
			}
			
		}
	}
	
	void checkCollision() {
		for(int i = 0; i < projectiles.size(); i++) {
			for(int z = 0; z < aliens.size(); z++) {
				if (projectiles.get(i).collisionBox.intersects(aliens.get(z).collisionBox)) {
					aliens.get(z).isActive = false;
					projectiles.get(i).isActive = false;
					score ++;
				}
			}
		}
		for(int w = 0; w < aliens.size(); w++) {
			if (rocketship.collisionBox.intersects(aliens.get(w).collisionBox)) {
				
				rocketship.isActive = false;

			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
