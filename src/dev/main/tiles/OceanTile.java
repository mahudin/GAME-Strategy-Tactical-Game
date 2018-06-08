package dev.main.tiles;

import dev.main.gfx.Assets;

public class OceanTile extends Tile {
	public OceanTile(int id){
		super(Assets.ocean,id);
	}
	public boolean isSolid(){
		return true;
	}
}
