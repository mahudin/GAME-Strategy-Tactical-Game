package dev.main.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.main.Animation;
import dev.main.Handler;
import dev.army.Army;
import dev.army.Rycerz;
import dev.army.£ucznik;
import dev.inventory.Item;
import dev.main.gfx.Assets;
import dev.main.tiles.Tile;

public class Orc extends Enemy {
	
	private Animation animDown,animLeft,animRight,animUp,animStand;
	private ArrayList<Army> rycerze;
	private ArrayList<Army> ³ucznicy;
	

	public ArrayList<Army> getKnights(){
		return rycerze;
	}
	
	public ArrayList<Army> getArchers(){
		return ³ucznicy;
	}
	

	public void add_knight(Rycerz rycerz){
		this.rycerze.add(rycerz);
	}
	
	public void add_archer(£ucznik ³ucznik){
		this.³ucznicy.add(³ucznik);
	}
	
	public Orc(Handler handler,float x,float y){
		super(handler,x,y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2,3);
		
		bounds.x=width/2;
		bounds.y=(int) (height/1.2f);
		bounds.width=10;
		bounds.height=(int) (height - height / 1.2f);
		animDown=new Animation(500,Assets.orc_down);
		animLeft=new Animation(500,Assets.orc_left);
		animRight=new Animation(500,Assets.orc_right);
		animUp=new Animation(500,Assets.orc_up);
		
		rycerze=new ArrayList<Army>();
		³ucznicy=new ArrayList<Army>();
		
		try {
			Rycerz rn=new Rycerz();
			for(int i=0;i<2;i++) this.add_knight(rn);
			£ucznik ³n=new £ucznik();
			for(int b=0;b<2;b++) this.add_archer(³n);
			
			
		} catch(NullPointerException e){
			System.out.println("B³¹d przy dodawaniu armii: " + e.getMessage());
		}
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

	@Override
	public void set_activity(int activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_activity() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
