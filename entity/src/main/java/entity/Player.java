package entity;

public class Player extends Creature {
	
	public static int startx, x;
	public static int starty, y;
	public static int faceplayer = 1;
	public static int score = 0;
	
	/*private final String IMAGE_PATH_UP="D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\up.png";
	private final String IMAGE_PATH_DOWN="D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\down.png";
	private final String IMAGE_PATH_RIGHT="D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\right.png";
	private final String IMAGE_PATH_LEFT="D:\\EXIA\\Semestre 2\\Projets\\Projet 2\\RESSOURCES PROJET\\sprites\\left.png";*/
	
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