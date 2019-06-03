package entity;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Creature {

	/*
	 * Defining constants for x-axis and y-axis of the player's start, player
	 * orientation and score
	 * 
	 */
	public static int startx, x;
	public static int starty, y;
	public static int faceplayer = 1;
	public static int score = 0;

	/*
	 * instantiates the variable image
	 */
	private Image image;

	/*
	 * Defining constants for images paths
	 */
	private final String IMAGE_PATH_UP = "images/up.png";
	private final String IMAGE_PATH_DOWN = "images/down.png";
	private final String IMAGE_PATH_RIGHT = "images/right.png";
	private final String IMAGE_PATH_LEFT = "images/left.png";

	/*
	 * Define the coordinates of the player and set its image according to its orientation
	 */
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

	/*
	 * Define default coordinates of the player
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		this.startx = x;
		this.starty = y;
	}

	/**
	 * Gets the x-axis.
	 *
	 * @return the x-axis
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x-axis.
	 *
	 * @param id the new x-axis
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y-axis.
	 *
	 * @return the y-axis
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y_axis.
	 *
	 * @param id the new y-axis
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImg() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param id the new image
	 */
	public void setImg(Image img) {
		this.image = img;
	}

}