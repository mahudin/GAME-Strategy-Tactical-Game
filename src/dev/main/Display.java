package dev.main;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import dev.main.gfx.Assets;
import dev.main.gfx.ImageLoader;

public class Display {
	
	private Canvas canvas;
	private JFrame frame;
	private String title;
	private int width,height;
	
	public Display(String title,int width,int height){
		
		this.title=title;
		this.width=width;
		this.height=height;
		this.createFrame();
	}
	
	public void createFrame(){
		frame=new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		// okienko bπdü fullscreen
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		frame.setVisible(true);
		
		WindowListener listener = new WindowControler();
		frame.addWindowListener(listener);
		
		Point hotSpot = new Point(1, 1);
		Image image_cursor = ImageLoader.loadImage(Assets.src+"/pic/RPG_Mouse_Cursor_3.png"); 
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image_cursor, hotSpot, "cursor-own");
				
		frame.setCursor(cursor);
		
		canvas=new Canvas();
		Dimension dm=new Dimension();
		dm.setSize(width, height);
		canvas.setPreferredSize(dm);
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	public Canvas getcanvas(){
		return canvas;
	}
	public JFrame getJFrame(){
		return frame;
	}
}