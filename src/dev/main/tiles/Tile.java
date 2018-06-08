package dev.main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static final int TILEWIDTH=32,TILEHEIGHT=32;
	
	public static Tile[] tiles=new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new RockTile(1);
	public static Tile groceryTile = new GroceryTile(2);
	public static Tile oceanTile = new OceanTile(3);
	public static Tile beachTile = new BeachTile(4);
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture,int id){
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
	}
	public int getId(){
		return id;
	}
	public void tick(){
		
	}
	public void render(Graphics g,int x,int y){
		g.drawImage(texture, x, y, TILEWIDTH,TILEHEIGHT,null);
	}
	public boolean isSolid(){
		return false;
	}
}
