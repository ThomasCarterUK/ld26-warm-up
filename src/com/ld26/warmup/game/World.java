package com.ld26.warmup.game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.StateBasedGame;

import com.ld26.warmup.game.entities.Enemy;
import com.ld26.warmup.game.entities.Floor;
import com.ld26.warmup.game.entities.Player;
import com.ld26.warmup.game.projectiles.Bullet;

public class World {
	
	private int width;
	private int height;
	private Image background;
	private String health = "Health: ";
	private String levelName = "";
	private int nextLevel = 2;
	private int untilNextLevel = 500;
	private int nextLevelScore = 500;
	private int levelNameTimer = 0;
	private String score = "Score: ";
	
	private StateBasedGame game;
	private static Player player;
	private Enemy enemy;
	private Floor floor;
	private static ArrayList<Enemy> enemies;
	public static ArrayList<Bullet> bullets;
	private Bullet bullet;
	private Sound deathSFX;
	
	private int spawnRate = 0;
	private int spawnEnemy = 50;
	
	public World(int width, int height, Image background, StateBasedGame game, int nextLevel) throws SlickException {
		this.game = game;
		this.width = width;
		this.height = height;
		this.background = background;
		this.nextLevel = nextLevel;
		player = new Player(this, game);
		enemies = new ArrayList<Enemy>();
		bullets = player.getBullets();
		deathSFX = new Sound("res/sounds/death.wav");
		floor = new Floor();
	}
	
	public void setLevelName(String name) {
		this.levelName = name;
	}
	
	public void setSpawnRate(int amount) {
		this.spawnEnemy = amount;
	}
	
	public void setNextLevelScore(int amount) {
		this.nextLevelScore = amount;
	}
	
	public void setEnemySpeed(float amount) {
		for (int w = 0; w < enemies.size(); w++) {
			Enemy enemy = enemies.get(w);
			enemy.setSpeed(amount);
		}
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public void checkCollisions() {
		for (int w = 0; w < bullets.size(); w++) {
			bullet = bullets.get(w);
		}
		
		for (int w = 0; w < enemies.size(); w++) {
        	Enemy enemy = enemies.get(w);
        	this.enemy = enemy;
        	if (enemy.getBounds().intersects(player.getBounds())) {
        		killEnemy(enemy);
        		player.decreaseHealth(3);
        	}
        	if (enemy.getBounds().intersects(floor.getBounds())) {
        		killEnemy(enemy);
        		player.decreaseHealth(1);
        	}
        	if (enemy.getY() > 480) {
        		killEnemy(enemy);
        	}
        	if (enemy.getHealth() < 0) {
        		killEnemy(enemy);
        	}
        	if (bullets.size() > 0) {
        		if (bullet.getBounds().intersects(enemy.getBounds())) {
        			enemies.remove(enemy);
        			bullets.remove(bullet);
        			player.inscreaseScore(10);
        		}
        	}
        }
	}
	
	public void killEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}
	
	public static void reset() {
		enemies.clear();
		bullets.clear();
		player.reset();
	}
	
	public void resetWorld() {
		enemies.clear();
		bullets.clear();
		player.reset();
		this.untilNextLevel = nextLevelScore;
	}
	
	public void update(GameContainer container, StateBasedGame game) throws SlickException {
		spawnRate++;
		player.update(container);

		for (int w = 0; w < enemies.size(); w++) {
        	Enemy enemy = enemies.get(w);
        	enemy.update(container);
        }
		
		for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = bullets.get(w);
        	bullet.update();
        }
		
		Random random = new Random();
		
		if (spawnRate == spawnEnemy) {
			enemies.add(new Enemy((float) Math.random() * 590, 0));
		}
		if (spawnRate == spawnEnemy + 2) {
			spawnRate = 0;
		}
		
		untilNextLevel = nextLevelScore - player.getScore();
		checkCollisions();
		
		if (player.getScore() == nextLevelScore) {
			resetWorld();
			game.enterState(nextLevel);
		}
	}
	
	public void render(GameContainer container, Graphics g) {
		background.draw(0, 0);
		player.render(container, g);
		
        for (int w = 0; w < enemies.size(); w++) {
        	Enemy enemy = enemies.get(w);
        	enemy.render(container, g);
        }
        
        for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = bullets.get(w);
        	bullet.draw(bullet.getX(), bullet.getY());
        }
        
        floor.render();
		
		g.setColor(Color.white);
		g.drawString(health + player.getHealth(), 0, 0);
		g.drawString(levelName + ": " + untilNextLevel + " pts until next level!", 150, 0);
		g.drawString(score + player.getActualScore(), 500, 0);
		
		levelNameTimer++;
		if (levelNameTimer < 200) {
			g.drawString(levelName, 280, 230);
		}
	}

}
