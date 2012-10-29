package com.ph.game.zurot.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;

import com.ph.game.zurot.R;
import com.ph.game.zurot.model.DroidSprite;
import com.ph.game.zurot.model.Food;
import com.ph.game.zurot.model.Obstacle;
import com.ph.game.zurot.model.Zurot;
import com.ph.game.zurot.model.ZurotTail;

/**
 * 
 * @author hackmel
 * @version 1.0
 * 
 * This is the first level implementation class.
 *  Date: 28-10-2012
 */
public class FirstLevelGamePanel extends BasePanel{

	
	private static final String TAG = FirstLevelGamePanel.class.getSimpleName();
	
	private List<Obstacle> obstacle =new ArrayList<Obstacle>();

	
	/**
	 * 
	 * @param context
	 * Initialize the objects for the game panel.
	 * Such objects are Zurot, Food and Obstacles
	 */

	public FirstLevelGamePanel(Context context) {

		super(context);
		getHolder().addCallback(this);

		/*Create a new Zurot Object*/
		setZurot(new Zurot());
		
		/*Create a new Food Object and initialize the size and location*/
		setFood(new Food(BitmapFactory.decodeResource(getResources(),
				R.drawable.food), 200, 700,20,20));
		
		
		/*Create head and tails for the Zurot Object*/
		ZurotTail head = new ZurotTail(BitmapFactory.decodeResource(getResources(),
				R.drawable.zurot), 200, 300,20,20);
		ZurotTail tail1 = new ZurotTail(BitmapFactory.decodeResource(getResources(),
				R.drawable.zurot), 200, head.getY()-head.getBitmap().getHeight(),20,20);
		ZurotTail tail2 = new ZurotTail(BitmapFactory.decodeResource(getResources(),
				R.drawable.zurot), 200, tail1.getY()-tail1.getBitmap().getHeight(),20,20);
		
		

		/*Add the head and tails created from the above code*/
		getZurot().addTail(head);
		getZurot().addTail(tail1);
		getZurot().addTail(tail2);
		
		
		/*Initialize the game loop*/
		thread = new MainThread(getHolder(), this);

		setFocusable(true);
	}

	
	/**
	 * re-draws all object in the canvas
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		getZurot().drawZurot(canvas);
		getFood().draw(canvas);
			
	}


	/**
	 * Update obstacles
	 */
	public void updateObstacle() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Check for object collisions
	 */
	public void checkForCollision(){
		if(isFoodEaten()){
			Log.d(TAG, "Collide");
			
			ZurotTail tail = new ZurotTail(BitmapFactory.decodeResource(getResources(),
					R.drawable.zurot), -20, -20,20,20);
			getZurot().addTail(tail);
			relocateFood();
		}
	}


	


	
	
	
	
}
