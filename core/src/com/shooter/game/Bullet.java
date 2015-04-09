package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends GameObject {
	boolean ally;
	private static Texture texture = new Texture("BulletBill.png");
	public Bullet(Vector2 inPos, boolean allyIn) {
		super(new Sprite(texture), inPos.add(0,20), 10);
		ally = allyIn;
	}
	
	public void Update(float dt) {
		float speed = 200;
		if (!ally) speed *= -1;
		pos.add(0, speed * dt);
		if (OffScreen()) dead = true;
	}
	
	public boolean OffScreen() {
		if (pos.x > Gdx.graphics.getWidth()) return true;
		if (pos.x < 0) return true;
		if (pos.y > Gdx.graphics.getHeight()) return true;
		if (pos.y < 0) return true;
		return false;
	}
}
