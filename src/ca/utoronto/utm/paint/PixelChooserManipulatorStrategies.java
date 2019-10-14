package ca.utoronto.utm.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;

public class PixelChooserManipulatorStrategies implements ShapeManipulatorStrategy  {

	private PixelChooser pixelchooser;
	private PaintModel model;
	private PaintPanel paintpanel;
	private Robot robot;

	public PixelChooserManipulatorStrategies(PaintModel model,PaintPanel paintpanel) throws AWTException {
		this.model = model;
		this.paintpanel = paintpanel;
		this.robot = new Robot();
	}
		
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Color color = this.robot.getPixelColor(e.getX(), e.getY());
		this.paintpanel.setColor(color);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Drawing setShape() {
		return null;//setObject
		
	}

	@Override
	public void install() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uninstall() {
		// TODO Auto-generated method stub
		
	}

}
