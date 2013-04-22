package com.ld26.warmup.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.ld26.warmup.game.levels.*;

public class SpaceAttack extends StateBasedGame {
	
	private static int width = 640;
	private static int height = 480;
	private static boolean fullscreen = false;

	public SpaceAttack() throws SlickException {
		super("Space Attack");
		this.addState(new Menu());
		this.addState(new Playing(this));
		this.addState(new Level2());
		this.addState(new Level3());
		this.addState(new GameOver());
		this.addState(new WinScreen());
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SpaceAttack());
        app.setDisplayMode(width, height, fullscreen);
        app.setShowFPS(false);
        app.setTargetFrameRate(60);
        app.setMaximumLogicUpdateInterval(15);
        app.setMinimumLogicUpdateInterval(15);
        app.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(GameStates.menu).init(container, this);
		this.getState(GameStates.playing).init(container, this);
		this.getState(GameStates.level2).init(container, this);
		this.getState(GameStates.level3).init(container, this);
		this.getState(GameStates.gameover).init(container, this);
		this.getState(GameStates.win).init(container, this);
		this.enterState(GameStates.menu);
	}

}
