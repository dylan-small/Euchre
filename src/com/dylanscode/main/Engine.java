package com.dylanscode.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.dylanscode.game.Deck;

public class Engine extends JFrame implements Runnable
{

	private static final long serialVersionUID = 1L;
	private boolean running = false, debug = true;
	private Graphics g;
	private BufferStrategy bs;
	public static final int WIDTH = 800, HEIGHT = 800;
	private Deck deck;
	
	public synchronized void start()
	{
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop()
	{
		running = false;
	}

	public void init()
	{
		setName("Euchre V a1.0");
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		pack();
		setLocationRelativeTo(null);

		createBufferStrategy(4);

		bs = getBufferStrategy();
		g = getGraphics();

		GameState.setState(GameState.State.MENU);
		
		deck = new Deck();
	}

	public void tick()
	{
		//update different information based on game state
		switch (GameState.getState())
		{
		case MENU:
			break;
		case CONNECT:
			break;
		case SERVER_START:
			break;
		case INSTRUCTIONS:
			break;
		case LICENSE:
			break;
		case GAME:
			break;
		case END:
			break;
		default:
			break;
		}
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = null;
		if (bs != null)
		{
			do
			{
				try
				{
					// obtain 2D graphics and set rendering hints
					g2 = (Graphics2D) bs.getDrawGraphics();
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					// draw background
					setBackground(g2, Color.white);
					//draw different objects based on the current game state
					switch (GameState.getState())
					{
					case MENU:
						break;
					case CONNECT:
						break;
					case SERVER_START:
						break;
					case INSTRUCTIONS:
						break;
					case LICENSE:
						break;
					case GAME:
						break;
					case END:
						break;
					default:
						break;
					}
					
				} catch (Exception e)
				{
					e.printStackTrace();
				} finally
				{
					if (g2 != null)
					{
						g2.dispose();
					}
				}
			} while (bs.contentsLost());
			bs.show();
		}

	}

	@Override
	public void run()
	{
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000 / 60D;
		int frames = 0;
		int ticks = 0;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		init();
		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			while (delta >= 1)
			{
				ticks++;
				tick();
				delta -= 1;
			}
			frames++;
			paint(g);
			if (System.currentTimeMillis() - lastTimer > 1000)
			{
				lastTimer += 1000;
				if (debug)
					System.out.println("[Debug] Frames: " + frames + " | Ticks: " + ticks);
				frames = 0;
				ticks = 0;
			}
		}
	}

	public static void main(String[] args)
	{
		new Engine().start();
	}

	private void setBackground(Graphics2D g2, Color white)
	{
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
	}
}
