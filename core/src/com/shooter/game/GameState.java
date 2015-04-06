package com.shooter.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameState extends State{
	Ship ship;
	List<Bullet> bulletList = new ArrayList<Bullet>();
	List<Enemy> enemyList = new ArrayList<Enemy>();
	
	public void Show() {
		ship = new Ship();
		enemyList.add(new Enemy());
	}
	
	public void Update(float dt) {
		ship.Update(dt);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).Update(dt);
		}
		
		CheckOffScreen();
		CheckCollisions();
		CleanDead();
		
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
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).draw(sb);
		}
		ship.draw(sb);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).draw(sb);
		}
	}
	
	public void RenderShape(ShapeRenderer sr) {
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).drawShape(sr);
		}
		ship.drawShape(sr);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).drawShape(sr);
		}
	}
	
	void CheckOffScreen() {
		for (int i = 0; i < bulletList.size(); i++) {
			if (bulletList.get(i).OffScreen()) bulletList.remove(i);
		}
	}
	
	void CleanDead() {
		for (int i = 0; i < bulletList.size(); i++) {
			if (bulletList.get(i).isDead()) bulletList.remove(i);
		}
		for (int i = 0; i < enemyList.size(); i++) {
			if (enemyList.get(i).isDead()) enemyList.remove(i);
		}
	}
	
	void CheckCollisions() {
		//Bullet - Enemy Collision
		int totalRadius = 10 + 5;
		for (int i = 0; i < bulletList.size(); i++) {
			for (int j = 0; j < enemyList.size(); j++) {
				if (bulletList.get(i).pos.dst(enemyList.get(j).pos) < totalRadius) {
					bulletList.get(i).Hurt();
					enemyList.get(j).Hurt();
				}
			}
		}
	}
}
