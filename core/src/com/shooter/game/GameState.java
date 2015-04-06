package com.shooter.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameState extends State{
	Ship ship;
	List<GameObject> bulletList = new ArrayList<GameObject>();
	public void Show() {
		ship = new Ship();
	}
	
	public void Update(float dt) {
		ship.Update(dt);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).Update(dt);
		}
		
		
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
		Bullet bullet = new Bullet(ship.pos.cpy());
		bulletList.add(bullet);
	}
	
	public void Render(SpriteBatch sb) {
		ship.draw(sb);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).draw(sb);
		}
	}
	
	public void RenderShape(ShapeRenderer sr) {
		ship.drawShape(sr);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).drawShape(sr);
		}
	}
}
