package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PolylineManipulatorStrategies implements ShapeManipulatorStrategy, MouseMotionListener, MouseListener {

	
	private PaintModel model;
	private PaintPanel paintpanel;
	private Polyline polyline;

	public PolylineManipulatorStrategies(PaintModel model, PaintPanel paintpanel) {
		this.model = model;
		this.paintpanel = paintpanel;
		}
	/**
	 * Returns a new instance of the polyline.
	 */
	@Override
	public Drawing setShape() {
		return this.polyline = new Polyline();
		
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
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.polyline.setColour(this.paintpanel.getColor());
		this.polyline.setThickness(this.paintpanel.getThickness());
		this.polyline.setFillStyleSelector(this.paintpanel.getOutline());
		this.polyline.mousePressed(e);
	}
	
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.polyline.mouseDragged(e);
		this.model.addDraw(this.polyline);
	}
	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2)
		{
			this.polyline.mouseClicked(e);
			this.model.addDraw(this.polyline);
			this.paintpanel.setDrawComponents(this);
			
		}
		else
		{
			this.polyline.mouseClicked(e);
			this.model.addDraw(this.polyline);
		}
		
	}
	
	/**
	 * Mouse event that happens when mouse is released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
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
