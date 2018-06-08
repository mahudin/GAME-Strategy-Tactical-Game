package dev.cards;

import java.awt.image.BufferedImage;

public class Card {
	
	public static int invX = 64, invY = 48,
			invWidth=110, invHeight = 185,
			invImageX = 152, invImageY = 182,
			invListCenterX = invX + 171,
			invListCenterY = invY + invHeight / 2+5,
			invListSpacing = 30;
	
	private String name;
	private int power;
	private String type;
	private BufferedImage bfi;
	public Card(String name,int power, BufferedImage bfi, String type){
		this.name=name;
		this.bfi=bfi;
		this.power=power;
		this.type=type;
	}
	
	public String getDesc(){
		return "This is "+name+" with power ";
	}
	public String getType(){
		return type;
	}
	public BufferedImage getImage(){
		return this.bfi;
	}
	public boolean isEmpty(){
		return name.isEmpty()?true:false;
	}
	public String toString(){
		return name;
	}
	 // final Class<T> typeParameterClass;

	  /*public Card(Class<T> typeParameterClass) {
	     this.typeParameterClass = typeParameterClass;
	  }*/
}
