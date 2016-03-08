package com.game.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class State {
	
	protected StateManager stateManager;
	
	public State(StateManager manager) {
		this.stateManager = manager;
	}

	public StateManager getStateManager() {
		return stateManager;
	}

	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public abstract void init();
	public abstract void upadte(double delta);
	public abstract void render(Graphics g);
	public abstract void keyTyped(int g);
	public abstract void keyPressed(int g);
	public abstract void keyReleased(int k);
	public abstract void mouseClicked(MouseEvent m);
	public abstract void mouseEntered(MouseEvent m);
	public abstract void mouseExited(MouseEvent m);
	public abstract void mousePressed(MouseEvent m);
	public abstract void mouseReleased(MouseEvent m);
		
}
