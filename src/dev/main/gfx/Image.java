package dev.main.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Image {
	
	
	public static void drawImage(Graphics g, BufferedImage img, int xPos, int yPos, boolean center, Color c){
		g.setColor(c);
		int x=xPos;
		int y=yPos;
		
		//g.drawImage(img.getScaledInstance(x, y, 1), x, y,ImageObserver.class);
	}
}
