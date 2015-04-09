package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ship extends GameObject {
	float speed = 175f;
	public Ship() {
		super(new Sprite(new Texture("smallfreighterspr.png")), Vector2.Zero, 7);
		pos.y += sprite.getHeight() / 2;
		pos.x += sprite.getWidth() / 2;
	}
	
	public void MoveUp(float dt) {
		if (pos.y < Gdx.graphics.getHeight() - sprite.getHeight() / 2) pos.y += speed * dt;
	}
	
	public void MoveDown(float dt) {
		if (pos.y > 0 + sprite.getHeight() / 2) pos.y -= speed * dt;
	}
	
	public void MoveRight(float dt) {
		if (pos.x < Gdx.graphics.getWidth() - sprite.getWidth() / 2) pos.x += speed * dt;
	}
	
	public void MoveLeft(float dt) {
		if (pos.x > 0 + sprite.getWidth() / 2) pos.x -= speed * dt;
	}
}
