package com.ph.game.zurot.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * 
 * @author hackmel
 * @version 1.0
 * Date: 28-10-2012
 * 
 * This class is the parent sprite that we will use to create Bitmap images
 */
public abstract class DroidSprite {
	protected Bitmap bitmap; // the actual bitmap
	protected int x; // the X coordinate
	protected int y; // the Y coordinate
	protected boolean touched; // if droid is touched/picked up

	
	/**
	 * 
	 * @param bitmap
	 * @param x
	 * @param y
	 * @param newWidth
	 * @param newHeight
	 * 
	 * This is the constructor. This constructor modifies the original size of the bitmap.
	 * Originally the bitmap I used is quite larger so what I did is to make this constructor
	 * modify the bitmap size depending on the newWidth and newHeight we specify
	 * 
	 */
	public DroidSprite(Bitmap bitmap, int x, int y,int newWidth,int newHeight) {
		int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,width, height, matrix, false);
        this.bitmap=resizedBitmap;
        setX(x);
        setY(y);
	}

	/**
	 * 
	 * @return the bitmap image created
	 */
	public Bitmap getBitmap() {
		return bitmap;
	}

	
	/**
	 * 
	 * @return the X coordinate of the bitmap image
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 * Sets the X coordinate of the bitmap image
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return the Y coordinate of the bitmap image
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 * Sets the Y coordinate of the bitmap image
	 */ 
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return a boolean (True/False)
	 * This is method is for future functionality 
	 * where we create an object that can be dragged on the screen
	 */
	public boolean isTouched() {
		return touched;
	}

	/**
	 * 
	 * @param touched 
	 */
	public void setTouched(boolean touched) {
		this.touched = touched;
	}

	
	/**
	 * 
	 * @param canvas
	 * This method draws the bitmap in the canvas
	 */
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2),
				y - (bitmap.getHeight() / 2), null);
	}
	
	
}
