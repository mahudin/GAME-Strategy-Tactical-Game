package dev.inventory;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.main.Handler;
import dev.main.gfx.Assets;

public class Item {
	
	public static Item[] items=new Item[256];
	public static Item rockItem=new Item(Assets.naked_rock,"Rock",1);
	public static Item clockItem=new Item(Assets.naked_rock,"Clock",2);
	
	public static final int ITEMWIDTH=32,ITEMHEIGHT=32,PICKED_UP=-1;
	
	protected Handler handler;
	protected BufferedImage textura;
	protected String name;
	protected final int id;
	
	protected Rectangle bounds;
	
	protected int x,y,count;
	protected boolean pickedUp=false;
	
	public boolean isPickedUp() {
		return pickedUp;
	}
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
	public Item(BufferedImage textura,String name,int id){
		this.textura=textura;
		this.name=name;
		this.id=id;
		count=1;
		bounds=new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);
		items[id]=this;
	}
	public void tick(){
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
			pickedUp=true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	public Item createNew(int count){
		Item i=new Item(textura,name,id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	public Item createNew(int x,int y){
		Item i=new Item(textura,name,id);
		i.setPosition(x,y);
		return i;
	}
	
	public void setPosition(int x,int y){
		this.x=x;
		this.y=y;
		bounds.x=x;
		bounds.y=y;
	}
	
	public void render(Graphics g){
		if(handler==null) return;
		render(g,(int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()));
	}
	
	
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public BufferedImage getTextura() {
		return textura;
	}
	public void setTextura(BufferedImage textura) {
		this.textura = textura;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void render(Graphics g,int x,int y){
		g.drawImage(textura, x, y, ITEMWIDTH,ITEMHEIGHT,null);
	}
}
