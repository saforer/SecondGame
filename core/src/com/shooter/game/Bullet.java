package com.shooter.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends GameObject {
	public Bullet(Vector2 inPos) {
		super(new Sprite(new Texture("BulletBill.png")), inPos.add(0,20));
	}
	
	public void Update(float dt) {
		float speed = 200;
		pos.add(0,speed * dt);
	}
}
