package com.ld26.warmup.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WinScreen extends BasicGameState {
	
	private Image screen;
	private int time = 0;

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		screen = new Image("res/graphics/win.png");
		
	}

	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		time++;
		
		if (time == 500) {
			time = 0;
			game.enterState(GameStates.menu);
			World.reset();
			World.getPlayer().resetHealth();
		}
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		screen.draw(0, 0);
		
		g.setColor(Color.green);
		g.drawString("Final Score: " + World.getPlayer().getActualScore(), 230, 250);
	}


	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return GameStates.win;
	}

}
