package org.libgdx.twitch.brawlgame.screens;

import org.libgdx.twitch.brawlgame.utils.AssetsLoader;
import org.libgdx.twitch.brawlgame.utils.SkinsLoader;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class MainMenuScreen implements Screen{
	
	private Game _g;
	
	private AssetsLoader _assets;
	private Stage _stage;
	
	private Skin _skin;
	
	private I18NBundle _menuMessages;
	
	public MainMenuScreen(Game g, AssetsLoader assets){
		this._g = g;
		this._assets = assets;
		init();
	}
	
	private void init(){
		_stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		
		// Nunca olvidar esta linea, sin ella, el stage no funciona
		Gdx.input.setInputProcessor(_stage);
		
		_skin = new SkinsLoader().createSkin();
		
		_menuMessages = _assets.getManager().get("i18n/messages", I18NBundle.class);
		// Crear actores para nuestro escenario
		
		float percentageW = 0.3f;
		float percentageH = 0.1f;
		
		Vector2 screenProportion = new Vector2(Gdx.graphics.getWidth()*percentageW, Gdx.graphics.getHeight()*percentageH);
		
		Table layout = new Table();
		
		final Image titleImage = new Image(_assets.getManager().get("badlogic.jpg", Texture.class));
		
		titleImage.addAction(Actions.sequence(
				Actions.alpha(0),
				Actions.fadeIn(1f)
				));
		
		final TextButton startButton = new TextButton(_menuMessages.format("maintitle.button.start"), _skin);
		final TextButton exitButton = new TextButton(_menuMessages.format("maintitle.button.exit"), _skin);
		
		startButton.addAction(Actions.sequence(
				Actions.alpha(0),
				Actions.fadeIn(1.5f)
				));
		
		startButton.addListener(new ChangeListener(){

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				startButton.addAction(Actions.sequence(
					Actions.fadeOut(1f),
					Actions.run(new Runnable(){
						@Override
						public void run() {
							System.out.println("El juego arranca");
						}
					})
				));
				
				exitButton.addAction(Actions.sequence(
						Actions.fadeOut(1f)
						));
			}
			
		});
		
		exitButton.addAction(Actions.sequence(
				Actions.alpha(0),
				Actions.fadeIn(2.5f)
				));
		
		exitButton.addListener(new ChangeListener(){

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				startButton.addAction(Actions.sequence(
						Actions.fadeOut(1f)
						));
				exitButton.addAction(Actions.sequence(
						Actions.delay(0.4f),
						Actions.fadeOut(1f),
						Actions.run(new Runnable(){

							@Override
							public void run() {
								dispose();
								Gdx.app.exit();
							}
							
						})
					));
			}
			
		});
		
		layout.add(titleImage).width(screenProportion.x).height(Gdx.graphics.getHeight()*0.4f);
		layout.row();
		layout.add(startButton).width(screenProportion.x).height(screenProportion.y);
		layout.row();
		layout.add(exitButton).width(screenProportion.x).height(screenProportion.y);
		
		layout.setFillParent(true);
		
		_stage.addActor(layout);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.5f, 0, 0, 0.7f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// Hacer calculos primero
		_stage.act(delta);
		// Dibujar el resultado de esos calculos
		_stage.draw();
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
		_stage.dispose();
	}

}
