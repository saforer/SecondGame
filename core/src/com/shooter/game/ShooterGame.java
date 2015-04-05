package com.shooter.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShooterGame extends ApplicationAdapter {
	public StateManager sm;
	public SpriteBatch sb;

	public void create () {
		sm = new StateManager();
		sb = new SpriteBatch();
		sm.addState(new MainState());
	}


	public void render () {
		sm.updateStates(Gdx.graphics.getDeltaTime());
		sm.drawStates(sb);
	}
}
