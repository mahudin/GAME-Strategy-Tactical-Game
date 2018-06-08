package dev.main.tiles;

import dev.main.gfx.Assets;

public class RockTile extends Tile {
	public RockTile(int id){
		super(Assets.rock,id);
	}
	public boolean isSolid(){
		return true;
	}
}
