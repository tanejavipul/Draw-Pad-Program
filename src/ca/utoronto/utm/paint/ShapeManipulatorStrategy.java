package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface ShapeManipulatorStrategy extends MouseMotionListener, MouseListener {
	/**
	 * Returns a new instance of the shape
	 * @return
	 */
	public Drawing setShape();
	
	/**
	 * Attaches the mouse events from the paint panel
	 */
	public void install();
	
	/**
	 * Removes the mouse events from the paint panel
	 */
	public void uninstall();
}
