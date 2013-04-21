package com.ld26.warmup.game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import com.ld26.warmup.game.entities.Enemy;
import com.ld26.warmup.game.entities.Player;
import com.ld26.warmup.game.projectiles.Bullet;

public class World {
	
	private int width;
	private int height;
	private Image background;
	private String health = "Health: ";
	private String score = "Score: ";
	
	private StateBasedGame game;
	private Player player;
	private Enemy enemy;
	private ArrayList<Enemy> enemies;
	public ArrayList<Bullet> bullets;
	private Bullet bullet;
	
	private int spawnRate = 0;
	
	public World(int width, int height, Image background, StateBasedGame game) throws SlickException {
		this.game = game;
		this.width = width;
		this.height = height;
		this.background = background;
		player = new Player(this, game);
		enemies = new ArrayList<Enemy>();
		bullets = player.getBullets();
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
        		player.decreaseHealth(25);
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
	
	public void update(GameContainer container) throws SlickException {
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
		
			if (spawnRate == 20) {
				enemies.add(new Enemy((float) Math.random() * 590, 0));
			}
			if (spawnRate == 22) {
				spawnRate = 0;
			}
			
			checkCollisions();
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
		
		ArrayList<Bullet> bullets = player.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = bullets.get(w);
        	bullet.draw(bullet.getX(), bullet.getY());
        }
		
		g.setColor(Color.white);
		g.drawString(health + player.getHealth(), 0, 0);
		g.drawString(score + player.getScore(), 500, 0);
	}

}
