package com.ld26.warmup.game.pickups;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class HealthPickup extends BasePickup {
	
	public HealthPickup(float x, float y) throws SlickException {
		super(new Image("res/graphics/healthpickup.png"), PickupTypes.health, x, y);
	}
	
	public Rectangle getBounds() {
		return collisionBox;
	}
	
	public void stopFalling() {
		falling = false;
	}

}
