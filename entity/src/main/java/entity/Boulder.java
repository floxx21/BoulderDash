package entity;

import java.awt.Graphics;

import Assets ;



public class Boulder extends StaticEntity {

	public Boulder(Handler handler, int x, int y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}
	public void render(Graphics g) {
		g.drawImage(Assets.boulder, (int) (x)), (int) (y, width, height, null);
		
	}