package dev.main.ui;
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.main.Handler;

public class UI_manager {
	private Handler handler;
	private ArrayList<UI_object> objects;
	
	public UI_manager(Handler handler){
		this.handler=handler;
		objects=new ArrayList<UI_object>();
	}
	public void tick(){
		for(UI_object o: objects) o.tick();
	}
	public void render(Graphics g){
		for(UI_object o: objects) o.render(g);
	}
	public void onMouseMove(MouseEvent e){
		for(UI_object o:objects) o.onMouseMove(e);
			
	}
	public void onMouseRelease(MouseEvent e){
		for(UI_object o : objects) o.onMouseRelease(e);
	}
	public void addObject(UI_object o){
		objects.add(o);
	}
	public void removeObject(UI_object o){
		objects.remove(o);
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public ArrayList<UI_object> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<UI_object> objects) {
		this.objects = objects;
	}
}