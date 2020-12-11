package net.digiturtle.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
	
	public static Sound LASER, SHIP_DAMAGE, ASTEROID_DESTROYED;
	public static Music ENGINE, ALIEN_DREAM;
	
	public static void create () {
		ENGINE = Gdx.audio.newMusic(Gdx.files.internal("158729__erdie__engine03-loop.wav"));
		ENGINE.setLooping(true);
		ENGINE.setVolume(.5f);
		ALIEN_DREAM = Gdx.audio.newMusic(Gdx.files.internal("396239__romariogrande__alien-dream.wav"));
		ALIEN_DREAM.setLooping(true);
		LASER = Gdx.audio.newSound(Gdx.files.internal("523205__matrixxx__retro-laser-gun-shot.wav"));
		SHIP_DAMAGE = Gdx.audio.newSound(Gdx.files.internal("hjm-big_explosion_3.wav"));
		ASTEROID_DESTROYED = Gdx.audio.newSound(Gdx.files.internal("explosion_somewhere_far.mp3"));
	}
	
	public static void dispose () {
		ENGINE.dispose();
		ALIEN_DREAM.dispose();
		LASER.dispose();
		SHIP_DAMAGE.dispose();
		ASTEROID_DESTROYED.dispose();
	}

}
