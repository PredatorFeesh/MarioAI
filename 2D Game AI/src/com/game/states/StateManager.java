package com.game.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StateManager {

	private State currentState, pendingState;
	
	public void init(){
		if(currentState!=null){
			currentState.init();
		}
	}
	public void update(double delta){
		if(currentState!=null){
			currentState.upadte(delta);
		}
	}
	public void render(Graphics g){
		if(currentState!=null){
			currentState.render(g);
		}
	}
	public void keyPressed(int k) {
		if(currentState!=null){
			currentState.keyPressed(k);
		}
		
	}
	public void keyReleased(int k) {
		if(currentState!=null){
			currentState.keyReleased(k);
		}
		
	}
	public void keyTyped(int k) {
		if(currentState!=null){
			currentState.keyTyped(k);
		}
		
	}
	public void mouseClicked(MouseEvent m) {
		if(currentState!=null){
			currentState.mouseClicked(m);
		}
		
	}
	public void mouseEntered(MouseEvent m) {
		if(currentState!=null){
			currentState.mouseEntered(m);
		}
		
	}
	public void mouseExited(MouseEvent m) {
		if(currentState!=null){
			currentState.mouseExited(m);
		}
		
	}
	public void mousePressed(MouseEvent m) {
		if(currentState!=null){
			currentState.mousePressed(m);
		}
		
	}
	public void mouseReleased(MouseEvent m) {
		if(currentState!=null){
			currentState.mouseReleased(m);
		}
		
	}
	
	public void requestState(State state){
		pendingState =  state;
	}
	public void forcedState(State state){
		currentState = state;
		currentState.init();
	}
	public void processStateChanges(){
		if(pendingState != null)
			forcedState(pendingState);
		pendingState=null;
	}
	public State getCurrentState() {
		return currentState;
	}
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	public State getPendingState() {
		return pendingState;
	}
	public void setPendingState(State pendingState) {
		this.pendingState = pendingState;
	}
	

}
