package com.ph.game.zurot.view;

import java.util.Random;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.ph.game.zurot.model.DroidSprite;
import com.ph.game.zurot.model.Food;
import com.ph.game.zurot.model.Zurot;

/**
 * 
 * @author hackmel
 * @version 1.0
 * Date: 28-10-2012
 * 
 * A reusable class for creating panel views. 
 * We can call this our base controller though were not actually 
 * following the MVC type framework.
 */
public abstract class BasePanel  extends SurfaceView implements
SurfaceHolder.Callback, IPanel {

	public BasePanel(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private static final String TAG = BasePanel.class.getSimpleName();
	
	
	protected MainThread thread;  	/* This is where the game loop happens */
	public static int DIR = 0;		/* This is the flag that tells what direction is the Zurot going (1-LEFT;2-Right;3-UP;4-DOWN) */
    public Zurot zurot;	            /* Represents the Zurot Object */
    public Food food;               /* Represents the Food Object */

	
	
	
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Zurot getZurot() {
		return zurot;
	}

	public void setZurot(Zurot zurot) {
		this.zurot = zurot;
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	/**
	 * Invoked every time this object is created.
	 * Upon creation, the main thread or game loop will also be 
	 * started.
	 */
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();

	}

	/**
	 * Collects all the thread and terminate it.
	 */
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
	
	
	/**
	 * This updates the direction of the Zurot object.
	 * The direction depends on the passed direction parameter.
	 */
	public void updateZurot(int direction){
		int pX = getZurot().getTail().get(0).getX();
		int pY = getZurot().getTail().get(0).getY();
		
		
		/*This is to check the heads direction */
		if (DIR == 1) {
			/* LEFT Direction */
			
			getZurot()
			.getTail().get(0)
			.setX(getZurot().getTail().get(0).getX()
					- getZurot().getTail().get(0)
							.getBitmap().getHeight());
		}else if (DIR == 2) {
			/* RIGHT Direction */
			
			getZurot()
			.getTail().get(0)
			.setX(getZurot().getTail().get(0).getX()
					+ getZurot().getTail().get(0)
							.getBitmap().getHeight());
        }else if (DIR == 3) {
        	/* UP Direction */
        	
        	getZurot()
			.getTail().get(0)
			.setY(getZurot().getTail().get(0).getY()
					- getZurot().getTail().get(0)
							.getBitmap().getHeight());
        }else if (DIR == 4) {
        	/* DOWN Direction */
        	
        	getZurot()
			.getTail().get(0)
			.setY(getZurot().getTail().get(0).getY()
					+ getZurot().getTail().get(0)
							.getBitmap().getHeight());
		}
		
		/*This line of code is to compute the next location of the tails based on the heads direction on the above code*/
		for (int x = 1; x < getZurot().getTail().size(); x++) {

			int fX = getZurot().getTail().get(x).getX();
			int fY = getZurot().getTail().get(x).getY();
			DroidSprite tail = getZurot().getTail().get(x);
			tail.setX(pX);
			tail.setY(pY);

			pX = fX;
			pY = fY;
		}
	}
	
	
	
	
	
	/**
	 * This is the collision detection routine between the Zurot and the Food object
	 */
	public boolean isFoodEaten() {
		// TODO Auto-generated method stub
		DroidSprite head=zurot.getTail().get(0);
		return ((head.getX()==food.getX() && head.getY()==food.getY()) || (head.getY()==food.getY() && head.getX()==food.getX()));
			
	}
	
	
	/**
	 * This method randomly the relocate of the food object after it has been
	 * eaten by the zurot.
	 */
	public void relocateFood(){
		Random randomGenerator = new Random();
		int x=randomGenerator.nextInt(this.getWidth());
		int y=randomGenerator.nextInt(this.getHeight());
		
		
		/* This check is to make sure that randomly generated location of the food object
		 * is always divisible by the foods size in bitmap. Food and Zurot basically have the same width
		 * and height. This is important because it makes it easier to align the X and Y axis of the objects
		 * for collision detection purposes.
		 * */
		if(x%food.getBitmap().getHeight()>0){
			Log.d(TAG, "X1:" + x);
			for(int i=x ; i>=0; i--){
				Log.d(TAG, "i:" + i);
				if((i%food.getBitmap().getHeight())==0){
					x=i; break;
				}
			}
			
			Log.d(TAG, "X:" + x);
			Log.d(TAG, "food.getBitmap().getHeight()" + food.getBitmap().getHeight());
		}
		
		
		if(y%food.getBitmap().getHeight()>0){
			Log.d(TAG, "Y1:" + y);
			for(int i=y ; i>=0; i--){
				Log.d(TAG, "i:" + i);
				if((i%food.getBitmap().getHeight())==0){
					y=i; break;
				}
			}
			
			Log.d(TAG, "Y:" + y);
			Log.d(TAG, "food.getBitmap().getHeight()" + food.getBitmap().getHeight());
		}
		
		
		food.setX(x);
		food.setY(y);
	}



}
