package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class OvalManipulatorStrategies implements ShapeManipulatorStrategy, MouseMotionListener, MouseListener {

	
	private PaintModel model = null;
	private PaintPanel paintpanel;
	private Oval oval;

	public OvalManipulatorStrategies(PaintModel model, PaintPanel paintpanel) {
		System.out.println("ZZZ "+model);
		this.model = model;
		this.paintpanel = paintpanel;
	}
	
	/**
	 * Returns a new instance of the Oval
	 */
	@Override
	public Drawing setShape() {
		return this.oval = new Oval();
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
	 * Remove the mouse events to the paint panel
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
		
		this.oval.setColour(this.paintpanel.getColor());
		this.oval.setThickness(this.paintpanel.getThickness());
		this.oval.setFillStyleSelector(this.paintpanel.getOutline());
		this.oval.mousePressed(e);
	}
	
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.oval.mouseDragged(e);
		this.model.addDraw(this.oval);
		
	}
	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Mouse event that happens when mouse is released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		this.oval.mouseReleased(e);
		this.model.addDraw(this.oval);
		this.paintpanel.setDrawComponents(this);
		
		
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
