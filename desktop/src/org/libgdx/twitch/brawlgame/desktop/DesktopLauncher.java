package org.libgdx.twitch.brawlgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.libgdx.twitch.brawlgame.TwitchBrawlGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Gladiator brawl game";
		config.width = 600;
		config.height = 480;
		new LwjglApplication(new TwitchBrawlGame(), config);
	}
}
