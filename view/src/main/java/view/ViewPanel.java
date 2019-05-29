package view;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import entity.Boulder;
import entity.Diamond;
import entity.Dirt;
import entity.Enemy;
import entity.Exit;
import entity.Path;
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
        				Player p = new Player(x*16, hauteur);
        				p.setLocation(x*16, hauteur);
        				graphics.drawImage(new Player(x*16, hauteur).getImg(), Player.x, Player.y, null);
        			break;
        		case 53:
        				graphics.drawImage(new Exit(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		case 54:
        				graphics.drawImage(new Enemy(x*16, hauteur).getImg(), x*16, hauteur, null);
        			break;
        		case 55:
    					graphics.drawImage(new Path(x*16, hauteur).getImg(), x*16, hauteur, null);
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
	
	public void rock(Graphics g){
		for(int x = 0; x < 20; x++){
			for(int y = 0; y < 20; y++){
				if(map[x][y] == 50){
					if(map[x][y+1] == 55){
						g.drawImage(new Path(x*16, y*16).getImg(), x*16, y*16, null);
						g.drawImage(new Boulder(x*16, y*16).getImg(), x*16, y*16+16, null);
						map[x][y+1] = 50;
						map[x][y] = 55;
					}
					else if(map[x+1][y] == 55 && map[x-1][y] != 55){
						if(map[x+1][y+1] == 55){
							g.drawImage(new Path(x*16, y*16).getImg(), x*16, y*16, null);
							g.drawImage(new Boulder(x*16, y*16).getImg(), x*16+16, y*16+16, null);
							map[x+1][y+1] = 50;
							map[x][y] = 55;
						}
					}
					else if(map[x-1][y] == 55 && map[x+1][y] != 55){
						if(map[x-1][y+1] == 55){
							g.drawImage(new Path(x*16, y*16).getImg(), x*16, y*16, null);
							g.drawImage(new Boulder(x*16, y*16).getImg(), x*16-16, y*16+16, null);
							map[x-1][y+1] = 50;
							map[x][y] = 55;
						}
					}
					else if(map[x+1][y] == 55 && map[x-1][y] == 55){
						if(map[x+1][y+1] == 55){
							g.drawImage(new Path(x*16, y*16).getImg(), x*16, y*16, null);
							g.drawImage(new Boulder(x*16, y*16).getImg(), x*16+16, y*16+16, null);
							map[x+1][y+1] = 50;
							map[x][y] = 55;
						}
					}
				}
				if(map[x][y] == 51){
					if(map[x][y+1] == 55){
						if(Player.x == x*16 && Player.y == y*16){
							g.drawImage(new Path(x*16, y*16).getImg(), x*16, y*16, null);
							map[x][y] = 55;
						}else{
							g.drawImage(new Path(x*16, y*16).getImg(), x*16, y*16, null);
							g.drawImage(new Diamond(x*16, y*16).getImg(), x*16, y*16+16, null);
							map[x][y+1] = 51;
							map[x][y] = 55;
						}
					}
				}
			}
		}
	}
	
	public void displayPlayer(Graphics g) throws IOException{
		
		/*
		 * When the player walks on the ground or a diamond the block is replaced by a path
		 */
		
		if ((map[Player.x/16][Player.y/16] == 48) || (map[Player.x/16][Player.y/16] == 51) || (map[Player.x/16][Player.y/16] == 55)) {
		    g.drawImage(new Path(Player.startx*16, Player.starty).getImg(), Player.startx, Player.starty, null);
		    map[Player.startx/16][Player.starty/16] = 55;
		    Player.startx = Player.x;
		    Player.starty = Player.y;
		    g.drawImage(new Path(Player.startx*16, Player.starty).getImg(), Player.startx, Player.starty, null);
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
        
        if ((map[Player.x/16][Player.y/16] == 49) || (map[Player.x/16][Player.y/16] == 50)) {
	        Player.x = Player.startx;
	        Player.y = Player.starty;
        }
        
        /*
         * When the player wins
         */
        
        if ((map[Player.x/16][Player.y/16] == 53) && (Player.score >= 10)) {
        	viewFrame.printMessage("You win !");
        	System.exit(0);
        }else if ((map[Player.x/16][Player.y/16] == 53) && (Player.score < 10)){
        	viewFrame.printMessage("You haven't 10 diamonds !");
        	Player.x = Player.startx;
	        Player.y = Player.starty;
        }
        
        /*
         * View player's image
         */
        
        g.drawImage(new Player(Player.x, Player.y).getImg(), Player.x, Player.y, null);
	}
	
}
