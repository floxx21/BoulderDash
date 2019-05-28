package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.Dirt;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	

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

	public int [][] map = new int [20][20] ;
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
        int hauteur = 16;
        int y = 0;
        for (String msg : message)
        { 
        	char[] splitMsg = msg.toCharArray();
        	for (int i = 0; i < splitMsg.length; i++) {
                map[i][y] = splitMsg[i];
                System.out.println(map[i][y]);
        		switch(splitMsg[i]) {
        		case 48:
						graphics.drawImage(new Dirt(i*16, hauteur).getImg(), i*16, hauteur, null);
        			break;
        		case 49:
        			try {
						Image img = ImageIO.read(new File("D:\\CESI\\image\\wall.png"));
						graphics.drawImage(img, i*16, hauteur, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
        			break;
        		case 50:
        			try {
						Image img = ImageIO.read(new File("D:\\CESI\\image\\rock.png"));
						graphics.drawImage(img, i*16, hauteur, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
        			break;
        		case 51:
					try {
						Image img = ImageIO.read(new File("D:\\CESI\\image\\diamond.png"));
						graphics.drawImage(img, i*16, hauteur, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
        			break;
        		case 52:
        			try {
						Image img = ImageIO.read(new File("D:\\CESI\\image\\down.png"));
						graphics.drawImage(img, i*16, hauteur, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
        			break;
        		case 53:
        			try {
						Image img = ImageIO.read(new File("D:\\CESI\\image\\exit.png"));
						graphics.drawImage(img, i*16, hauteur, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
        			break;
        		case 54:
        			try {
						Image img = ImageIO.read(new File("D:\\CESI\\image\\monster.png"));
						graphics.drawImage(img, i*16, hauteur, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
        			break;
        		default:
        			graphics.drawString(String.valueOf(splitMsg[i]), i*16, hauteur);
        			break;
        		}
        	}
         //   graphics.drawString(msg, 1,hauteur);
            hauteur+=16;
        }  

	/*	try {
            img = ImageIO.read(new File("D:\\Images\\playersheet.png"));
            img2 = ImageIO.read(new File("D:\\Images\\diamond1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		if (img != null) {
			graphics.drawImage(img, 0, 0, 16,16, this);
        }
        if (img2 != null) {
        	graphics.drawImage(img2, 16, 0, 16,16, this);
        }
	   
	      /*graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
	      
	      HashMap<Point, String> test = this.getViewFrame().getModel().getHelloWorld().createMap();
	      String test2 = this.getViewFrame().getModel().getHelloWorld().printMap(test);
	       /* String[] message =this.getViewFrame().getModel().getHelloWorld().getMessage().split(";");
	        int hauteur = 16;
	        for (String msg : message)
	        { 
	            graphics.drawString(msg, 1,hauteur);
	            hauteur+=16;
	        }  */
	}
	
}
