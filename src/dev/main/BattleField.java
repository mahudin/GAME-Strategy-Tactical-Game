package dev.main;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dev.army.Army;
import dev.army.Jednostka;
import dev.army.¯o³nierz;
import dev.main.entity.Player;
import dev.main.gfx.Assets;
import dev.main.ui.UI_background;
import dev.main.ui.UI_manager;

public class BattleField {
	private UI_manager ui_manager;
	private Player player;
	
	private ArrayList<Army> army_player;
	private ArrayList<Army> army_enemy;
	
	public void setArmyEnemy(ArrayList<Army> army_enemy){
		for(Army a:army_enemy){
			this.army_enemy.add(a);
		}
		//this.army_enemy.addAll(army_enemy);//=army_enemy;
	}
	
	public void setArmyPlayer(ArrayList<Army> army_player){
		for(Army a:army_player){
			this.army_player.add(a);
		}
	}
	
	private void init_army_on_field(){
		Jednostka jednostka=new ¯o³nierz();
		try {
			System.out.println("Bêdzie dodawana armia");
			System.out.println(this.army_player);
			for(Army unit : this.army_player){
				//jednostka=unit;
				System.out.println(unit.toString());
			}
			System.out.println("Bêdzie dodawana armia wroga");
			System.out.println(this.army_enemy);
			for(Army unit : this.army_enemy){
				//jednostka=unit;
				System.out.println(unit.toString());
			}
		} catch(NullPointerException e){
			System.out.println("B³¹d przy dodawaniu armii: " + e.getMessage());
		}
	}
	
	public BattleField(Handler handler){
		
		this.army_player=new ArrayList<Army>();
		this.army_enemy=new ArrayList<Army>();
		try {
			ui_manager = new UI_manager(handler);
			ui_manager.addObject(new UI_background(0,0,Start.width+10,Start.height+10,Assets.battle_background));
			init_army_on_field();
			
		} catch(Exception e){
			JOptionPane.showMessageDialog(null,"B³¹d! :"+ e.getMessage(), "Uwaga!",2);
		}
	}
	
	public void init(){
		this.init_army_on_field();
	}
	
	public void tick(){
		ui_manager.tick();
	}

	public void render(Graphics g) {
		ui_manager.render(g);
	}
	
}
