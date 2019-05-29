package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Boulder;
import entity.Diamond;
import entity.Dirt;
import entity.Enemy;
import entity.Exit;
import entity.Player;
import entity.Wall;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/*public static int X;
	public static int Y;*/
	
	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	public int [][] map = new int [20][20] ;
	

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}
	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        String[] message =this.getViewFrame().getModel().getHelloWorld().getMessage().split(";");
        int hauteur = 0;
        int y = 0;
        for (String msg : message)
        { 
        	char[] splitMsg = msg.toCharArray();
        	for (int x = 0; x < splitMsg.length; x++) {
                map[x][y] = splitMsg[x];
        		switch(splitMsg[x]) {
        		case 48:
						graphics.drawImage(new Dirt(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		case 49:
        				graphics.drawImage(new Wall(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		case 50:
        				graphics.drawImage(new Boulder(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		case 51:
						graphics.drawImage(new Diamond(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		case 52:
        			try {
						Image img = ImageIO.read(new File("D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\down.png"));
						Player.x = x*16;
						Player.y = hauteur;
						Player.startx = x*16;
						Player.starty = hauteur;
						graphics.drawImage(img, Player.x, Player.y, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
        			break;
        		case 53:
        				graphics.drawImage(new Exit(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		case 54:
        				graphics.drawImage(new Enemy(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		default:
        			graphics.drawString(String.valueOf(splitMsg[x]), x*16, hauteur);
        			break;
        		}
        	}
            hauteur+=16;
            y++;
        }  
	}
	
	public void displayPlayer(Graphics g) throws IOException{
		Image img = ImageIO.read(new File("D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\down.png"));
		Image img2 = ImageIO.read(new File("D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\up.png"));
		Image img3 = ImageIO.read(new File("D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\left.png"));
		Image img4 = ImageIO.read(new File("D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\right.png"));
		Image path = ImageIO.read(new File("D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\path.png"));
		
		/*
		 * When the player walks on the ground or a diamond the block is replaced by a path
		 */
		
		if ((map[Player.x/16][Player.y/16] == 48) || (map[Player.x/16][Player.y/16] == 51)) {
		    g.drawImage(path, Player.startx, Player.starty, null);
		    Player.startx = Player.x;
		    Player.starty = Player.y;
		    g.drawImage(path, Player.startx, Player.starty, null);
		}
		
		/*
		 * When a player walks on a diamond he earns points
		 */
		
        if(map[Player.x/16][Player.y/16] == 51) {
        	Player.score ++;
        	viewFrame.setScore();
        }

        /*
         * Death of the Player
         */
        
        if(map[Player.x/16][Player.y/16] == 54) {
        	viewFrame.printMessage("You are dead !");
        	System.exit(0);
        }
        
        /*
         * When a player walks on a wall or a ball he is teleported back
         */
        
        if (map[Player.x/16][Player.y/16] == 49 || map[Player.x/16][Player.y/16] == 50) {
	        Player.x = Player.startx;
	        Player.y = Player.starty;
        }
        
        /*
         * When the player wins
         */
        
        if ((map[Player.x/16][Player.y/16] == 53) && (Player.score >= 10)) {
        	viewFrame.printMessage("You win !");
        	System.exit(0);
        }
        
        /*
         * Change the image of the player's position when he moves
         */
        
        switch(Player.faceplayer){
		case 1:
			g.drawImage(img, Player.x, Player.y, null);
			break;
		case 2:
			g.drawImage(img2, Player.x, Player.y, null);
			break;
		case 3:
			g.drawImage(img3, Player.x, Player.y, null);
			break;
		case 4:
			g.drawImage(img4, Player.x, Player.y, null);
			break;
		}
		
	}
	
}
