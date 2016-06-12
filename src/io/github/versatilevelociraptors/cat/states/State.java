package io.github.versatilevelociraptors.cat.states;

import io.github.versatilevelociraptors.cat.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public abstract class State implements Disposable{

	protected GameStateManager manager;
	protected SpriteBatch batch;
	protected OrthographicCamera cam;

	protected State(GameStateManager manager) {
		this.manager = manager;
		cam = new OrthographicCamera(Game.getWidth() , Game.getHeight());
		cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = manager.getSpriteBatch();
	}

	protected abstract void render();
	protected abstract void update(float dt);
	public abstract void dispose();
	
	public OrthographicCamera getCam(){
		return cam;
	}
	
	public SpriteBatch getBatch(){
		return batch;
	}

}