package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SquareManipulatorStrategies implements ShapeManipulatorStrategy{

	
	private PaintModel model;
	private PaintPanel paintpanel;
	private Square square;

	public SquareManipulatorStrategies(PaintModel model, PaintPanel paintpanel) {
		this.model = model;
		this.paintpanel = paintpanel;
		
	}
	
	/**
	 * Returns a new instance of the shape
	 */
	@Override
	public Drawing setShape() {
		return this.square = new Square();
		
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
		
		this.square.mouseReleased(e);
		this.model.addDraw(this.square);
		this.paintpanel.setDrawComponents(this);
	}
	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.square.setColour(this.paintpanel.getColor());
		this.square.setThickness(this.paintpanel.getThickness());
		this.square.setFillStyleSelector(this.paintpanel.getOutline());
		this.square.mousePressed(e);
	}
	
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.square.mouseDragged(e);
		this.model.addDraw(this.square);
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
