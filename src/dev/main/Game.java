package dev.main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.main.gfx.Assets;
import dev.main.states.BattleState;
import dev.main.states.GameState;
import dev.main.states.MenuState;
import dev.main.states.State;

public class Game implements Runnable {
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	private State battleState;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private GameCamera gameCamera;
	
	private Handler handler;
	
	private int time_second;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager=new MouseManager();
	}
	
	/**
	 * Uruchamianie g³ównego w¹tku (jednego) akcji gry z pêtl¹ nieskoñczon¹
	 */
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
				time_second++;
			}
		}
		stop();
	}
	public int getTime_second() {
		return time_second;
	}

	public void setTime_second(int time_second) {
		this.time_second = time_second;
	}

	/**
	 * Ustawianie kamery w trakcie gry oraz stanu (czy jesteœmy w menu czy w grze)
	 */
	
	private void init(){
		display = new Display(title, width, height);
		display.getJFrame().addKeyListener(keyManager);
		display.getJFrame().addMouseListener(mouseManager);
		display.getJFrame().addMouseMotionListener(mouseManager);
		
		display.getcanvas().addMouseListener(mouseManager);
		display.getcanvas().addMouseMotionListener(mouseManager);
		
		
		Assets.init();
		handler=new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
			
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		battleState = new BattleState(handler);
		State.setState(menuState);
	}
	
	private void tick(){
		keyManager.tick();
		if(handler.getKeyManager().esc)
			State.setState(menuState);
		
		if(handler.getKeyManager().shift)
			State.setState(battleState);
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	/**
	 * Rysowanie obiektów na kontekœcie aplikacji, zale¿ne od stanu
	 */
	
	private void render(){
		bs = display.getcanvas().getBufferStrategy();
		if(bs == null){
			display.getcanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null) State.getState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public State getGameState(){
		return gameState;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	/**
	 * Kontrola w¹tków przy starcie i przy koñcu
	 */
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}