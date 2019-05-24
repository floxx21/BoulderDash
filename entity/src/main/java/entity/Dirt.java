package entity;

import java.awt.Graphics;

import javax.xml.ws.handler.Handler;

import model.tiles.Tile;



public class Dirt extends StaticEntity {

	public Dirt(Handler handler, int x, int y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dirt, x, y, width, height, null);
	}

	@Override
	public void die() {
		
	}

}
