package dev.main.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path){
		try{
			System.out.println(ImageLoader.class.getResource(path));
			return ImageIO.read(ImageLoader.class.getResource(path));//ImageLoader.class.getResource(url.getPath()));
		} 
		catch(IOException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Jest problem z pliczkiem:"+path, "B³¹d!",2);
			System.exit(1);
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Jest problem z plikiem:"+path+" print:"+e.getMessage(), "B³¹d!",2);
			System.exit(1);
		}
		return null;
	}
}
