package dev.main.states;
import java.awt.Graphics;

import dev.main.Game;
import dev.main.Handler;
public abstract class State {
	private static State currentState = null;
	
	protected Game game;
	
	public State(Handler handler){
		this.handler = handler;
	}
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	protected Handler handler;
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
