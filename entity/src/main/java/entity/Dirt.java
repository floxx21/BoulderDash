package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Dirt extends Entity {

	/*
	 * Defining a constant for the image path
	 */

	private final String IMAGE_PATH = "images/dirt.png";

	/*
	 * Define the coordinates of a dirt block and set its image
	 */

	public Dirt(final int x, final int y) {
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
