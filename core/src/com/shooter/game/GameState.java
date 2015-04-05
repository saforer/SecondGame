package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState extends State{
	public void Update(float dt) {
		
	}
	
	public void Render(SpriteBatch sb) {
		BitmapFont font = new BitmapFont();
		font.draw(sb, "GAME STATE", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
	}
}
