package ca.utoronto.utm.paint;


import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

public class PixelChooser {
	
	public PixelChooser() throws AWTException {
		Robot robot = new Robot();
	    Color color = robot.getPixelColor(20, 20);
	}
	

}
