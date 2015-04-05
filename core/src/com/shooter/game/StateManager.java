package com.shooter.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StateManager {
	public static StateManager instance;
	List<State> stateList = new ArrayList<State>();
	
	public static StateManager getInstance() {
		if (instance == null) {
			instance = new StateManager();
		}
		return instance;
	}
	
	public void addState(State state) {
		getInstance().stateList.add(state);
		state.Show();
	}
	
	public void clearStates() {
		getInstance().stateList.clear();
	}
	
	public void changeState(State state) {
		clearStates();
		addState(state);
	}
	
	public void drawStates(SpriteBatch sb) {
		Gdx.gl.glClearColor(.5f, .5f, .5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		for (int i = 0; i < getInstance().stateList.size(); i++) {
			getInstance().stateList.get(i).Render(sb);
		}
		sb.end();
	}
	
	public void updateStates(float dt) {
		for (int i = 0; i < getInstance().stateList.size(); i++) {
			getInstance().stateList.get(i).Update(dt);
		}
	}
}