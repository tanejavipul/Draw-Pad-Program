package ca.utoronto.utm.paint;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Class connects Model and View and displays application on the screen
 * 
 *
 */
public class Paint {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paint();
			}
		});
	}
	
	PaintModel model; // Model
	View view; // View+Controller
	
	/**
	 * Connect Model to View
	 */
	public Paint() { 
		// Create MVC components and hook them together

		// Model
		this.model = new PaintModel();

		// View+Controller
		this.view = new View(model);
	}
}
