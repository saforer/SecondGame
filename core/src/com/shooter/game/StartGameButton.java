package com.shooter.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StartGameButton extends UIButton {
	String text;
	Texture backgroundTexture;
	Vector2 pos;
	BitmapFont font;
	boolean selected;
	public StartGameButton(boolean inSelected) {
		text = "Start the game.";
		font = new BitmapFont();
		pos = new Vector2(0,0);
		selected = inSelected;
		UpdateTexture();
	}
	
	public void Selected() {
		backgroundTexture = new Texture("MenuButtonOn.png");
	}
	public void Deselected() {
		backgroundTexture = new Texture("MenuButtonOff.png");
	}

	public void invertSelection() {
		selected = !selected;
		UpdateTexture();
	}
	
	public void UpdateTexture() {
		if (selected) {
			Selected();
		} else {
			Deselected();
		}
	}
	
	public void Draw(SpriteBatch sb) {
		sb.draw(backgroundTexture, pos.x, pos.y);
		font.draw(sb, text, pos.x + 30, pos.y + 20);
	}
	
	public void Action() {
		StateManager.getInstance().changeState(new GameState());
	}
}