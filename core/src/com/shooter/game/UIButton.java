package com.shooter.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UIButton {
	String text;
	Texture backgroundTexture;
	Vector2 pos;
	void Selected() {}
	void Deselected() {}
	void Draw(SpriteBatch sb) {}
	void Action() {}
	
	public void invertSelection() {	}
}
