package com.game.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage spriteSheet;
	private int totalVerticleTiles = 0;
	BufferedImage[] tile;
	
	public SpriteSheet() {
		// TODO Auto-generated constructor stub
	}
	public void setSpriteSheet(BufferedImage spriteSheet){
		this.spriteSheet=spriteSheet;
	}
	public void setTotalVerticleTiles(int amount){
		tile = new BufferedImage[amount];
		int height = spriteSheet.getHeight();
		int twidth = spriteSheet.getWidth();
		for(int i=0; i<amount;i++){
			tile[i] = spriteSheet.getSubimage( twidth/amount*i , 0, twidth/amount, height);
		}
	}
	public BufferedImage getTile(int xTile, int yTile, int width, int height) {
		
		return null;
	}
	public BufferedImage getTile(int tileNum){
		return tile[tileNum];
	}

}
