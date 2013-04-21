package com.ld26.warmup.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class World {
	
	private int width;
	private int height;
	private Image background;
	
	public World(int width, int height, Image background) throws SlickException {
		this.width = width;
		this.height = height;
		this.background = background;
	}
	
	public void update(GameContainer container) {
		
	}
	
	public void render(GameContainer container, Graphics g) {
		background.draw(0, 0);
	}

}
