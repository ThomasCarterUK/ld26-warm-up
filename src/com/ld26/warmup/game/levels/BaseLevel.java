package com.ld26.warmup.game.levels;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.ld26.warmup.game.GameStates;
import com.ld26.warmup.game.World;

public class BaseLevel extends BasicGameState {
	
	private World world;
	private String levelName;
	private int id;
	private int nextLevelID;
	private int spawnRate;
	private float enemySpeed;
	private int nextLevelScore;
	
	public BaseLevel(String name, int id, int nextLevelID, int spawnRate, float enemySpeed, int nextLevelScore) {
		this.levelName = name;
		this.id = id;
		this.nextLevelID = nextLevelID;
		this.spawnRate = spawnRate;
		this.enemySpeed = enemySpeed;
		this.nextLevelScore= nextLevelScore;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		world = new World(640, 480, new Image("res/graphics/background.png"), game, nextLevelID);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		world.update(container, game);
		world.setLevelName(levelName);
		world.setSpawnRate(spawnRate);
		world.setEnemySpeed(enemySpeed);
		world.setNextLevelScore(nextLevelScore);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		world.render(container, g);
	}

	@Override
	public int getID() {
		return id;
	}

}
