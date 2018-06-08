package dev.main.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import dev.cards.MagicCard;
import dev.cards.TacticalCard;

public class Assets {
	public static String src="";
	private static final int width=32,height=32;
	public static BufferedImage main_title;
	public static BufferedImage main_hud;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_options;
	public static BufferedImage[] btn_exit;
	public static BufferedImage naked_rock;
	public static BufferedImage player,dirt,rock,grass,stone,tree,ocean,beach,high_tree,grocery;
	public static BufferedImage[] player_down,player_up,player_left,player_right,player_stand;
	public static BufferedImage[] orc_down,orc_up,orc_left,orc_right;
	public static BufferedImage bfi;
	public static BufferedImage cards;
	public static BufferedImage battle_background;
	
	public static Map<String, BufferedImage> tactical_cards;
	public static Map<String, BufferedImage> magic_cards;
	
	public static Font font_inventory;
	public static Font font_desc_card;
	
	public static void init_player(){
		
		SpriteSheet chars=new SpriteSheet(ImageLoader.loadImage(src+"/textures/actors.png"));
		
		player_down=new BufferedImage[2];
		player_up=new BufferedImage[2];
		player_left=new BufferedImage[2];
		player_right=new BufferedImage[2];
		player_stand=new BufferedImage[2];
		
		player_down[0]=chars.crop(0, 0, width, 48);
		player_down[1]=chars.crop(2*32, 0, width, 48);
		
		player_left[0]=chars.crop(0, 48, width, 48);
		player_left[1]=chars.crop(2*32, 48, width, 48);
		
		player_right[0]=chars.crop(0, 48*2, width, 48);
		player_right[1]=chars.crop(2*32, 48*2, width, 48);
		
		player_up[0]=chars.crop(0, 48*3, width, 48);
		player_up[1]=chars.crop(2*32, 48*3, width, 48);
		
		player_stand[0]=chars.crop(1*32, 0, width, 48);
		player_stand[1]=chars.crop(1*32, 0, width, 48);
	}
	
	public static void init_cards(){
		tactical_cards= new HashMap<String, BufferedImage>();
		int index=0;
		for(String tc : TacticalCard.list_cards){	
			SpriteSheet card_image = new SpriteSheet(ImageLoader.loadImage(src+"/pic/cards/tactical/tactical_"+tc+".jpg"));
			tactical_cards.put("tactical_"+tc, card_image.crop(0, 0, 127, 185));
		}
		magic_cards= new HashMap<String, BufferedImage>();
		for(String tc : MagicCard.list_cards){
			SpriteSheet card_image = new SpriteSheet(ImageLoader.loadImage(src+"/pic/cards/magic/magic_"+tc+".jpg"));
			magic_cards.put("magic_"+tc,card_image.crop(0, 0, 127, 185));
		}
	}
	
	public static void init() {
		
		init_cards();	
			
		font_inventory = FontLoader.loadFont("res/font/ariendezze.ttf", 28);
		font_desc_card = FontLoader.loadFont("res/font/ariendezze.ttf", 18);	
		
		SpriteSheet title=new SpriteSheet(ImageLoader.loadImage(src+"/pic/main_title_jpeg.jpg"));
		main_title=title.crop(0, 0, 2480, 1280);
				
		SpriteSheet bar_hud=new SpriteSheet(ImageLoader.loadImage(src+"/pic/main_bar.png"));
		main_hud=bar_hud.crop(0, 0, 360, 83);
		
		SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage(src+"/textures/tileset.png"));
		grass=sheet.crop(0, 0, width, height);
		tree=sheet.crop(0, 32, width, height);
		rock=sheet.crop(width*6, height*11, width, height);
		grocery=sheet.crop(width*6, height*12, width, height);
		ocean=sheet.crop(width*6, height*10, width, height);
		beach=sheet.crop(width*9, height*10, width, height);
		
		SpriteSheet chars=new SpriteSheet(ImageLoader.loadImage(src+"/textures/actors.png"));
		//player=chars.crop(5*32, 6*32, width, 48);
		orc_down=new BufferedImage[2];
		orc_up=new BufferedImage[2];
		orc_left=new BufferedImage[2];
		orc_right=new BufferedImage[2];
		SpriteSheet orcs=new SpriteSheet(ImageLoader.loadImage(src+"/textures/orc.png"));
		orc_down[0]=orcs.crop(0, 0, width, 48);
		orc_down[1]=orcs.crop(2*32, 0, width, 48);
		
		orc_left[0]=orcs.crop(0, 48, width, 48);
		orc_left[1]=orcs.crop(2*32, 48, width, 48);
		
		orc_right[0]=orcs.crop(0, 48*2, width, 48);
		orc_right[1]=orcs.crop(2*32, 48*2, width, 48);
		
		orc_up[0]=orcs.crop(0, 48*3, width, 48);
		orc_up[1]=orcs.crop(2*32, 48*3, width, 48);
		
		init_player();
		
		SpriteSheet sheet_menu=new SpriteSheet(ImageLoader.loadImage(src+"/textures/sheet.png"));
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet_menu.crop(0, 0, width * 2, height);
		btn_start[1] = sheet_menu.crop(0, height, width * 2, height);
		
		btn_options = new BufferedImage[2];
		btn_options[0] = sheet_menu.crop(0, height*3, width * 2, height);
		btn_options[1] = sheet_menu.crop(0, height*4, width * 2, height);
		
		btn_exit = new BufferedImage[2];
		btn_exit[0] = sheet_menu.crop(0, height*5, width * 2, height);
		btn_exit[1] = sheet_menu.crop(0, height*6, width * 2, height);
		
		naked_rock=sheet_menu.crop(0, height*2, width, height);
		
		SpriteSheet trees=new SpriteSheet(ImageLoader.loadImage(src+"/textures/trees.png"));
		high_tree=trees.crop(0, 0, 90, 125);
		
		SpriteSheet invs=new SpriteSheet(ImageLoader.loadImage(src+"/textures/invs.png"));	
		bfi = invs.crop(0,0,512,384);
		
		SpriteSheet ecards=new SpriteSheet(ImageLoader.loadImage(src+"/textures/ecards.png"));	
		cards = ecards.crop(0,0,728,350);
		
		SpriteSheet batb=new SpriteSheet(ImageLoader.loadImage(src+"/textures/battle_background.png"));	
		battle_background = batb.crop(0,0,1190,640);
	};
	
}
