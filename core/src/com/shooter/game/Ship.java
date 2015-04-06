package com.shooter.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ship extends GameObject {
	public Ship() {
		super(new Sprite(new Texture("smallfreighterspr.png")), Vector2.Zero, 5);
	}
}
