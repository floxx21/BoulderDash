package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Enemy extends Creature {

	/*
	 * Defining a constant for the image path
	 */

	private final String IMAGE_PATH = "images/monster.png";

	/*
	 * Define the coordinates of an enemy and set its image
	 */

	public Enemy(final int x, final int y) {
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
