package com.ld26.warmup.game.entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import com.ld26.warmup.game.GameStates;
import com.ld26.warmup.game.World;
import com.ld26.warmup.game.projectiles.Bullet;

public class Player {

	private float width;
	private float height;
	private float x = 300;
	private float y = 410;
	private Image texture;
	private Image shield;
	private Rectangle collisionBox;
	private Sound laserSFX;
	private Sound hurtSFX;
	private Sound deathSFX;
	private StateBasedGame game;
	private World world;
	
	private float scale = 5f;
	private float movementSpeed = 0.5f * 15;
	private int maxHealth = 100;
	private int health;
	private static int score = 0;
	private static int actualScore = 0;
	
	private boolean shieldActive = false;
	private int shieldTimer = 0;
	
	private ArrayList<Bullet> bullets;
	
	public Player(World world, StateBasedGame game) throws SlickException {
		this.game = game;
		texture = new Image("res/graphics/player.png");
		shield = new Image("res/graphics/shield.png");
		width = texture.getWidth();
		height = texture.getHeight();
		collisionBox = new Rectangle(x, y, width, height);
		health = maxHealth;
		bullets = new ArrayList<Bullet>();
		laserSFX = new Sound("res/sounds/laser.wav");
		hurtSFX = new Sound("res/sounds/hurt.wav");
		deathSFX = new Sound("res/sounds/death.wav");
		this.world = world;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public Rectangle getBounds() {
		return collisionBox;
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public void fireBullet() throws SlickException {
		Bullet bullet = new Bullet(x + ((width / 2) - 3), y);
		bullets.add(bullet);
		laserSFX.play();
	}
	
	public int getHealth() {
		return health;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static int getActualScore() {
		return actualScore;
	}
	
	public static void inscreaseScore(int amount) {
		score += amount;
		actualScore += amount;
	}
	
	public void decreaseHealth(int amount) {
		health -= amount;
		hurtSFX.play();
	}
	
	public void increaseHealth(int amount) {
		health += amount;
	}
	
	public void reset() {
		x = 300;
		score = 0;
	}
	
	public void resetHealth() {
		health = maxHealth;
	}
	
	public boolean getShieldState() {
		return shieldActive;
	}
	
	public void activateShield() {
		shieldActive = true;
	}
	
	public void destroyShield() {
		shieldActive = false;
		shieldTimer = 0;
	}
	
	public void die() throws SlickException {
		game.enterState(GameStates.gameover);
		Sound gameoverSFX = new Sound("res/sounds/gameover.wav");
		gameoverSFX.play();
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
		
		if (health <= 0) {
			die();
		}
		
		for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = bullets.get(w);
        	bullet.update();
        }
		
		if (shieldActive) {
			shieldTimer++;
			if (shieldTimer >= 800) {
				destroyShield();
			}
		}
		
		collisionBox.setX(x);
		collisionBox.setY(y);
	}
	
	public void render(GameContainer container, Graphics g) {
		texture.draw(x, y);
		
		if (shieldActive) {
			shield.draw(x, y - shield.getHeight());
		}
		//g.setColor(Color.white);
		//g.draw(collisionBox);
	}

}
