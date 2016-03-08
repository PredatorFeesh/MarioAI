package com.game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import com.game.main.Game;
import com.game.main.loadImageFrom;
import com.game.utility.Button;

public class GameState extends State{

	public GameState(StateManager stateManager) {
		super(stateManager);
	}

	Image backgroundImage;
	String[] buttonName = {"Play", " Run_bot ", "See_graphical_Data"};
	Button[] button = new Button[buttonName.length];
	
	public void init() {
		if(button!=null)
			for(int i = 0; i < buttonName.length; i++){
				button[i] = new Button( Game.WIDTH / 2 - 250  , (Game.HEIGHT / 3) - 75 + 200 * i , 500, 150, buttonName[i] , Color.WHITE);
			}	
		backgroundImage = loadImageFrom.loadImageFrom(getClass(), "/sky.gif" ).getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_DEFAULT);
		
	}
	public void upadte(double delta) {
		
		//Mouse position
		if(button[0].isWithin((int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY())){
			button[0].setColor(Color.GRAY);
		}else if(button[1].isWithin((int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY())){
			button[1].setColor(Color.GRAY);
		}else if(button[2].isWithin((int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY())){
			button[2].setColor(Color.GRAY);
		} else{
			for(int i=0; i<button.length; i++){
				button[i].setColor(Color.WHITE);
			}
		}
		
	}
	public void render(Graphics g) {
		g.drawImage(backgroundImage, 0,0,null);
		for(int i = 0; i < button.length; i++){
			button[i].render(g);
		}
		
	}
	public void keyTyped(int g) {
		
		
	}	
	public void keyPressed(int g) {
	
		
	}
	public void keyReleased(int g) {
		
		
	}
	@Override
	public void mouseClicked(MouseEvent m) {
		if(button[0].isWithin(m)){
			stateManager.requestState(new PlayState(stateManager, true));
		}else if(button[1].isWithin(m)){
			stateManager.requestState(new PlayState(stateManager, false));
		}
	}
	@Override
	public void mouseEntered(MouseEvent m) {
		
	}
	@Override
	public void mouseExited(MouseEvent m) {
		
	}
	@Override
	public void mousePressed(MouseEvent m) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent m) {
		
		
	}



}
