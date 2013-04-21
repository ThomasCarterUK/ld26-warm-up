package com.ld26.warmup.game.entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import com.ld26.warmup.game.projectiles.Bullet;

public class MenuPlayer {
	
	private float width;
	private float height;
	private float x = 300;
	private float y = 410;
	private Image texture;
	private Sound laserSFX;
	
	private ArrayList<Bullet> bullets;
	
	private float movementSpeed = 0.5f * 15;
	
	public MenuPlayer() throws SlickException {
		texture = new Image("res/graphics/player.png");
		width = texture.getWidth();
		height = texture.getHeight();
		bullets = new ArrayList<Bullet>();
		laserSFX = new Sound("res/sounds/laser.wav");
	}
	
	public void fireBullet() throws SlickException {
		Bullet bullet = new Bullet(x + ((width / 2) - 3), y);
		bullets.add(bullet);
		laserSFX.play();
	}
	
	public void update(GameContainer container) throws SlickException {
		Input keyboard = container.getInput();
		if ((keyboard.isKeyDown(Input.KEY_A) || keyboard.isKeyDown(Input.KEY_LEFT)) && x > 0) {
			x -= movementSpeed;
		}
		if ((keyboard.isKeyDown(Input.KEY_D) || keyboard.isKeyDown(Input.KEY_RIGHT)) && x < 590) {
			x += movementSpeed;
		}
		if (keyboard.isKeyPressed(Input.KEY_SPACE)) {
			fireBullet();
		}
		
		for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = bullets.get(w);
        	bullet.update();
        }
	}
	
	public void render(GameContainer container, Graphics g) {
		texture.draw(x, y);
		
		for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = bullets.get(w);
        	bullet.draw(bullet.getX(), bullet.getY());
        }
	}
}
