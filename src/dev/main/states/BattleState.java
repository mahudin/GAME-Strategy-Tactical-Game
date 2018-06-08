package dev.main.states;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dev.army.Army;
import dev.army.Jednostka;
import dev.army.Rycerz;
import dev.army.£ucznik;
import dev.army.¯o³nierz;
import dev.main.Handler;
import dev.main.Start;
import dev.main.entity.Player;
import dev.main.gfx.Assets;
import dev.main.ui.UI_background;
import dev.main.ui.UI_manager;

public class BattleState extends State {
	
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
				System.out.println(unit);
			}
			System.out.println("Koniec");
			/*Rycerz rn=new Rycerz(¿o³nierz);
			for(int i=0;i<3;i++)
				this.add_knight(rn);
			£ucznik ³n=new £ucznik(¿o³nierz);
			for(int b=0;b<4;b++)
				this.add_archer(³n);*/
		} catch(NullPointerException e){
			System.out.println("B³¹d przy dodawaniu armii: " + e.getMessage());
		}
	}
	
	public BattleState(Handler handler) {
		super(handler);
		this.army_player=new ArrayList<Army>();
		this.army_enemy=new ArrayList<Army>();
		try {
			ui_manager = new UI_manager(handler);
			//handler.getMouseManager().setUIManager(ui_manager);

			ui_manager.addObject(new UI_background(0,0,Start.width+10,Start.height+10,Assets.battle_background));
			init_army_on_field();
			
		} catch(Exception e){
			JOptionPane.showMessageDialog(null,"B³¹d! :"+ e.getMessage(), "Uwaga!",2);
		}
	}
	
	@Override
	public void tick(){
		ui_manager.tick();
	}
	@Override
	public void render(Graphics g){
		ui_manager.render(g);
	}
}
