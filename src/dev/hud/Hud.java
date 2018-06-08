package dev.hud;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import dev.main.Calendar;
import dev.main.Handler;
import dev.main.Start;
import dev.main.entity.Entity;
import dev.main.entity.Player;

public class Hud {
	private BufferedImage hud_bar;
	
	private int count_warriors=34;
	private int count_archers=17;
	
	private int gold=340;
	
	private Player player;
	private Handler handler;
	
	
	public Hud(Handler handler,BufferedImage hud,Player player){
		hud_bar=hud;
		this.player=player;
		this.handler=handler;
		int time_second=handler.getGame().getTime_second();
	
	}
	public void tick(){
		
	}
	public void render(Graphics g){
		g.drawImage(hud_bar, 0, Start.height-75, 360,83,null);
		g.drawString(Integer.toString(player.get_my_Gold()), 22, Start.height-12);
		g.drawString(Integer.toString(player.getCount_my_knights()), 106, Start.height-12);
		g.drawString(Integer.toString(player.getCount_my_archers()), 162, Start.height-12);
		g.drawString(Integer.toString(this.handler.getMouseManager().getMouseX()), 106, Start.height-120);
		g.drawString(Integer.toString(this.handler.getMouseManager().getMouseY()), 162, Start.height-120);
		g.drawString(Calendar.show_datetime_in_game(this.handler.getGame().getTime_second()), 212, Start.height-12);
	}
}
