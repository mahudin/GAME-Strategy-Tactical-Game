package dev.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.main.Handler;
import dev.main.gfx.Assets;
import dev.main.gfx.Text;
import dev.main.states.State;
import dev.main.ui.ClickListener;
import dev.main.ui.UI_imagebutton;
import dev.main.ui.UI_manager;

public class Inventory {
	private Handler handler;
	public static boolean active=false;
	private ArrayList<Item> inventoryItems;
	private UI_manager ui_manager;
	
	private int invX = 64, invY = 48,
			invWidth=512, invHeight = 384,
			invListCenterX = invX + 171,
			invListCenterY = invY + invHeight / 2+5,
			invListSpacing = 30;
	
	private int invImageX = 452, invImageY = 82,
			invImageWidth = 64, invImageHeight = 64;
	
	private int invCountX = 484, intCountY = 172;
	
	private int selectedItem = 0;
	
	public Inventory(Handler handler){
		this.handler=handler;
		inventoryItems=new ArrayList<Item>();
		addItem(Item.rockItem.createNew(5));
		addItem(Item.clockItem.createNew(3));
	
	}
	
	public void tick(){
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)){
			active=!active;
		} 
		if(!active) return;
				
		System.out.println("Ekwipunek dzia³a !!!");
		for(Item i: inventoryItems){
			System.out.println(i.getName());
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)){
			selectedItem--;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)){
			selectedItem++;
		}
		
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
		
	}
	
	public void render(Graphics g){
		if(!active) return;
		
		g.drawImage(Assets.bfi, invX, invY, invWidth, invHeight, null);
		
		int len = inventoryItems.size();
		if(len == 0) return;
		
		for(int i = -5;i < 6;i++){
			if(selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
					invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font_inventory);	
		}
	}
	
	public void addItem(Item item){
		inventoryItems.add(item);
		for(Item i:inventoryItems){
			if(i.getId()==i.getId()){
				i.setCount(i.getCount()+i.getCount());
				return;
			}
		}
		
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
