package dev.main.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UI_background extends UI_object {
	private BufferedImage image;
	public UI_background(float x, float y, int width, int height, BufferedImage images) {
		super(x, y, width, height);
		this.image = images;
		//this.clicker = clicker;
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		//clicker.onClick();
	}
}
