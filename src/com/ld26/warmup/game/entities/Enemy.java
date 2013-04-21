package com.ld26.warmup.game.entities;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Enemy {
	
	private float width;
	private float height;
	private float x;
	private float y;
	private Image texture;
	private Rectangle collisionBox;
	
	private float movementSpeed = 0.3f * 15;
	private int maxHealth = 20;
	private int health;
	
	public Enemy(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		texture = new Image("res/graphics/enemy.png");
		width = texture.getWidth();
		height = texture.getHeight();
		collisionBox = new Rectangle(x, y, width, height);
		health = maxHealth;
	}
	
	public Rectangle getBounds() {
		return collisionBox;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void decreaseHealth(int amount) {
		health -= amount;
	}
	
	public void die() {
		
	}
	
	public void update(GameContainer container) {
		y += movementSpeed;
		
		collisionBox.setX(x);
		collisionBox.setY(y);
	}
	
	public void render(GameContainer container, Graphics g) {
		texture.draw(x, y);
		//g.setColor(Color.white);
		//g.draw(collisionBox);
	}

}
