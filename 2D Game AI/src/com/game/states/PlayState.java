package com.game.states;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.game.background.Background;
import com.game.main.Game;
import com.game.main.loadImageFrom;

public class PlayState extends State {

	boolean isPlayer;
	Image backgroundImage;
	Background[] background = new Background[30];
	
	public PlayState(StateManager m, boolean isPlayer) {
		super(m);
		this.isPlayer = isPlayer;
	}

	
	public void init() {
		backgroundImage = loadImageFrom.loadImageFrom(getClass(), "/sky.gif" ).getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_DEFAULT);
		for(int i = 0; i < background.length; i++){
			background[i] = new Background(backgroundImage, i * Game.WIDTH ,0)  ;
		}
	}

	
	public void upadte(double delta) {
		
		
	}

	
	public void render(Graphics g) {
		for(int i = 0; i < background.length ; i++){
			g.drawImage(background[i].getBackground(), background[i].getX(), background[i].getY(), null);
		}
		
	}

	
	public void keyTyped(int g) {
		if(isPlayer){
			
			
		}
	}

	
	public void keyPressed(int g) {
		if(isPlayer){
			
			if(g == KeyEvent.VK_RIGHT){
				for(int i = 0; i < background.length; i++){
					background[i].setX(background[i].getX() - 5);
				}
			}else if(g == KeyEvent.VK_LEFT){
				
			}
			
		}
	}

	
	public void keyReleased(int k) {
		if(isPlayer){
			
			
		}
	}

	
	public void mouseClicked(MouseEvent m) {
		if(isPlayer){
			
		
		}
	}

	
	public void mouseEntered(MouseEvent m) {
		if(isPlayer){
			
			
		}
	}

	
	public void mouseExited(MouseEvent m) {
		if(isPlayer){
			
			
		}
	}

	
	public void mousePressed(MouseEvent m) {
		if(isPlayer){
			
			
		}
	}

	
	public void mouseReleased(MouseEvent m) {
		if(isPlayer){
			
			
		}
	}

}
