package io.github.versatilevelociraptors.cat;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import io.github.versatilevelociraptors.cat.states.GameStateManager;
import io.github.versatilevelociraptors.cat.states.PlayState;


public class Game implements ApplicationListener {
	
	public static final String TITLE = "cAt";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 1000;
	public static final double SCALE = 1;
	
	public static final double NS = 1000000000.0 / 60.0;
	
    private GameStateManager manager;
	
	private double delta;
	private long lastTime;
	private int updates;
	private long timer;

	
	public static void main(String[] args){
		LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();

		//set window options
		configuration.title = TITLE;
		configuration.width = getWidth();
		configuration.height = getHeight();
		
		//set fps options
		configuration.vSyncEnabled = false;
		configuration.foregroundFPS = 0;
		configuration.backgroundFPS = 0;

		new LwjglApplication(new Game() , configuration);
	}

	@Override
	public void create() {
		manager = new GameStateManager();
		manager.push(new PlayState(manager));
		delta = 0;
		lastTime = System.nanoTime();
		timer = System.currentTimeMillis();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		long now = System.nanoTime();
		delta += now - lastTime;
		lastTime = now;
		
		// update if it is time to
		if(delta >= NS){
			manager.update((float) delta);
			updates++;
			delta -= NS;
		}
		manager.render();
		
		if(System.currentTimeMillis() - timer > 1000){
			timer += 1000;
			System.out.println(updates + " UPS");
			updates = 0;
		}
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	public static int getHeight(){
		return (int)(HEIGHT*SCALE);
	}

	public static int getWidth(){
		return (int)(WIDTH*SCALE);
	}

}
