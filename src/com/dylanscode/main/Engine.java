package com.dylanscode.main;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Engine extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private boolean running = false;
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	public synchronized void stop() {
		running = false;
	}
	@Override
	public void run() {
		
	}
	public void init() {
		
	}
	public void tick() {
		
	}
	@Override
	public void paint(Graphics g) {
		
	}	
	public static void main(String[] args) {
		new Engine().start();
	}
}
