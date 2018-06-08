package dev.main.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

public class UI_communicat extends UI_object {
		private String communicat;
		private ClickListener clicker;
		public UI_communicat(float x, float y, int width, int height, String communicat, ClickListener clicker) {
			super(x, y, width, height);
			this.clicker = clicker;
			this.communicat=communicat;
		}

		@Override
		public void tick() {}

		@Override
		public void render(Graphics g) {
			 int width = 640;
		     int height = 320;
		     //create buffered image object img
		     BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		     //file object
		     File f = null;
		     //create random image pixel by pixel
		     for(int y = 0; y < height; y++){
		       for(int x = 0; x < width; x++){
		         int a = (int)(Math.random()*256); //alpha
		         int r = (int)(Math.random()*256); //red
		         int g1 = (int)(Math.random()*256); //green
		         int b = (int)(Math.random()*256); //blue
		 
		         int p = (a<<24) | (r<<16) | (g1<<8) | b; //pixel
		 
		         img.setRGB(x, y, p);
		       }
		     }
			g.drawImage(img, (int) x, (int) y, width, height, null);
		}

		@Override
		public void onClick() {
			clicker.onClick();
		}
	}

