package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Path extends Entity{

	
	private final String IMAGE_PATH="D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\path.png";
	
	public Path (final int x, final int y) {
		this.setX(x);
		this.setY(y);
		
		Image img;
		try {
			img = ImageIO.read(new File(IMAGE_PATH));
			this.setImg(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
