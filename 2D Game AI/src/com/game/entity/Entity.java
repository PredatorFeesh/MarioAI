package com.game.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.game.utility.Vector2f;

public abstract class Entity {

	Vector2f position;
	Vector2f size;
	Image image;
	
	public Entity(Vector2f pos, Vector2f size, Image image){
		this.position=pos;
		this.size=size;
		this.image=image;
	}
	
	public Entity(Vector2f pos, Image image) {
		this(pos , new Vector2f(image.getWidth(null), image.getHeight(null)), image);
	}
	public abstract void init();
	public abstract void upadte(double delta);
	public abstract void render(Graphics g);

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Vector2f getSize() {
		return size;
	}

	public void setSize(Vector2f size) {
		this.size = size;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	

}
