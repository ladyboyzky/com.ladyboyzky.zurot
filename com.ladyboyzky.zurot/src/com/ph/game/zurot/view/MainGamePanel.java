package com.ph.game.zurot.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.ph.game.zurot.R;
import com.ph.game.zurot.model.Zurot;

/**
 * 
 * @author hackmel
 *
 */
public class MainGamePanel extends SurfaceView implements
		SurfaceHolder.Callback {

	private MainThread thread;
	private static final String TAG = MainGamePanel.class.getSimpleName();
	private List<Zurot> zurot =new ArrayList<Zurot>();

	public static int DIR = 0;
	

	public List<Zurot> getZurot() {
		return zurot;
	}

	public void setZurot(List<Zurot> droid) {
		this.zurot = droid;
	}

	public MainGamePanel(Context context) {

		super(context);
		getHolder().addCallback(this);

		Zurot zurot1 = new Zurot(BitmapFactory.decodeResource(getResources(),
				R.drawable.zurot), 257, 317,20,20);
		Zurot zurot2 = new Zurot(BitmapFactory.decodeResource(getResources(),
				R.drawable.zurot), 257, zurot1.getY()-zurot1.getBitmap().getHeight(),20,20);
		Zurot zurot3 = new Zurot(BitmapFactory.decodeResource(getResources(),
				R.drawable.zurot), 257, zurot2.getY()-zurot1.getBitmap().getHeight(),20,20);

		zurot.add(zurot1);
		zurot.add(zurot2);
		zurot.add(zurot3);
		
		thread = new MainThread(getHolder(), this);

		setFocusable(true);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();

	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				Log.e(TAG, e.getMessage());
			}
		}

	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		for(Zurot zurotObj:zurot){
			zurotObj.draw(canvas);
		    zurotObj.draw(canvas);
		    zurotObj.draw(canvas);
		}
			
	}
	
	
	public void updateZurot(int direction){
		int pX = getZurot().get(0).getX();
		int pY = getZurot().get(0).getY();
		if (MainGamePanel.DIR == 1) {
			getZurot()
			.get(0)
			.setX(getZurot().get(0).getX()
					- getZurot().get(0)
							.getBitmap().getHeight());
		}else if (MainGamePanel.DIR == 2) {
			getZurot()
			.get(0)
			.setX(getZurot().get(0).getX()
					+ getZurot().get(0)
							.getBitmap().getHeight());
        }else if (MainGamePanel.DIR == 3) {
        	getZurot()
			.get(0)
			.setY(getZurot().get(0).getY()
					- getZurot().get(0)
							.getBitmap().getHeight());
        }else if (MainGamePanel.DIR == 4) {
        	getZurot()
			.get(0)
			.setY(getZurot().get(0).getY()
					+ getZurot().get(0)
							.getBitmap().getHeight());
		}
		
		for (int x = 1; x < getZurot().size(); x++) {

			int fX = getZurot().get(x).getX();
			int fY = getZurot().get(x).getY();
			Zurot zurot = getZurot().get(x);
			zurot.setX(pX);
			zurot.setY(pY);

			pX = fX;
			pY = fY;
		}
	}

}
