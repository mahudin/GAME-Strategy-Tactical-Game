package dev.main;

public class Handler {
	private Game game;
	private World world;
	public Handler(Game game){
		this.game=game;
	}
	public int getWidth(){
		return game.getWidth();
	}
	public int getHeight(){
		return game.getHeight();
	}
	public Game getGame(){
		return game;
	}
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	public void setGame(Game game){
		this.game=game;
	}
	public void setWorld(World world){
		this.world=world;
	}
	public World getWorld(){
		return world;
	}
}