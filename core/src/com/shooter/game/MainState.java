package com.shooter.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainState extends State{
	List<UIButton> mainMenu = new ArrayList<UIButton>();
	int selectedMenuOption = 0;
	
	void Show() {
		mainMenu.add(new StartGameButton(true));
	}
	
	void Update(float dt) {
		MainControls();
	}
	
	void MainControls() {
		boolean zPressed = Gdx.input.isKeyJustPressed(Input.Keys.Z);
		
		if (zPressed) {
			mainMenu.get(selectedMenuOption).Action();
		}
	}
	
	void Render(SpriteBatch sb) {
		for (int i = 0; i < mainMenu.size(); i++) {
			mainMenu.get(i).Draw(sb);
		}
	}
}
