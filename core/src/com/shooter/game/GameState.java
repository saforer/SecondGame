package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameState extends State{
	Vector2 pos;
	Sprite shipSprite;
	public void Show() {
		pos = Vector2.Zero;
		shipSprite = new Sprite(new Texture("badlogic.jpg"));
	}
	
	public void Update(float dt) {
		boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
		boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);
		
		float speed = 175f;
		if (upPressed) pos.y += speed * dt;
		if (downPressed) pos.y -= speed * dt;
		if (leftPressed) pos.x -= speed * dt;
		if (rightPressed) pos.x += speed * dt;
	}
	
	public void Render(SpriteBatch sb) {
		shipSprite.setX(pos.x - shipSprite.getWidth() / 2);
		shipSprite.setY(pos.y - shipSprite.getHeight() / 2);
		shipSprite.draw(sb);
	}
}
