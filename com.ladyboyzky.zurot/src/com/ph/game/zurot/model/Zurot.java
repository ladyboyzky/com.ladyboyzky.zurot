package com.ph.game.zurot.model;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

/**
 * 
 * @author hackmel
 * @version 1.0
 * Date: 28-10-2012
 * This class represents the Zurot Object. The hero of the game.
 */
public class Zurot{

    /**
     * Will contain the head and the tails of the Zurot object
     */
	private List<ZurotTail> tail =new ArrayList<ZurotTail>();

	/**
	 * 
	 * @return the list of head and tails
	 */
	public List<ZurotTail> getTail() {
		return tail;
	}


	/**
	 * 
	 * @param tail
	 * Sets the list of head and tails 
	 */
	public void setTail(List<ZurotTail> tail) {
		this.tail = tail;
	}


	/**
	 * 
	 * @param tail
	 * Add a new object of ZurotTail.
	 * This object represents the tail
	 */
	public void addTail(ZurotTail tail){
		this.tail.add(tail);
	}
	
	/**
	 * 
	 * @param canvas
	 * Draw the Zurot object on the canvas
	 */
	public void drawZurot(Canvas canvas){
		for(ZurotTail zurotObj:tail){
			zurotObj.draw(canvas);
		    zurotObj.draw(canvas);
		    zurotObj.draw(canvas);
		}
	}
	
}
