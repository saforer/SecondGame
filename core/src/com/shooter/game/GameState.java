package com.shooter.game;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class GameState extends State{
	Ship ship;
	List<Bullet> bulletList = new ArrayList<Bullet>();
	List<Enemy> enemyList = new ArrayList<Enemy>();
	
	public void Show() {
		ship = new Ship();
		
		for (int i = 0; i < 30; i++) {
			enemyList.add(new Enemy(this));
		}
	}
	
	public void Update(float dt) {
		ship.Update(dt);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).Update(dt);
		}
		
		
		EnemyUpdate(dt);
		CheckOffScreen();
		CheckCollisions();
		CleanDead();
		CheckWin();
		
		boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
		boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);
		boolean zPressed = Gdx.input.isKeyJustPressed(Input.Keys.Z);
		
		if (!ship.dead) {
			float speed = 175f;
			if (upPressed) ship.pos.y += speed * dt;
			if (downPressed) ship.pos.y -= speed * dt;
			if (leftPressed) ship.pos.x -= speed * dt;
			if (rightPressed) ship.pos.x += speed * dt;
			if (zPressed) Fire();
		}
	}
	
	void EnemyUpdate(float dt) {
		for (Enemy enemy : enemyList) {
			enemy.Update(dt);
		}
	}
	
	void Fire() {
		Bullet bullet = new Bullet(ship.pos.cpy(), true);
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

		int totalRadius = 10 + 5;
		for (int i = 0; i < bulletList.size(); i++) {
			//Bullet - Enemy Collision
			if (bulletList.get(i).ally) {
				for (int j = 0; j < enemyList.size(); j++) {
					if (bulletList.get(i).pos.dst(enemyList.get(j).pos) < totalRadius) {
						bulletList.get(i).Hurt();
						enemyList.get(j).Hurt();
					}
				}
			}
			
			if (!bulletList.get(i).ally) {
				if (bulletList.get(i).pos.dst(ship.pos) < totalRadius) {
					bulletList.get(i).Hurt();
					ship.Hurt();
				}
			}
		}
	}
	
	public void enemyFire(Vector2 pos) {
		float frontOfShip = 5;
		pos.y -= frontOfShip;
		Bullet bullet = new Bullet(pos.cpy(), false);
		bulletList.add(bullet);
	}
	
	void CheckWin() {
		if (enemyList.size() == 0) {
			System.out.println("YOU WIN");
		}
	}
}
