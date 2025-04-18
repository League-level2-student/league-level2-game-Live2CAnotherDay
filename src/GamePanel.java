import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    // Change the size of the images array to 2

    JFrame frame = new JFrame();
    Timer timer;
    ObjectManager oM;
    static final int MENU = 0;
    static final int GAME = 1;
    static final int PURGATORY = 2;
    static final int END = 3;
    
    static int currentState = MENU;
    Font titleFont;
    Font papyrusFont;
    Font miniPappyFont;
    Font endFont;
    int JoustWIDTH = 1200;
    int JoustHEIGHT = 700;

    WizardPO wizard = new WizardPO(200, 300, 80, 80, Color.green);
    PinkGGPT pinkie = new PinkGGPT(1070, 300, 80, 80, Color.pink);
    NyanCatObs meowie = new NyanCatObs( -100, new Random().nextInt(250), 130, 55, Color.blue);
    TumbleweedObs brownie = new TumbleweedObs(-100, -100, 55, 55, Color.BLACK);

    private ImageIcon gifIcon; // Title screen GIF
    private ImageIcon gifIcon2; // Game screen GIF
    private ImageIcon gifIcon3;
    private ImageIcon gifIcon4;

    // Coordinates and dimensions for the clickable text
    private int tipsTextX = 875;
    private int tipsTextY = 600;
    private int tipsTextWidth = 250;  // Width of the clickable area
    private int tipsTextHeight = 25;  // Height of the clickable area
    
    private int againTextX = 1590;
    private int againTextY = 865;
    private int againTextWidth = 310;  // Width of the clickable area
    private int againTextHeight = 25;
    
    public void startGame() {
        // Initialize the game here (e.g., spawn objects, set game variables)
    	wizard = new WizardPO(200, 300, 80, 80, Color.green);
        pinkie = new PinkGGPT(1070, 300, 80, 80, Color.pink);
        meowie = new NyanCatObs( -100, new Random().nextInt(250), 130, 55, Color.blue);
        brownie = new TumbleweedObs(-100, -100, 55, 55, Color.BLACK);
        oM = new ObjectManager(wizard, pinkie, meowie, brownie);
        oM.p1Lives = 4;
        oM.p2Lives = 4;
    //    reloadHeartGifPurgatory();
    }

	public void reloadHeartGifPurgatory() {
		URL gifURL4 = getClass().getResource("LastHeart.gif");
        gifIcon4 = new ImageIcon(gifURL4);
	}
    private static GamePanel instance = null;

    public static GamePanel getInstance() {
    	return instance;
    }
    
    GamePanel() {
    	instance = this;
        // Load GIFs for the title screen and game screen
        URL gifUrl = getClass().getResource("TitleScreen.gif");
        gifIcon = new ImageIcon(gifUrl);
        URL gifUrl2 = getClass().getResource("GameScreen.gif");
        gifIcon2 = new ImageIcon(gifUrl2);
        URL gifUrl3 = getClass().getResource("EndScreen.gif");
        gifIcon3 = new ImageIcon(gifUrl3);
        URL gifURL4 = getClass().getResource("LastHeart.gif");
        gifIcon4 = new ImageIcon(gifURL4);
        
        
        oM = new ObjectManager(wizard, pinkie, meowie, brownie);
        titleFont = new Font("kokonor", Font.PLAIN, 48);
        papyrusFont = new Font("papyrus", Font.PLAIN, 25);
        miniPappyFont = new Font("papyrus", Font.PLAIN, 20);
        endFont = new Font("Bradley Hand", Font.BOLD, 75);
        timer = new Timer(1000 / 60, this);
        setPreferredSize(new Dimension(JoustWIDTH, JoustHEIGHT));
        frame.add(this);
        frame.pack();
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        timer.start();

        // Add MouseListener to detect clicks on the text
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if the click is within the bounds of the clickable text
                if (currentState == MENU && isInsideTipsText(e.getX(), e.getY())) {
                    showTips();
                }
                
                if(currentState == END && isInsideAgainText(e.getX(), e.getY())) {
                	setPreferredSize(new Dimension(1400, 788));
        			frame.pack();
                	currentState = GAME;
                    startGame(); 
                    
                }
            }
        });
    }

    void updateMenuState() {
        // Implement any menu-specific updates here
    }

    void updateGameState() {
        // Implement any game-specific updates here
//    	setPreferredSize(new Dimension(1200, 700));
//    	frame.pack();
    	wizard.update();
        pinkie.update();
        brownie.update();
        meowie.update();
        oM.update();
    }
    
    void updatePurgatoryState(){
    	
    }

    void updateEndState() {
        // Implement end game state updates here
    	
    }
    

    void drawMenuState(Graphics g) {
        g.setColor(Color.BLUE);
        
        gifIcon.paintIcon(this, g, 0, 0); // Draw title screen GIF

        g.setFont(titleFont);
        g.setColor(Color.white);
        g.drawString("JOUST MW", 35, 75);
        g.setFont(papyrusFont);
        g.drawString("Press X to start the Game", 845, 650);
        g.setFont(miniPappyFont);
        g.drawString("Press T or Click for TIPS", tipsTextX, tipsTextY);
    }
    
    int purgatoryFrame = 0;
    
    void drawPurgatoryState(Graphics g){
    	gifIcon4.paintIcon(this, g, 0, 0);
    	if(purgatoryFrame == 660) {
    		setPreferredSize(new Dimension(1900, 1000));
        	frame.pack();
        	purgatoryFrame = 0;
    		currentState = END;
    		
    	}else {
    		purgatoryFrame += 1;
    	}
    }

    void drawGameState(Graphics g) {
//    	g.setColor(Color.GREEN);
        g.fillRect(0, 0, 2000, 1000);
        gifIcon2.paintIcon(this, g, 0, 0);  // Draw game screen GIF
       
        
        wizard.draw(g);
        pinkie.draw(g);
        brownie.draw(g);
        meowie.draw(g);
        oM.draw(g);
    }

    void drawEndState(Graphics g) {
        g.setColor(Color.BLACK.brighter());
        g.fillRect(0, 0, 2000, 1000);  // End game screen with red background
        
        gifIcon3.paintIcon(this, g, 0, 0);
        
        g.setFont(endFont);
        g.setColor(Color.WHITE);
        //g.setColor(Color.red.darker());
        if (ObjectManager.winner == 0) {
        	g.drawString("Both Jousters lost", 400, 100);
        }else if(ObjectManager.winner == 1) {
        	g.drawString("The Wizard won the Joust!", 400, 100);
        }else {
        	g.drawString("The Pink GG won the Joust!", 400, 100);
        }
        
        g.setFont(miniPappyFont);
        g.drawString("Press M to go back to Menu", 1630, 890);
        g.drawString("Press G or Click Me to play again", againTextX, againTextY);
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        if (currentState == MENU) {
            drawMenuState(g);
        } else if (currentState == GAME) {
            drawGameState(g);
           
        } else if (currentState == PURGATORY){
        	drawPurgatoryState(g);
        }
    	else if (currentState == END) {
            drawEndState(g);
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
     

        if (currentState == MENU) {
            updateMenuState();
        } else if (currentState == GAME) {
            updateGameState();
        } else if(currentState == PURGATORY){
        	updatePurgatoryState();
        }else if (currentState == END) {
            updateEndState();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_X) {
            if (currentState == MENU) {
                currentState = GAME;  // Start the game when X is pressed in the menu
                startGame();  // Initialize the game
            }
        }
        
        if (e.getExtendedKeyCode() == KeyEvent.VK_G) {
            if (currentState == END) {
            	setPreferredSize(new Dimension(1400, 788));
    			frame.pack();
            	currentState = GAME;  // Start the game when X is pressed in the menu
                startGame();  // Initialize the game
            }
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_M) {
            if (currentState == END) {
            	setPreferredSize(new Dimension(1200, 700));
    			frame.pack();
                currentState = MENU;  
            }    
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (currentState == GAME) {
        	if (e.getExtendedKeyCode() == KeyEvent.VK_A) {
        		wizard.moveLeft();
        		wizard.dCounter++;
        	}

        	if (e.getExtendedKeyCode() == KeyEvent.VK_D) {
        		wizard.moveRight();
        		wizard.dCounter++;
        	}

        	if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
        		pinkie.moveRight();
        		pinkie.dCounter++;
        	}

        	if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
        		pinkie.moveLeft();
        		pinkie.dCounter++;
        	}

       }
        
       if (e.getExtendedKeyCode() == KeyEvent.VK_T && currentState == MENU) {
    	   showTips();
       }
       if (e.getExtendedKeyCode() == KeyEvent.VK_X) {
    	   JoustWIDTH = 1400;
    	   JoustHEIGHT = 788;
    	   setPreferredSize(new Dimension(JoustWIDTH, JoustHEIGHT));
    	   frame.pack();
    	   currentState = GAME;
    	   startGame();
    	   
       }
        
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_W) {
            if (currentState == GAME) {
            	wizard.jump();
            }
        }

        if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
        	if (currentState == GAME) {
            	pinkie.jump();
            }
        }
    }

    // Show tips in a dialog
    private void showTips() {
        JOptionPane.showMessageDialog(frame,
            "Player 1 is the wizard, Player 2 is the pink girl \n"
            + "In order to win, make sure that your opponent dies first before you do! \n"
            + "Crashing into obstacles or entities will cause player to lose HP \n"
            + "To damage your opponent, collide with them. If you are higher when colliding, you deal double damage. \n"
            + "Staying still will not end well. \n"
            + "Jolly Jousting! :p");
    }

    // Check if the click is inside the clickable area for the tips text
    private boolean isInsideTipsText(int mouseX, int mouseY) {
        return mouseX >= tipsTextX && mouseX <= tipsTextX + tipsTextWidth
                && mouseY >= tipsTextY - tipsTextHeight && mouseY <= tipsTextY;
    }
    
    private boolean isInsideAgainText(int mouseX, int mouseY) {
        return mouseX >= againTextX && mouseX <= againTextX + againTextWidth
                && mouseY >= againTextY - againTextHeight && mouseY <= againTextY;
    }
}
