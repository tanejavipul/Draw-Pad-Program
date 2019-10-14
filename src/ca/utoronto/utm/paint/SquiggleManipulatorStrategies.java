package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SquiggleManipulatorStrategies implements ShapeManipulatorStrategy, MouseMotionListener, MouseListener {

	
	private PaintModel model;
	private PaintPanel paintpanel;
	private Squiggle squiggle;

	public SquiggleManipulatorStrategies(PaintModel model, PaintPanel paintpanel) {
		this.model= model;
		this.paintpanel = paintpanel;
	}
	/**
	 * Returns a new instance of the squiggle
	 */

	@Override
	public Drawing setShape() {
		return this.squiggle = new Squiggle();
		
	}

	/**
	 * Attaches the mouse events from the paint panel
	 */
	@Override
	public void install() {
		this.paintpanel.addMouseListener(this);
		this.paintpanel.addMouseMotionListener(this);
		
	}
	/**
	 * Removes the mouse events from the paint panel
	 */
	@Override
	public void uninstall() {
		this.paintpanel.removeMouseListener(this);
		this.paintpanel.removeMouseMotionListener(this);
	}
	

	/**
	 * Mouse event that happens when mouse is released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		this.squiggle.mouseReleased(e);
		this.model.addDraw(this.squiggle);
		this.paintpanel.setDrawComponents(this);
	}
	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.squiggle.setColour(this.paintpanel.getColor());
		this.squiggle.setThickness(this.paintpanel.getThickness());
		
		this.squiggle.mousePressed(e);
	}
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.squiggle.mouseDragged(e);
		this.model.addDraw(this.squiggle);
	}
	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Mouse event that happens when mouse is entered.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Mouse event that happens when mouse is exited.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Mouse event that happens when mouse is moved.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
