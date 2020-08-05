package org.libgdx.twitch.brawlgame.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;
import com.badlogic.gdx.utils.I18NBundle;

public class AssetsLoader {
	
	private AssetManager assets = new AssetManager();
	
	public AssetsLoader(){
		FileHandleResolver resolver = new InternalFileHandleResolver();
		assets.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		assets.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		assets.setLoader(Texture.class, new TextureLoader(resolver));
	}
	
	public void load(){
		// Loaders
		// Textos i18n
		assets.load("i18n/messages", I18NBundle.class);
		assets.load("i18n/hud", I18NBundle.class);
		// Fuente por defecto
		assets.load("arial.ttf", BitmapFont.class, createFontParameter(20,Color.WHITE));
		// Carga del resto de archivos
		// Texturas
		assets.load("textures/bricks.png", Texture.class);
		assets.load("badlogic.jpg", Texture.class);
		// Musica
	}
	
	public AssetManager getManager(){
		return assets;
	}
    
    private FreeTypeFontLoaderParameter createFontParameter(int size, Color color){
    	FreeTypeFontLoaderParameter parameter = new FreeTypeFontLoaderParameter();
        parameter.fontFileName = "fonts/arial.ttf";
        parameter.fontParameters.size = size;
        parameter.fontParameters.color = color;
        parameter.fontParameters.minFilter = TextureFilter.Nearest;
        parameter.fontParameters.magFilter = TextureFilter.Linear;
        return parameter;
    }
    
    public boolean update(){
    	return assets.update();
    }
    
    public boolean isLoaded(String resource){
    	return assets.isLoaded(resource);
    }
    
    public void dispose(){
    	assets.dispose();
    }

}
