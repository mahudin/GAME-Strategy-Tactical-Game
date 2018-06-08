package dev.main.entity;

import java.awt.Graphics;

import dev.main.Handler;
import dev.main.gfx.Assets;
import dev.main.tiles.Tile;

public class Coordinant extends StaticEntity {
	private boolean is_active=false;
	public Coordinant(Handler handler,float x,float y){
		super(handler,x,y,1,1);
		
		/*bounds.x=width/2;
		bounds.y=(int) (height/1.2f);
		bounds.width=1;
		bounds.height=1;*/
	}
	
	public void set_activity(boolean activity){
		is_active=activity;
	}
	
	public boolean get_activity(){
		return is_active;
	}
	
	public void tick(){}
	
	public void die(){}
	
	public void render(Graphics g){
		//g.drawImage(Assets.high_tree,(int) (x - handler.getGameCamera().getxOffset()),(int) (y- handler.getGameCamera().getyOffset()),width,height,null);
	}
}
