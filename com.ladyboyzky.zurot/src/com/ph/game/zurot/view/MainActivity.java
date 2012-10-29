package com.ph.game.zurot.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * 
 * @author hackmel
 * @version 1.0 Date: 28-10-2012
 * 
 *          This is the user interface controller
 */
public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	FrameLayout game;
	FirstLevelGamePanel mainView;
	LinearLayout gameWidgets;

	Button left;
	Button right;
	Button up;
	Button down;

	/**
	 * Creates and initialize the user interface
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		game = new FrameLayout(this);
		mainView = new FirstLevelGamePanel(this);
		gameWidgets = new LinearLayout(this);

		left = new Button(this);
		right = new Button(this);
		up = new Button(this);
		down = new Button(this);

		left.setWidth(40);
		left.setText("L");
		right.setWidth(40);
		right.setText("R");
		up.setWidth(40);
		up.setText("U");
		down.setWidth(40);
		down.setText("D");

		gameWidgets.addView(left);
		gameWidgets.addView(right);
		gameWidgets.addView(up);
		gameWidgets.addView(down);

		left.setOnClickListener(leftOnClickListener);
		right.setOnClickListener(rightOnClickListener);
		up.setOnClickListener(upOnClickListener);
		down.setOnClickListener(downOnClickListener);

		game.addView(mainView);
		game.addView(gameWidgets);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(game);
		Log.d(TAG, "View added");
	}

	
	@Override
	protected void onDestroy() {
		Log.d(TAG, "Destroying...");
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "Stopping...");
		super.onStop();
	}

	/**
	 * Handles the click event of the Left button
	 */
	private android.view.View.OnClickListener leftOnClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			BasePanel.DIR = 1;
		}
	};

	/**
	 * Handles the click event of the Right button
	 */
	private android.view.View.OnClickListener rightOnClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			BasePanel.DIR = 2;
		}
	};

	/**
	 * Handles the click event of the Up button
	 */
	private android.view.View.OnClickListener upOnClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			BasePanel.DIR = 3;
		}
	};

	 /**
     *  Handles the click event of the Down button
     */
	private android.view.View.OnClickListener downOnClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			BasePanel.DIR = 4;
		}
	};

}
