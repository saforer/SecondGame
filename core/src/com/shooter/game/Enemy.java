package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends GameObject {
	int hp = 3;
	public Enemy() {
		super (new Sprite(new Texture("smallfreighterspr.png")), new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 20), 5);
		sprite.rotate90(true);
		sprite.rotate90(true);
	}
	
	public void Hurt() {
		hp--;
		if (hp < 1) {
			dead = true;
		}
	}
}
