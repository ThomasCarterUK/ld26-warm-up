package com.ld26.warmup.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.ld26.warmup.game.entities.Player;

public class GameOver extends BasicGameState {
	
	private Image screen;
	
	public GameOver() {
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		screen = new Image("res/graphics/gameover.png");
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		screen.draw(0, 0);
		g.setColor(Color.green);
		g.drawString("Score: " + Player.getScore(), 260, 250);
	}

	@Override
	public int getID() {
		return GameStates.gameover;
	}

	
}
