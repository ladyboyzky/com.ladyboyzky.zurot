package com.ph.game.zurot.view;

/**
 * 
 * @author hackmel
 * @version 1.0
 * Interface that should be implemented by any game panels
 */
public interface IPanel {
	
	public abstract void updateZurot(int direction);
	public abstract void updateObstacle();
	public abstract boolean isFoodEaten();

}
