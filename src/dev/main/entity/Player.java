package dev.main.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.army.Army;
import dev.army.Rycerz;
import dev.army.£ucznik;
import dev.army.¯o³nierz;
import dev.cards.Card;
import dev.cards.MagicCard;
import dev.cards.TacticalCard;
import dev.cards.WaistCard;
import dev.main.Animation;
import dev.main.Handler;
import dev.inventory.Inventory;
import dev.main.gfx.Assets;
import dev.main.states.BattleState;
import dev.main.states.State;

public class Player extends Creature{
	
	private Animation animDown,animLeft,animRight,animUp,animStand;
	
	private long attackCooldown=1000,lastAttackTimer,attackTimer=attackCooldown;
	private Inventory inventory;
	private WaistCard waist_cards;
	
	private ArrayList<Army> rycerze;
	private ArrayList<Army> ³ucznicy;
	
	private Coordinant mouse_activity_coord;
	
	private int gold=10;
	private float player_x,player_y;
	
	public ArrayList<Army> getKnights(){
		return rycerze;
	}
	
	public ArrayList<Army> getArchers(){
		return ³ucznicy;
	}
	
	public int get_my_Gold(){
		return gold;
	}
	
	public void add_knight(Rycerz rycerz){
		this.rycerze.add(rycerz);
	}
	
	public void add_archer(£ucznik ³ucznik){
		this.³ucznicy.add(³ucznik);
	}
	
	public int getCount_my_knights(){
		try{
			if(rycerze.isEmpty()) return 0;
			else return rycerze.size();
		} catch(Exception e){
			System.out.println("B³¹d przy dodawaniu armii: " + e.getMessage());
			return 0;
		}
	}
	
	public int getCount_my_archers(){
		try{
			if(³ucznicy.isEmpty()) return 0;
			else return ³ucznicy.size();
		} catch(Exception e){
			System.out.println("B³¹d przy dodawaniu armii: " + e.getMessage());
			return 0;
		}
	}
	
	public Player(Handler handler, float x, float y) {
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT,2);
		this.player_x=x;
		this.player_y=y;
		bounds.x=1;
		bounds.y=32;
		bounds.width=32;
		bounds.height=16;
		animDown=new Animation(500,Assets.player_down);
		animLeft=new Animation(500,Assets.player_left);
		animRight=new Animation(500,Assets.player_right);
		animUp=new Animation(500,Assets.player_up);
		//animStand=new Animation(500,Assets.player_stand);
		inventory=new Inventory(handler);
		
		Card[] cards= {
				new TacticalCard<Integer>(2,1),
				new MagicCard<Integer>(1,1)
		}; 
		
		waist_cards=new WaistCard(handler,cards,1);
		
		mouse_activity_coord=new Coordinant(handler,1,1);
		
		rycerze=new ArrayList<Army>();
		³ucznicy=new ArrayList<Army>();
		
		
		try {
			Rycerz rn=new Rycerz();
			for(int i=0;i<3;i++) this.add_knight(rn);
			£ucznik ³n=new £ucznik();
			for(int b=0;b<4;b++) this.add_archer(³n);
			
			
		} catch(NullPointerException e){
			System.out.println("B³¹d przy dodawaniu armii: " + e.getMessage());
		}
		
	}

	@Override
	public void tick() {
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animUp.tick();
		//animStand.tick();
		getInput();
		move();
		
		//handler.getGameCamera().centerOnEntity(this); // centrowanie kamery na graczu
		//Attack
		checkAttack();
		inventory.tick();
		waist_cards.tick();
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	private void checkAttack(){
		
		attackTimer +=System.currentTimeMillis()-lastAttackTimer;
		lastAttackTimer=System.currentTimeMillis();
		if(attackTimer < attackCooldown) return;
		
		Rectangle cb=getCollisionBounds(0,0);
		Rectangle ar=new Rectangle();
		int arSize=20;
		ar.width=arSize;
		ar.height=arSize;
		if(handler.getKeyManager().aup){
			ar.x=cb.x+cb.width/2-arSize/2;
			ar.y=cb.y-arSize;
			System.out.println("attack_up");
		}else if(handler.getKeyManager().adown){
			ar.x=cb.x+cb.width/2-arSize/2;
			ar.y=cb.y+cb.height;
			System.out.println("attack_down");
		}else if(handler.getKeyManager().aleft){
			ar.x=cb.x-arSize;
			ar.y=cb.y+cb.height/2-arSize/2;
			System.out.println("attack_left");
		}else if(handler.getKeyManager().aright){
			ar.x=cb.x+cb.width;
			ar.y=cb.y+cb.height/2-arSize/2;
			System.out.println("attack_right");
		}else {
			return;
		}
		
		attackTimer=0;
		
		//collision_and_action(ar);
	}
	
	public void die(){
		System.out.println("You are lost");
	}
	
	private void getInputsFromKeys(){
		if(handler.getKeyManager().shift){
			speed=super.DEFAULT_SUPER_SPEED;
		} else{
			speed=super.DEFAULT_SPEED;
		}	
		if(handler.getKeyManager().up){
			yMove = -speed;
			mouse_activity_coord.set_activity(false);
		}	
		if(handler.getKeyManager().down){
			yMove = speed;
			mouse_activity_coord.set_activity(false);
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
			mouse_activity_coord.set_activity(false);
		}
		if(handler.getKeyManager().right){
			xMove = speed;
			mouse_activity_coord.set_activity(false);
		}
			
		
		//mouse_activity_coord.set_activity(false);
	}
	
	private void getInputsFromMouse(){
		if(		   x <= mouse_activity_coord.getX() + 15  && 
				   x >= mouse_activity_coord.getX() - 15  && 
				   y >= mouse_activity_coord.getY() - 15  && 
				   y <= mouse_activity_coord.getY() + 15){
					mouse_activity_coord.set_activity(false);
		}
		
		
		if(mouse_activity_coord.get_activity()!=true){
			if(handler.getMouseManager().isLeftPressed()){
				speed=super.DEFAULT_SPEED;
				mouse_activity_coord.setX(handler.getMouseManager().getMouseX());
				mouse_activity_coord.setY(handler.getMouseManager().getMouseY());
				mouse_activity_coord.set_activity(true);
			}		
		} else if(mouse_activity_coord.get_activity()) {
				speed=super.DEFAULT_SPEED;
				if(mouse_activity_coord.getY()-50 < y){
					yMove = -speed;
				}
				if(mouse_activity_coord.getY()-50 > y){
					yMove = speed;
				}
				if(mouse_activity_coord.getX()-5 < x){
					xMove = -speed;
				}
				if(mouse_activity_coord.getX()-5 > x){
					xMove = speed;
				}
				
		}	
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		if( (mouse_activity_coord.getX()<player_x-50) && (mouse_activity_coord.getX()>player_x+50) 
				&& (mouse_activity_coord.getY()<player_y-50) && (mouse_activity_coord.getY()>player_y+50)){
					speed=0;
					mouse_activity_coord.set_activity(false);
			}
		getInputsFromKeys();
		getInputsFromMouse();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	public void afterRender(Graphics g){
		inventory.render(g);
		waist_cards.render(g);
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
