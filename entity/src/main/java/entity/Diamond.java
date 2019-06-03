package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Diamond extends Entity {

	/*
	 * Defining a constant for the image path
	 */

	private final String IMAGE_PATH = "images/diamond.png";

	/*
	 * Define the coordinates of a diamond and set its image
	 */

	public Diamond(final int x, final int y) {
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
