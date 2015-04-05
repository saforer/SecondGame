package com.shooter.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
	void Show() {}
	abstract void Update(float dt);
	abstract void Render(SpriteBatch sb);
}
