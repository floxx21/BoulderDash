package entity;


import java.awt.Image;

public class Player extends Creature {
	
	private int x;
	private int y;
	
	public Player(final int x, final int y){
		this.setX(x);
		this.setY(y);
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

}