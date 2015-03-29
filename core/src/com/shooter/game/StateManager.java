package com.shooter.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StateManager {
	public static StateManager instance;
	SpriteBatch sb;
	List<State> stateList = new ArrayList<State>();
	
	public StateManager getInstance() {
		if (instance == null) {
			instance = new StateManager();
			
		}
		return instance;
	}
	
	public SpriteBatch getSB() {
		if (sb == null) sb = new SpriteBatch();
		return getInstance().sb;
	}
	
	public void addState(State state) {
		getInstance().stateList.add(state);
		state.Show();
	}
	
	public void clearStates() {
		getInstance().stateList.clear();
	}
	
	public void drawStates() {
		for (int i = 0; i < getInstance().stateList.size(); i++) {
			getInstance().stateList.get(i).Render();
		}
	}
	
	public void updateStates() {
		for (int i = 0; i < getInstance().stateList.size(); i++) {
			getInstance().stateList.get(i).Update();
		}
	}
}