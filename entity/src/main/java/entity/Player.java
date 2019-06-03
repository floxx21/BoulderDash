package entity;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Creature {

	public static int startx, x;
	public static int starty, y;
	public static int faceplayer = 1;
	public static int score = 0;

	private Image image;

	private final String IMAGE_PATH_UP = "images/up.png";
	private final String IMAGE_PATH_DOWN = "images/down.png";
	private final String IMAGE_PATH_RIGHT = "images/right.png";
	private final String IMAGE_PATH_LEFT = "images/left.png";

	public Player(final int x, final int y) {
		this.setX(x);
		this.setY(y);

		switch (Player.faceplayer) {
		case 1:
			InputStream in = getClass().getResourceAsStream(IMAGE_PATH_DOWN);
			try {
				BufferedImage img = ImageIO.read(in);
				this.setImg(img);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case 2:
			InputStream in2 = getClass().getResourceAsStream(IMAGE_PATH_UP);
			try {
				BufferedImage img = ImageIO.read(in2);
				this.setImg(img);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case 3:
			InputStream in3 = getClass().getResourceAsStream(IMAGE_PATH_LEFT);
			try {
				BufferedImage img = ImageIO.read(in3);
				this.setImg(img);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case 4:
			InputStream in4 = getClass().getResourceAsStream(IMAGE_PATH_RIGHT);
			try {
				BufferedImage img = ImageIO.read(in4);
				this.setImg(img);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		}
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		this.startx = x;
		this.starty = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImg() {
		return image;
	}

	public void setImg(Image img) {
		this.image = img;
	}

}