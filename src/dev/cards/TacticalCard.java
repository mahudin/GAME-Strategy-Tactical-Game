package dev.cards;

import dev.main.gfx.Assets;

public class TacticalCard<T> extends Card {

	public static String[] list_cards={"wall","berserker","shield"};
	public TacticalCard(int index, int power){
		super(list_cards[index-1], power,Assets.tactical_cards.get("tactical_"+list_cards[index-1]),"tactical");
	}
}
