package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends GameObject {
	public Bullet(Vector2 inPos) {
		super(new Sprite(new Texture("BulletBill.png")), inPos.add(0,20), 10);
	}
	
	public void Update(float dt) {
		float speed = 200;
		pos.add(0,speed * dt);
	}
	
	public boolean OffScreen() {
		if (pos.x > Gdx.graphics.getWidth()) return true;
		if (pos.x < 0) return true;
		if (pos.y > Gdx.graphics.getHeight()) return true;
		if (pos.y < 0) return true;
		return false;
	}
}
