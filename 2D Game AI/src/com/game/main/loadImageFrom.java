package com.game.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class loadImageFrom {

	public static BufferedImage loadImageFrom(Class<?> classfile, String path) {
		URL url = classfile.getResource(path);
		BufferedImage img = null;
		
		try{
			img = ImageIO.read(url); 
		}catch(Exception e){e.printStackTrace();}
	return img;
	}
	public static BufferedImage getImage(String url){
		try{
			return ImageIO.read(new File(url));
		}catch(Exception e){e.printStackTrace();}
	return null;
	}
}
