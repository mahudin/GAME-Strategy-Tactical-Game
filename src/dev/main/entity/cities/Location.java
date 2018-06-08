package dev.main.entity.cities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dev.main.Handler;
import dev.main.entity.Entity;
import dev.main.entity.StaticEntity;
import dev.main.gfx.Assets;
import dev.main.tiles.Tile;



public class Location<T extends Place & Comparable<T> > extends StaticEntity {
	protected int number_of_people;
	private T place;
	private String title;
	
	private Comparator<Place> sort = new Comparator<Place>(){
		@Override
		public int compare(Place a, Place b){
			if(a.getID() < b.getID() ) return -1;
			return 1;
		}
	};
	
	public Location(Handler handler,float x,float y,T place, String title){
		super(handler,x,y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		this.place= place;
		this.title=title;
		bounds.x=width/4;
		bounds.y=(int) (height/6);
		bounds.width=15;
		bounds.height=(int) (height - height / 4.5);
	}
	
	public List<T> sort(List<T> places){
		Collections.sort(places);
	    return places;
	}
	
	public void tick(){
		
	}
	
	public void die(){
		System.out.println("You lost");
	}
	
	public void render(Graphics g){
		g.drawImage(place.getGraphicPlace(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y- handler.getGameCamera().getyOffset()),width,height,null);
	}
}
