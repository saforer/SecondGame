package com.shooter.game;

import com.badlogic.gdx.ApplicationAdapter;

public class ShooterGame extends ApplicationAdapter {
	public StateManager sm;

	public void create () {
		sm.addState(new MainState());
	}


	public void render () {
		sm.updateStates();
		sm.drawStates();
	}
}
