package com.shooter.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship extends GameObject {
	public Ship() {
		super(new Sprite(new Texture("smallfreighterspr.png")), Vector2.Zero);
	}
	
	void updateSprite() {
		sprite.setX(pos.x - sprite.getWidth() / 2);
		sprite.setY(pos.y - sprite.getHeight() / 2);
	}
	
	public void draw(SpriteBatch sb) {
		updateSprite();
		sprite.draw(sb);
	}
}
