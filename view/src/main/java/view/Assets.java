package view;


import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 16, height = 16;
	
	public static BufferedImage player, dirt, dirt_dig, boulder, wall, diamond, exit, enemy1, enemy2;
	
	public static void init(){
		SpriteSheet sheetplayer = new SpriteSheet(ImageLoader.loadImage("/view/image/spriteplayer.png"));
		SpriteSheet sheettiles = new SpriteSheet(ImageLoader.loadImage("/view/image/spriteobject.png"));
		
		//create player asset
		player = sheetplayer.crop(width * 3, 0, width, height);
		
		//create tiles asset
		wall = sheettiles.crop(0, 0, width, height);
		dirt = sheettiles.crop(width, 0, width, height);
		dirt_dig = sheettiles.crop(width * 2, 0, width, height);
		boulder = sheettiles.crop(width * 3, 0, width, height);
		diamond = sheettiles.crop(width * 4, 0, width, height);
		exit = sheettiles.crop(width * 6, 0, width, height);
		enemy1 = sheettiles.crop(width * 9, 0, width, height);
		enemy2 = sheettiles.crop(width * 10, 0, width, height);
	}
}
