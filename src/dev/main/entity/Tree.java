package dev.main.entity;

import java.awt.Graphics;

import dev.main.Handler;
import dev.main.gfx.Assets;
import dev.main.tiles.Tile;

public class Tree extends StaticEntity {
	
	public Tree(Handler handler,float x,float y){
		super(handler,x,y,Tile.TILEWIDTH*3,Tile.TILEHEIGHT*5);
		
		bounds.x=width/2;
		bounds.y=(int) (height/1.2f);
		bounds.width=10;
		bounds.height=(int) (height - height / 1.2f);
	}
	
	public void tick(){
		
	}
	
	public void die(){
		System.out.println("You lost");
	}
	
	public void render(Graphics g){
		g.drawImage(Assets.high_tree,(int) (x - handler.getGameCamera().getxOffset()),(int) (y- handler.getGameCamera().getyOffset()),width,height,null);
	}
}
