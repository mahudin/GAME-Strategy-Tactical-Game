package dev.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import dev.main.entity.Entity;
import dev.main.entity.EntityManager;
import dev.main.entity.Orc;
import dev.main.entity.Player;
import dev.main.entity.Tree;
import dev.main.entity.cities.Location;
import dev.main.entity.cities.Metropolis;
import dev.main.entity.cities.Place;
import dev.main.entity.cities.Village;
import dev.main.gfx.Assets;
import dev.main.states.BattleState;
import dev.main.states.State;
import dev.main.tiles.Tile;
import dev.main.ui.ClickListener;
import dev.main.ui.UI_imagebutton;
import dev.main.ui.UI_manager;
import dev.army.Army;
import dev.army.Rycerz;
import dev.army.£ucznik;
import dev.hud.Hud;
import dev.inventory.ItemManager;

public class World {
	
	private int width,height;
	private int[][] tiles;
	private int spawnX,spawnY;
	//private Game game;
	private Handler handler;
	private EntityManager entityManager;
	private ItemManager itemManager;
	private Hud hud;
	
	public World(Handler handler,String path){
		loadWorld(path);
		this.handler=handler;
		
		
	}
	

	
	
	public void setHud(Hud hud) {
		this.hud=hud;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void tick(){
		itemManager.tick();
		entityManager.tick();
		hud.tick();
		this.handler.getGameCamera().onMouseMoving(handler.getMouseManager());
	}
	
	public void render(Graphics g){
		int xStart=(int) Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int xEnd=(int) Math.min(width,(handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH+1);
		int yStart=(int) Math.max(0,handler.getGameCamera().getyOffset()/Tile.TILEWIDTH);
		int yEnd=(int) Math.min(height,(handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGHT+1);
		
		for(int y= yStart;y < yEnd;y++){
			for(int x= xStart;x < xEnd;x++){
				getTile(x,y).render(g,(int)( x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()) ,
						(int)( y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
		hud.render(g);
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public ItemManager getItemManager() {
		return itemManager;
	}
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	public Tile getTile(int x,int y){
		
		if(x<0||y<0||x>=width||y>=height) return Tile.grassTile;
		
		Tile t=Tile.tiles[tiles[x][y]];
		if(t==null) return Tile.grassTile;
		return t;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	private void loadWorld(String path){
		String file=Utils.loadFileAsString(path);
		String[] tokens=file.split("\\s+");
		width=Utils.parseInt(tokens[0]);
		height=Utils.parseInt(tokens[1]);
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		tiles=new int[width][height];
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
	}
}
