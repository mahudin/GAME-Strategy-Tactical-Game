package dev.main.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
	public static Font loadFont(String path, float size){
		try {
			InputStream myStream = new BufferedInputStream(new FileInputStream(path));
			return Font.createFont(Font.TRUETYPE_FONT, myStream).deriveFont(Font.PLAIN,size);
		} catch(FontFormatException | IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
