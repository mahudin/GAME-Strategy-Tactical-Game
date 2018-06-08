package dev.cards;

import dev.main.gfx.Assets;

public class MagicCard<T> extends Card {
	public static String[] list_cards={"fire_ball"};
	public MagicCard(int index, int power){
		super(list_cards[index-1], power,Assets.magic_cards.get("magic_"+list_cards[index-1]),"magic");
	}
	
}
