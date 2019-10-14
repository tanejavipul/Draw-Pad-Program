package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RectangleManipulatorStrategies implements ShapeManipulatorStrategy {

	
	private PaintModel model;
	private PaintPanel paintpanel;
	private Rectangle rectangle;

	public RectangleManipulatorStrategies(PaintModel model, PaintPanel paintpanel) {
		this.model = model;
		this.paintpanel = paintpanel;
		}
	/**
	 * Returns a new instance of the rectangle
	 */

	@Override
	public Drawing setShape() {
		return this.rectangle = new Rectangle();
		
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
		
		this.rectangle.mouseReleased(e);
		this.model.addDraw(this.rectangle);
		this.paintpanel.setDrawComponents(this);
	}
	

	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.rectangle.setColour(this.paintpanel.getColor());
		this.rectangle.setThickness(this.paintpanel.getThickness());
		this.rectangle.setFillStyleSelector(this.paintpanel.getOutline());
		this.rectangle.mousePressed(e);
	}

	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.rectangle.mouseDragged(e);
		this.model.addDraw(this.rectangle);
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
