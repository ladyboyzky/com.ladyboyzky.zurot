package com.ph.game.zurot.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * 
 * @author hackmel
 *
 */
public abstract class DroidSprite {
	protected Bitmap bitmap; // the actual bitmap
	protected int x; // the X coordinate
	protected int y; // the Y coordinate
	protected boolean touched; // if droid is touched/picked up

	public DroidSprite(Bitmap bitmap, int x, int y) {
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isTouched() {
		return touched;
	}

	public void setTouched(boolean touched) {
		this.touched = touched;
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2),
				y - (bitmap.getHeight() / 2), null);
	}
	
	public abstract void handleActionDown(int eventX, int eventY);
}
