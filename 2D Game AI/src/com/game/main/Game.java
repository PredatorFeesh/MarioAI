package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.game.states.GameState;
import com.game.states.StateManager;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	private StateManager stateManager;
	private JFrame frame;
	private Thread thread;
	private Graphics g;
	private BufferStrategy buffer;
	Image img;
	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private volatile boolean running;
	
	public Game() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	public void init(){
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.add(this);
		frame.pack();
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				stop();
			}
		});
		frame.setVisible(true);
		
		createBufferStrategy(3);
		buffer = getBufferStrategy();
		
		
		stateManager = new StateManager();
		stateManager.requestState(new GameState(stateManager));
		
		addKeyListener(this);
		addMouseListener(this);
		
		img = loadImageFrom.loadImageFrom(getClass(), "/sky.gif" ).getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_DEFAULT);

		
	}
	public synchronized void start(){
		if(running) return;
		running=true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop(){
		if(!running) return;
		running=false;
		thread.interrupt();
		frame.dispose();
		
	}
	
	
	public void update(double delta){
		stateManager.update(delta);
		
	}
	public void render(){
		g = buffer.getDrawGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0,0,getWidth(), getHeight());
		
		stateManager.render(g);
		
		g.dispose();
		buffer.show();
	}
	public void run(){
		init();
		
		/*long timer = System.currentTimeMillis();
		int fps = 0, ups = 0;
		
		
		while(running){
			update(1 	);
			ups++;
			
			render();
			fps++;
			
			if(System.currentTimeMillis() - timer > 1000){//One second has passed
				
				System.out.println(fps);
				
				fps=0;
				ups=0;
				timer += 100;
			}
			
			try{
				Thread.sleep(1000/60);
			}catch(Exception e){
				e.printStackTrace();
			}	
		}*/
		double delta = 0; //time between each frame
		double frameTime = 1.0 / 60.0; //convert desired fps 
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		int fps = 0, ups = 0;
		
		while(running){
			long now = System.nanoTime();
			long passedTime = now - lastTime;
			lastTime = now;
			
			delta += passedTime / 1000000000.0;
			
			if(delta > frameTime){
				stateManager.processStateChanges();
				update(delta); //spikes or lows controlled
				render();
				ups++;
				fps++;
				delta -= frameTime;
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println(fps + " :: " + ups);
				fps=0;
				ups=0; //counts frames per second and updates per second
			}
		}
		try{
			Thread.sleep(8);
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		
	}
	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}
	public void keyPressed(KeyEvent k) {
		if( k.getKeyCode() == KeyEvent.VK_ESCAPE )
			stop();
		stateManager.keyPressed(k.getKeyCode());
		
	}
	public void keyReleased(KeyEvent k) {
		stateManager.keyReleased(k.getKeyCode());
		
	}
	public void keyTyped(KeyEvent k) {
		stateManager.keyTyped(k.getKeyCode());
		
	}
	public void mouseClicked(MouseEvent m) {
		stateManager.mouseClicked(m);
		
	}
	public void mouseEntered(MouseEvent m) {
		stateManager.mouseEntered(m);
		
	}
	public void mouseExited(MouseEvent m) {
		stateManager.mouseExited(m);
		
	}
	public void mousePressed(MouseEvent m) {
		stateManager.mousePressed(m);
		
	}
	public void mouseReleased(MouseEvent m) {
		stateManager.mouseReleased(m);
		
	}

}
