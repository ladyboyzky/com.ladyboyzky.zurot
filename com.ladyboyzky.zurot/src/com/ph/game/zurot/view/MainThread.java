package com.ph.game.zurot.view;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;


/**
 * 
 * @author hackmel
 * @version 1.0
 * Date: 28-10-2012
 * 
 * This is the game loop
 */
public class MainThread extends Thread {
	private static final String TAG = MainThread.class.getSimpleName();

	private SurfaceHolder surfaceHolder;
	private FirstLevelGamePanel gamePanel;
	private boolean running;

	public void setRunning(boolean running) {
		this.running = running;
	}

	public MainThread(SurfaceHolder surfaceHolder, FirstLevelGamePanel gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}

	
	/**
	 * This keeps the process in order and continuety.
	 * This is also responsible for the speed of the game
	 */
	@Override
	public void run() {
		Canvas canvas;
		Log.d(TAG, "Starting game loop");
		while (running) {
			canvas = null;
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					sleep(300); // controls the speed
					gamePanel.updateZurot(BasePanel.DIR); // check and update the coordinates of the zurot object
					gamePanel.checkForCollision();  // Check for collisions
					this.gamePanel.onDraw(canvas);  // finally re-draw everything again..
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if (canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			} 
		}
	}
}
