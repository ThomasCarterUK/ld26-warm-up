package com.ld26.warmup.game.pickups;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.ld26.warmup.game.World;

public class BasePickup {
	
	private Image texture;
	private int type;
	private float x = 0;
	private float y = 0;
	protected Rectangle collisionBox;
	protected boolean falling = true;
	
	public BasePickup(Image texture, int type, float x, float y) throws SlickException {
		this.texture = texture;
		this.type = type;
		this.x = x;
		this.y = y;
		collisionBox = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
	}
	
	public void update() {
		if (falling) y += 0.15f * 15;
		
		collisionBox.setX(x);
		collisionBox.setY(y);
	}
	
	public void render() {
		texture.draw(x, y);
		Graphics g = new Graphics();
		g.setColor(Color.white);
		//g.draw(collisionBox);
	}

}
