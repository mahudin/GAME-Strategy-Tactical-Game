package dev.main.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.main.Animation;
import dev.main.Handler;
import dev.inventory.Item;
import dev.main.gfx.Assets;
import dev.main.tiles.Tile;

public class Orc extends Creature {
	
	private Animation animDown,animLeft,animRight,animUp,animStand;
	
	public Orc(Handler handler,float x,float y){
		super(handler,x,y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2);
		
		bounds.x=width/2;
		bounds.y=(int) (height/1.2f);
		bounds.width=10;
		bounds.height=(int) (height - height / 1.2f);
		animDown=new Animation(500,Assets.orc_down);
		animLeft=new Animation(500,Assets.orc_left);
		animRight=new Animation(500,Assets.orc_right);
		animUp=new Animation(500,Assets.orc_up);
	}
	
	public void tick(){
		
	}
	
	public void die(){
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int)x,(int)y));
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset())+4, (int) (y - handler.getGameCamera().getyOffset())+5, width, height, null);
	
		//g.setColor(Color.red);
		//g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else if(yMove < 0){
			return animDown.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
			//return animStand.getCurrentFrame();
		}
	}
	
	
}
