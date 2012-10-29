package com.ph.game.zurot.model;

import android.graphics.Bitmap;

/**
 * 
 * @author hackmel
 * @version 1.0
 * Date: 28-10-2012
 * This class represents obstacles
 */
public class Obstacle extends DroidSprite {

	
  /**
   * 
   * @param bitmap
   * @param x
   * @param y
   * @param newWidth
   * @param newHeight
   * Constructor of the Obstacle class. This will create a bitmap image of the Obstacle object
   */
	public Obstacle(Bitmap bitmap, int x, int y, int newWidth, int newHeight) {
		super(bitmap, x, y, newWidth, newHeight);
	}

	
}
