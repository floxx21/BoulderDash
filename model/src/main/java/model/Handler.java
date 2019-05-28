package model;


import controller.Controller;
import view.GameCamera;

public class Handler {
	
	private static Model game;
	private World world;
	
	
	public Handler(Model game){
		Handler.game = game;
	}
	
	
	//GETSET
	
	public Controller getKeyManager(){
		return game.getKeyManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	public BoulderdashModel getGame() {
		return game;
	}
	public void setGame(BoulderdashModel game) {
		Handler.game = game;
	}

}
