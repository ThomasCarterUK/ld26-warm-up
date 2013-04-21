package com.ld26.warmup.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class SpaceAttack extends BasicGame {
	
	private static int width = 640;
	private static int height = 480;
	private static boolean fullscreen = false;

	public SpaceAttack() {
		super("Space Attack");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SpaceAttack());
        app.setDisplayMode(width, height, fullscreen);
        app.setShowFPS(true);
        app.start();
	}

}
