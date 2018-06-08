package dev.main;

public class Start {
	/**
	 * Uruchamiamy nasz¹ grê
	 * @param args
	 * 
	 */
	public static int width=1360;
	public static int height=760;
	
	public static void main(String args[]){
		Game game=new Game("Turan",width,height);
		game.start();
	}
}
