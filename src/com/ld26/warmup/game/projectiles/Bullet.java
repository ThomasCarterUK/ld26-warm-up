package com.ld26.warmup.game.projectiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.ld26.warmup.game.entities.Enemy;

public class Bullet {
	
	private Image image;
	public float x;
	private float y;
	private boolean isVisible;
	private float bulletSpeed = 0.6f * 15;
	private Rectangle collisionBox;
	
	public Bullet(float x, float y) throws SlickException {
		image = new Image("res/graphics/bullet.png");
		this.x = x;
		this.y = y;
		isVisible = true;
		collisionBox = new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	public Image getImage() {
		return image;
	}
	
	public void draw(float x, float y) {
		image.draw(x, y);
	}
	
	public void drawFlipped(GameContainer container, float x, float y) {
		Graphics g = container.getGraphics();
		g.drawImage(image.getFlippedCopy(true, false), x, y);
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
	
	public boolean getVisible() {
		return isVisible;
	}

	public void update() {
		y -= bulletSpeed;
		if (y > -20) {
			isVisible = false;
		}
		
		collisionBox.setX(x);
		collisionBox.setY(y);
	}

}
