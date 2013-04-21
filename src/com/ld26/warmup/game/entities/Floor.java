package com.ld26.warmup.game.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Floor {
	
	private float x = 0;
	private float y = 460;
	private Image texture;
	private Rectangle collisionBox;
	
	public Floor() throws SlickException {
		texture = new Image("res/graphics/floor.png");
		collisionBox = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public Rectangle getBounds() {
		return collisionBox;
	}
	
	public void render() {
		texture.draw(x, y);
	}

}
