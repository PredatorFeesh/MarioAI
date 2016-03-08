package com.game.utility;

public class Vector2f {

	public float x, y;
	
	public Vector2f(float x, float y) {
		this.x=x;
		this.y=y;
	}
	public Vector2f(float scalar){
		this(scalar, scalar);
	}
	public Vector2f(){
		this(0,0);
	}
	public void setX(float x){
		this.x=x;
	}
	public void setY(float y){
		this.y=y;
	}
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}

}
