package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Boulder extends Entity {

	/*
	 * Defining a constant for the image path
	 */
	private final String IMAGE_PATH = "images/rock.png";

	/*
	 * Define the coordinates of a stone and set its image
	 */
	public Boulder(final int x, final int y) {
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