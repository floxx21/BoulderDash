package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamond extends Entity{

private final String IMAGE_PATH="D:\\CESI\\image\\diamond.png";
	
	public Diamond (final int x, final int y) {
		this.setX(x);
		this.setY(y);
		Image img;
		try {
			img = ImageIO.read(new File(IMAGE_PATH));
			this.setImg(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
