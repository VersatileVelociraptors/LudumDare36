package io.github.versatilevelociraptors.cat;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Game implements ApplicationListener {
	
	public static final String TITLE = " ";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 1000;
	public static final double SCALE = 1;
	
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
		// TODO Auto-generated method stub
		
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
