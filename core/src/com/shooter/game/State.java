package com.shooter.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class State {
	void Show() {}
	abstract void Update(float dt);
	abstract void Render(SpriteBatch sb);
	abstract void RenderShape(ShapeRenderer sr);
}
