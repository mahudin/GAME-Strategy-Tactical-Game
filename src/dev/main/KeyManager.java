package dev.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys,justPressed,cantPress;
	public boolean up, down, left, right,shift,esc;
	public boolean aup, adown, aleft, aright;
	
	public KeyManager(){
		keys = new boolean[256];
		justPressed=new boolean[keys.length];
		cantPress=new boolean[keys.length];
	}
	public boolean keyJustPressed(int keyCode){
		  if(keyCode < 0 || keyCode >= keys.length)
		    return false;
		  return justPressed[keyCode];
		}
	public void tick(){
		for(int i=0;i<keys.length;i++){
			if(cantPress[i]&&!keys[i]){
				cantPress[i]=false;
			}else if(justPressed[i]){
				cantPress[i]=true;
				justPressed[i]=false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i]=true;
			}
		}
		if(keyJustPressed(KeyEvent.VK_E)){
			System.out.println("E JUST PRESSED");
		}
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		shift = keys[KeyEvent.VK_SHIFT];
		esc = keys[KeyEvent.VK_ESCAPE];
		
		aup = keys[KeyEvent.VK_UP];
		adown = keys[KeyEvent.VK_DOWN];
		aleft = keys[KeyEvent.VK_LEFT];
		aright = keys[KeyEvent.VK_RIGHT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}