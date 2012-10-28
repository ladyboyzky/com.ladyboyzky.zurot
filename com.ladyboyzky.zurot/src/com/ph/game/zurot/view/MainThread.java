package com.ph.game.zurot.view;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;


/**
 * 
 * @author hackmel
 *
 */
public class MainThread extends Thread {
	private static final String TAG = MainThread.class.getSimpleName();

	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;
	private boolean running;

	public void setRunning(boolean running) {
		this.running = running;
	}

	public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		Canvas canvas;
		Log.d(TAG, "Starting game loop");
		while (running) {
			canvas = null;
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					sleep(500);
					gamePanel.updateZurot(MainGamePanel.DIR);
					this.gamePanel.onDraw(canvas);
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
