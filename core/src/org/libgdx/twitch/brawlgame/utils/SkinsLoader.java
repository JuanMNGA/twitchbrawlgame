package org.libgdx.twitch.brawlgame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SkinsLoader {
	
    public Skin createSkin(){
    	Skin tmp_skin = new Skin();
    	tmp_skin.add("default-text", createFont(20, Color.WHITE));
    	// Cargar manualmente el atlas, por alguna razon, load no lo hace.
    	tmp_skin.addRegions(new TextureAtlas(Gdx.files.internal("skins/uiskin.atlas")));
    	tmp_skin.load(Gdx.files.internal("skins/uiskin.json"));
    	
		return tmp_skin;
    	
    }
    
    private BitmapFont createFont(int size, Color color){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/arial.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        if(color != null)
        	parameter.color = color;
        parameter.minFilter = TextureFilter.Nearest;
        parameter.magFilter = TextureFilter.Linear;
        BitmapFont tmpFont = generator.generateFont(parameter);
        tmpFont.getData().markupEnabled = true;
        generator.dispose();
        return tmpFont;
    }

}
