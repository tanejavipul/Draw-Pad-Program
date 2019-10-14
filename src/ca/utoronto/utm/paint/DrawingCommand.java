package ca.utoronto.utm.paint;
import java.awt.Graphics2D;

/**
 * 
 * Makes the different shapes on the screen
 */
public interface DrawingCommand {
	public void execute(Graphics2D g2d);
}
