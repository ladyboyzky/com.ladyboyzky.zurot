package com.ph.game.zurot.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity {

	
	private static final String TAG = MainActivity.class.getSimpleName();
	FrameLayout game;
	MainGamePanel mainView;
	LinearLayout gameWidgets;

    Button left ;
    Button right ;
    Button up;
    Button down;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	game = new FrameLayout(this);
        mainView=new MainGamePanel(this);
    	gameWidgets = new LinearLayout (this);

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
    
    
    private android.view.View.OnClickListener leftOnClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			MainGamePanel.DIR=1;
		}
	};
	
	
	
	 private android.view.View.OnClickListener rightOnClickListener = new View.OnClickListener() {
			public void onClick(View v) {
				MainGamePanel.DIR=2;
			}
		};
		
		
   private android.view.View.OnClickListener upOnClickListener = new View.OnClickListener() {
				public void onClick(View v) {
					MainGamePanel.DIR=3;
				}
	};	
	
	
   private android.view.View.OnClickListener downOnClickListener = new View.OnClickListener() {
			public void onClick(View v) {
				MainGamePanel.DIR=4;
			}
    };	
    
}
