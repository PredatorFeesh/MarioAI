package com.game.background;

import java.awt.Image;

import com.game.main.Game;

public class Background {
	int width = Game.WIDTH;
	int height = Game.HEIGHT;
	int x,y;
	Image bg;
	
	public Image getBackground() {
		return bg;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setBg(Image bg) {
		this.bg = bg;
	}

	public Background(Image img, int x, int y) {
		bg = img;
		this.x=x;
		this.y=y;
	}

}
