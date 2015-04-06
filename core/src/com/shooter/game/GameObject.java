package com.shooter.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	Sprite sprite;
	Vector2 pos;
	public GameObject(Sprite inSprite, Vector2 inPos) {
		sprite = inSprite;
		pos = inPos;
		updateSprite();
	}
	
	void updateSprite() {
		sprite.setX(pos.x - sprite.getWidth() / 2);
		sprite.setY(pos.y - sprite.getHeight() / 2);
	}
	
	public void draw(SpriteBatch sb) {
		updateSprite();
		sprite.draw(sb);
	}
	
	public void drawShape(ShapeRenderer sr) {
		sr.circle(pos.x, pos.y, 5);
	}
	
	public void Update(float dt) {}
}