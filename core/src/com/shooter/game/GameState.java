package com.shooter.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState extends State{
	Ship ship;
	List<GameObject> bulletList = new ArrayList<GameObject>();
	public void Show() {
		ship = new Ship();
	}
	
	public void Update(float dt) {
		boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
		boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);
		boolean zPressed = Gdx.input.isKeyJustPressed(Input.Keys.Z);
		
		float speed = 175f;
		if (upPressed) ship.pos.y += speed * dt;
		if (downPressed) ship.pos.y -= speed * dt;
		if (leftPressed) ship.pos.x -= speed * dt;
		if (rightPressed) ship.pos.x += speed * dt;
		if (zPressed) Fire();
	}
	
	void Fire() {
		GameObject bullet = new GameObject(new Sprite(new Texture("BulletBill.png")), ship.pos);
		bulletList.add(bullet);
	}
	
	public void Render(SpriteBatch sb) {
		ship.draw(sb);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).sprite.draw(sb);
		}
	}
}
