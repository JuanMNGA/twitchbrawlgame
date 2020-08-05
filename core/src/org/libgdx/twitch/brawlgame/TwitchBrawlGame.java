package org.libgdx.twitch.brawlgame;

import org.libgdx.twitch.brawlgame.screens.LoadingScreen;

import com.badlogic.gdx.Game;

public class TwitchBrawlGame extends Game {
	
	@Override
	public void create () {
		LoadingScreen loading = new LoadingScreen(this);
		this.setScreen(loading);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
