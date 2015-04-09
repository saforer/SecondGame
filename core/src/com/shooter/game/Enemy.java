package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends GameObject {
	int hp = 3;
	GameState gs;
	float posMovingTo;
	float firingCooldown = 0;
	float movingCooldown = 0;
	float fireVar;
	float idleAmount;
	float moveAmount;
	static Texture texture = new Texture("smallfreighterspr.png");
	public Enemy(GameState inState) {
		super (new Sprite(texture), new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 20), 5);
		pos.x = MathUtils.random(sprite.getWidth() / 2, Gdx.graphics.getWidth() - sprite.getWidth() / 2);
		sprite.rotate90(true);
		sprite.rotate90(true);
		gs = inState;
		posMovingTo = pos.x;
		fireVar = MathUtils.random(10f);
		idleAmount = MathUtils.random(2f);
		moveAmount = MathUtils.random(3f);
	}
	
	public void Update(float dt) {
		Fire(dt);
		Move(dt);
	}
	
	void Fire(float dt) {
		firingCooldown += dt;
		if (firingCooldown > fireVar) {
			firingCooldown = 0;
			fireVar = MathUtils.random(10);
			gs.enemyFire(pos.cpy());
		}
	}
	
	void Move(float dt) {
		movingCooldown += dt;
		
		float speed = 100;
		float right = 0;
		float tolerance = 1;
		
		if (movingCooldown > 0) {
			//Figure out if we need to move at all 
			if (!(pos.x - tolerance < posMovingTo && pos.x + tolerance > posMovingTo)) {
				//Figure out if you need to move to the left or the right
				if (pos.x > posMovingTo) {
					//We're to the right of the point we need to be
					right = -1;
				} else {
					//We're to the left of the point we need to be
					right = 1;
				}
				
				pos.x += dt * speed * right;
			}
		}
		
		if (movingCooldown > moveAmount) {
			posMovingTo = MathUtils.random(sprite.getWidth() / 2, Gdx.graphics.getWidth() - sprite.getWidth() / 2);
			movingCooldown = idleAmount * -1;
		}
	}
	
	public void Hurt() {
		hp--;
		if (hp < 1) {
			dead = true;
		}
	}
}
