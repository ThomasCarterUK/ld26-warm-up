package com.ld26.warmup.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Playing extends BasicGameState {
	
	private static int width = 640;
	private static int height = 480;
	
	private SpaceAttack game;
	private World world;
	
	public Playing(SpaceAttack game) {
		this.game = game;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		world = new World(width, height, new Image("res/graphics/bg.png"), game, GameStates.level2);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		world.update(container, game);
		world.setLevelName("Level 1");
		world.setEnemySpeed(0.17f);
		world.setNextLevelScore(500);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		world.render(container, g);
		
	}

	@Override
	public int getID() {
		return GameStates.playing;
	}

}
