package org.libgdx.twitch.brawlgame.screens;

import org.libgdx.twitch.brawlgame.utils.AssetsLoader;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.I18NBundle;

public class LoadingScreen implements Screen{
	
	private I18NBundle _i18nMessages;
	
	private SpriteBatch _batch;
	
	private Game _g;
	private AssetsLoader _assets;
	
	public LoadingScreen(Game g){
		this._g = g;
		_assets = new AssetsLoader();
		_assets.load();
		_batch = new SpriteBatch();
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(_assets.update()){
			_g.setScreen(new MainMenuScreen(_g, _assets));
		} else {
			// Iniciamos el dibujado
			_batch.begin();
			// Dibujamos todo lo que queramos en el frame
			if(_assets.isLoaded("arial.ttf")){
				_i18nMessages = _assets.getManager().get("i18n/messages", I18NBundle.class);
				_assets.getManager().get("arial.ttf", BitmapFont.class).draw(_batch, _i18nMessages.format("maintitle.label.loading"), 100, 100);
			}
			// Paramos el dibujado
			_batch.end();
		}
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		_g.dispose();
		_assets.dispose();
	}

}
