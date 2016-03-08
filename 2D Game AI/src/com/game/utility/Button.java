package com.game.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Button {

	int width, height, x, y;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return c;
	}
	public void setColor(Color c) {
		this.c = c;
	}
	String name;
	Color c;
	
	
	public Button(int x, int y,int width, int height, String name, Color c) {
		this.x=x;
		this.y=y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.c=c;
	}
	public void render(Graphics g){
		g.setColor(c);
		g.fillRect(getX(),getY(),getWidth(),getHeight());
		g.setColor(Color.BLACK);
		g.drawString(name, x + width/2 - name.length()*4 , y + height / 2); // assume each letter is 4px
	}
	public void update(int delta){
		x+=20;
	}
	public boolean isWithin(MouseEvent m){
		return isWithin(m.getX(),m.getY());
	}
	public boolean isWithin(int xC, int yC){
		return ( xC > x ) && ( xC < x+width ) &&  ( yC > y  ) && (yC < y + height)  ;
	}

}
