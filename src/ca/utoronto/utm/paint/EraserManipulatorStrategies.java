package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EraserManipulatorStrategies implements ShapeManipulatorStrategy {

	
	private PaintModel model;
	private PaintPanel paintpanel;
	private Eraser eraser;
	
	public EraserManipulatorStrategies(PaintModel model, PaintPanel paintpanel) {this.model = model; this.paintpanel = paintpanel;}
	
	@Override
	public Drawing setShape() {
		return this.eraser = new Eraser();
	}
	/**
	 * Attach the mouse events from the paint panel
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
		
		this.eraser.mouseReleased(e);
		this.model.addDraw(this.eraser);
		this.paintpanel.setDrawComponents(this);
	}
	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		this.eraser.setThickness(this.paintpanel.getThickness());
		this.eraser.mousePressed(e);
	}
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.eraser.mouseDragged(e);
		this.model.addDraw(this.eraser);
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
