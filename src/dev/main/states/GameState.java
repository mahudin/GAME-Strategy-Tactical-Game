package dev.main.states;

import java.awt.Graphics;

import dev.main.Game;
import dev.main.Handler;
import dev.main.World;
import dev.main.entity.Player;
import dev.main.gfx.Assets;
import dev.main.tiles.Tile;
import dev.main.ui.ClickListener;
import dev.main.ui.UI_imagebutton;
import dev.main.ui.UI_manager;

public class GameState extends State {
	private UI_manager ui_manager;
	private Player player;
	private World world;
	public GameState(Handler handler){
		super(handler);
		ui_manager = new UI_manager(handler);
		handler.getMouseManager().setUIManager(ui_manager);
		
		world=new World(handler,"res/maps/world1");
		handler.setWorld(world);
		
		//player = new Player(handler, 280, 130);
		/*ui_manager = new UI_manager(handler);
		handler.getMouseManager().setUIManager(ui_manager);
		
		ui_manager.addObject(new UI_imagebutton(10, 230, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				System.exit(1);
				//State.setState(handler.getGame().getGameState());
			}
		}));*/
	}
	
	@Override
	public void tick() {
		world.tick();
		//ui_manager.tick();
		//player.tick();
		//game.getGameCamera();
	}

	@Override
	public void render(Graphics g) {
		//Tile.tiles[0].render(g, 0, 0);
		world.render(g);
		//ui_manager.render(g);
		//player.render(g);
	}
}
