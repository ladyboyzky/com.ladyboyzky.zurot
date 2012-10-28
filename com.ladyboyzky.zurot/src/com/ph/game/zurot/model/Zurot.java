package com.ph.game.zurot.model;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * 
 * @author hackmel
 *
 */
public class Zurot extends DroidSprite{


	public Zurot(Bitmap bitmap, int x, int y,int newWidth,int newHeight) {
		super(bitmap, x, y);
		
		int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,width, height, matrix, false);
        this.bitmap=resizedBitmap;

	}

	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= (x - bitmap.getWidth() / 2)
				&& (eventX <= (x + bitmap.getWidth() / 2))) {
			if (eventY >= (y - bitmap.getHeight() / 2)
					&& (y <= (y + bitmap.getHeight() / 2))) {
				// droid touched
				setTouched(true);
			} else {
				setTouched(false);
			}
		} else {
			setTouched(false);
		}

	}
}
