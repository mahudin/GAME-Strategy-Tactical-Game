package dev.cards;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import dev.main.Handler;
import dev.inventory.Inventory;
import dev.main.gfx.Assets;
import dev.main.gfx.Image;
import dev.main.gfx.Text;

public class WaistCard {

	public Card main_cards[];
	public int size;
	private boolean active=false;
	public Handler handler;
	
	private int invX = 600, invY = 100,
			invSpacing=17,
			invWidth = 664, invHeight = 350;
	private int descX=820,descY=360,
			descWidth=200,descHeight=100;
	
	public void initialize(Handler handler, Card cards[],int size){
		this.main_cards=cards;
		this.size=size;
		this.handler=handler;
		for(Card card : main_cards){
			System.out.println(card.getDesc());
		}
	}
	
	public WaistCard(Handler handler, Card cards[],int size){
		initialize(handler, cards, size);
	}
	
	public WaistCard(){
		Card[] cards= {};
		initialize(null,cards, 0);
	}
	
	public void tick(){
		if(!Inventory.active) return;
	}
	
	public void render(Graphics g){
		Rectangle mouse = new Rectangle(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),1,1); 
		if(!Inventory.active) return;
		g.drawImage(Assets.cards, invX, invY, invWidth, invHeight, null);
		int i=1;
		for(Card card : this.main_cards){
			Rectangle card_rectangle = new Rectangle( 492+(i*Card.invWidth+i*invSpacing), 135, Card.invWidth, Card.invHeight); 
			Rectangle intersection = mouse.intersection(card_rectangle);
			if(!intersection.isEmpty()){
				Text.drawString(g, card.getDesc(), descX,
						descY, true, Color.BLACK, Assets.font_desc_card);	
				System.out.println("przecina karte "+card.toString());
			}
			System.out.println("I printed: "+card.toString());
		
			g.drawImage(card.getImage(), 492+(i*Card.invWidth+i*invSpacing) , 135, Card.invWidth, Card.invHeight, null);
			//if(card.getImage().getType()!=0) System.out.println("Is pic: ");
			i++;
		}
		
	}
	
	public int getSize(){
		return this.size;
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
