package entity;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Enemy extends Creature{
	
	/*
	* defining a constant for the image
	*/
	
private final String IMAGE_PATH="images/monster.png";
	
/*
 * instantiates a new entity for the enemies
 */
	public Enemy (final int x, final int y) {
		this.setX(x);
		this.setY(y);
		InputStream in = getClass().getResourceAsStream(IMAGE_PATH);
		try {
			BufferedImage img = ImageIO.read(in);
			this.setImg(img);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}


