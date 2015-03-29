package com.shooter.game;

public abstract class State {
	void Show() {}
	abstract void Update();
	abstract void Render();
}
