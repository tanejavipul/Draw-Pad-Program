package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CircleManipulatorStrategies implements ShapeManipulatorStrategy{
	
	
	private PaintModel model;
	private PaintPanel paintpanel;
	private Circle circle;

	public CircleManipulatorStrategies(PaintModel model,PaintPanel paintpanel) {
		this.model = model;
		this.paintpanel = paintpanel;
	}
	/**
	 * Returns a new instance of the circle
	 */
	@Override
	public Drawing setShape() {
		return this.circle = new Circle();
	}
	
	/**
	 * Attachs the mouse events to the paint panel
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
		
		this.circle.mouseReleased(e);
		this.model.addDraw(this.circle);
		this.paintpanel.setDrawComponents(this);
	}
	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.circle.setColour(this.paintpanel.getColor());
		this.circle.setThickness(this.paintpanel.getThickness());
		this.circle.setFillStyleSelector(this.paintpanel.getOutline());
		this.circle.mousePressed(e);
	}
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.circle.mouseDragged(e);
		this.model.addDraw(this.circle);
	}


	/**
	 * Mouse event that happens when mouse is moved.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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



	
	

}
