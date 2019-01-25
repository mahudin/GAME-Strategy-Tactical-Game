package dev.main.states;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import dev.army.Army;
import dev.hud.Hud;
import dev.inventory.ItemManager;
import dev.main.BattleField;
import dev.main.Game;
import dev.main.Handler;
import dev.main.World;
import dev.main.entity.Entity;
import dev.main.entity.EntityManager;
import dev.main.entity.Orc;
import dev.main.entity.Player;
import dev.main.entity.Tree;
import dev.main.entity.cities.Location;
import dev.main.entity.cities.Village;
import dev.main.gfx.Assets;
import dev.main.tiles.Tile;
import dev.main.ui.ClickListener;
import dev.main.ui.UI_imagebutton;
import dev.main.ui.UI_manager;

public class GameState extends State {
	private UI_manager ui_manager;
	private Player player;
	private EntityManager entityManager;
	private ItemManager itemManager;
	private World world;
	private BattleField battlefield;
	private Hud hud;
	private int spawnX,spawnY;
	private boolean is_battle;
	
	public GameState(Handler handler){
		super(handler);
		is_battle=false;
		ui_manager = new UI_manager(handler);
		handler.getMouseManager().setUIManager(ui_manager);
		
		entityManager=new EntityManager(handler,new Player(handler,260,360));
		entityManager.getPlayer().setX(spawnX+130);
		entityManager.getPlayer().setY(spawnY+160);
				
		entityManager.addEntity(new Tree(handler,100,250));
		entityManager.addEntity(new Tree(handler,180,250));
		entityManager.addEntity(new Orc(handler,450,350));
		
		entityManager.addEntity(new Location(handler,650,350,new Village(),"Smithtown"));
	
		itemManager=new ItemManager(handler);
		hud=new Hud(handler,Assets.main_hud,entityManager.getPlayer());
		
		world=new World(handler,"res/maps/world1");
		world.setEntityManager(entityManager);
		world.setItemManager(itemManager);
		world.setHud(hud);
		
		handler.setWorld(world);
		System.out.println("cholerqa");
		
	
	}
	
	public void collision_and_action(){
		
		for(Entity e: entityManager.getEntities()){
			if(e.equals(this)) continue;
			System.out.println(e.getX()+" "+e.getY());
			if(e.getCollisionBounds(0,0).intersects(entityManager.getPlayer().getCollisionBounds(32,16))){
				if(e.getActivity()==3){
					init_battle(e);
					
				}
				//e.hurt(1);
				return;
			}
		}
	}
	
	public void init_battle(Entity e){
		ArrayList<Army> all_army_player=new ArrayList<Army>();
		ArrayList<Army> all_army_enemy=new ArrayList<Army>();
		for(Army a:entityManager.getPlayer().getKnights()) all_army_player.add(a);
		for(Army a:entityManager.getPlayer().getArchers()) all_army_player.add(a);
		if(e instanceof Orc ){
			Orc obj=(Orc) e;
			for(Army a:obj.getKnights()) all_army_enemy.add(a);
			for(Army a:obj.getArchers()) all_army_enemy.add(a);
		}
		
		System.out.println(all_army_player);
		battlefield= new BattleField(handler);
		battlefield.setArmyPlayer(all_army_player);
		battlefield.setArmyEnemy(all_army_enemy);
		battlefield.init();
		is_battle=true;
	}
	
	@Override
	public void tick() {
		if(is_battle){
			battlefield.tick();
		} else {
			world.tick();
		}
		
		collision_and_action();
		//ui_manager.tick();
		//player.tick();
		//game.getGameCamera();
	}

	@Override
	public void render(Graphics g) {
		//Tile.tiles[0].render(g, 0, 0);
		if(is_battle){
			battlefield.render(g);
		} else {
			world.render(g);
		}
		
		//ui_manager.render(g);
		//player.render(g);
	}
}
