package io.github.versatilevelociraptors.cat.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.versatilevelociraptors.cat.Game;

public class PlayState extends State{
	
	public static final double SPEED = 10;
	private Sprite cat;	
	
	public PlayState(GameStateManager manager){
		super(manager);
		cat = new Sprite(new Texture("assets/images/catsmall.png"));
		cat.setFlip(false, true);
	}

	@Override
	protected void render() {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(cat, Game.getWidth()/2, Game.getHeight()/2);
		batch.end();
	}

	@Override
	protected void update(float dt) {
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
