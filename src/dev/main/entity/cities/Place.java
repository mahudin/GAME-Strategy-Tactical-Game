package dev.main.entity.cities;

import java.awt.image.BufferedImage;

public class Place {
	protected BufferedImage graphic_place;
	private static int id_all=0;
	private int id=0;
	public Place(BufferedImage graphic_place){
		id=id_all;
		id_all++;
		this.graphic_place=graphic_place;
	}
	public BufferedImage getGraphicPlace(){
		return graphic_place;
	}
	public int getID(){
		return id;
	}
	
}
