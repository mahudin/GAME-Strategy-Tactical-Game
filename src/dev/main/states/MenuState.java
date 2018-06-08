package dev.main.states;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import dev.main.Game;
import dev.main.Handler;
import dev.main.Start;
import dev.main.gfx.Assets;
import dev.main.ui.ClickListener;
import dev.main.ui.UI_background;
import dev.main.ui.UI_imagebutton;
import dev.main.ui.UI_manager;

public class MenuState extends State {
	private UI_manager ui_manager;
	public MenuState(Handler handler){
		super(handler);
		
		try {
			ui_manager = new UI_manager(handler);
			handler.getMouseManager().setUIManager(ui_manager);

			ui_manager.addObject(new UI_background(0,0,Start.width+10,Start.height+10,Assets.main_title));
			
			ui_manager.addObject(new UI_imagebutton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
				@Override
				public void onClick() {
					//handler.getMouseManager().setUIManager(null);
					State.setState(handler.getGame().getGameState());
				}
			}));
			
			ui_manager.addObject(new UI_imagebutton(200, 280, 128, 64, Assets.btn_options, new ClickListener() {
				@Override
				public void onClick() {
					
				}
			}));
		
			ui_manager.addObject(new UI_imagebutton(200, 360, 128, 64, Assets.btn_exit, new ClickListener() {
				@Override
				public void onClick() {	
					int option_exit=JOptionPane.showConfirmDialog(null, "Jesteœ pewien ¿e chcesz wyjœæ z gry ?!");
					if(option_exit==0){
						System.exit(0);
					}
				}
			}));
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(null,"B³¹d! :"+ e.getMessage(), "Uwaga!",2);
		}
		
		
		
	}
	public void tick(){
		ui_manager.tick();
	}
	public void render(Graphics g){
		ui_manager.render(g);
	}
}
