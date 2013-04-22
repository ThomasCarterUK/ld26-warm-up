package com.ld26.warmup.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.ld26.warmup.game.entities.Floor;
import com.ld26.warmup.game.entities.MenuPlayer;

public class Menu extends BasicGameState {
	
	private Image background;
	private Image logo;
	private MenuPlayer player;
	private Floor floor;
	
	private String playText = "Press Enter to Begin!";

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Image("res/graphics/menu2.png");
		logo = new Image("res/graphics/logo.png");
		player = new MenuPlayer();
		floor = new Floor();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		player.update(container);
		
		Input keyboard = container.getInput();
		if (keyboard.isKeyPressed(Input.KEY_ENTER)) {
			game.enterState(GameStates.playing);
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw(0, 0);
		
		float yBobbing = (float) Math.sin(container.getTime() / 10000f * 100);
		logo.draw(container.getWidth() / 2 - (logo.getWidth() / 2), 30 + yBobbing);
		
		player.render(container, g);
		floor.render();
		
		g.setColor(Color.green);
		g.drawString(playText, 230, container.getHeight() - 120);
	}

	@Override
	public int getID() {
		return GameStates.menu;
	}

}
