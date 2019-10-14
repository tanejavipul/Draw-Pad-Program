package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Drawing implements  MouseMotionListener, MouseListener, DrawingCommand
{
	private Color colour;
	private float thickness = 1;
	private boolean outline = true;
	
	
	/**
	 * Get colour of shape
	 * @return
	 */
	public Color getColour()
	{
		return this.colour;
	}
	
	/**
	 * Get colour of shape
	 * @return
	 */
	public void setColour(Color newColor)
	{
		this.colour = newColor;
	}

	/**
	 * Set Thickness
	 * @param thick a integer from 0-9
	 */
	public void setThickness(int thick)
	{
		this.thickness = thick;
	}
	
	/**
	 * Get Thickness
	 * @return thickness
	 */
	public float getThickness()
	{
		return this.thickness;
	}
	
	
	/**
	 * Outline of the shape is True and False for Fill
	 * @param x
	 */
	public void setFillStyleSelector(boolean x)
	{
		this.outline = x;
	}
	
	/**
	 * Boolean of how to draw shape
	 * @return
	 */
	public boolean getFillStyleSelector()
	{
		return this.outline;
	}
	
	/**
	 * Mouse event that happens when mouse is released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
		
	}
	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) 
	{
		
		
	}
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		
		
	}
	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}
	/**
	 * Mouse event that happens when mouse is entered.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	/**
	 * Mouse event that happens when mouse is exited.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	/**
	 * Mouse event that happens when mouse is moved.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	/**
	 * Makes the drawings on the screen
	 */
	@Override
	public void execute(Graphics2D g2d) {
		
		
	}
	
	
}
