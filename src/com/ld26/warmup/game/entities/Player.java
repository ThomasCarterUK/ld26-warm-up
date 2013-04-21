package com.ld26.warmup.game.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {

	private float width;
	private float height;
	private float x = 280;
	private float y = 430;
	private Image texture;
	private Rectangle collisionBox;
	
	private float scale = 5f;
	private float movementSpeed = 1.3f;
	
	public Player() throws SlickException {
		texture = new Image("res/graphics/player.png");
		width = texture.getWidth();
		height = texture.getHeight();
		collisionBox = new Rectangle(x, y, width, height);
	}
	
	public void update(GameContainer container) {
		Input keyboard = container.getInput();
		if ((keyboard.isKeyDown(Input.KEY_A) || keyboard.isKeyDown(Input.KEY_LEFT)) && x > 0) {
			x -= movementSpeed;
		}
		if ((keyboard.isKeyDown(Input.KEY_D) || keyboard.isKeyDown(Input.KEY_RIGHT)) && x < 590) {
			x += movementSpeed;
		}
	}
	
	public void render(GameContainer container, Graphics g) {
		texture.draw(x, y);
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
	}

}
