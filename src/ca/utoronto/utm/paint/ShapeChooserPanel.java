package ca.utoronto.utm.paint;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/
/**
 * Create Left Panel with all the shapes
 * 
 *
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private JButton button[] = new JButton[8];
	private JButton backup;
	private ShapeFactory factory;
	ShapeManipulatorStrategy strategy = null;
	
	/**
	 * Create the buttons and add the action listener to them
	 * @param view
	 */
	public ShapeChooserPanel(View view) {	
		this.view=view;
		
		String[] buttonLabels = { "Circle", "Oval", "Rectangle", "Square", "Squiggle", "Polyline", "Eraser", "PixelChooser"};
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		System.out.println("Z3 " + this.view.getPaintModel());
		this.factory = new ShapeFactory(this.view.getPaintModel(), this.view.getPaintPanel());
		int x = 0;
		for (String label : buttonLabels) 
		{
			ImageIcon icon = new ImageIcon(getClass().getResource(label +".png"));
			button[x] = new JButton(icon);
			button[x].setActionCommand(label);
			this.add(button[x]);
			button[x].addActionListener(this);
			x++;
		}
		button[0].setEnabled(false);
		backup = button[0];
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(backup != (JButton)e.getSource())
		{
			backup.setEnabled(true);
			backup = (JButton)e.getSource();
		}
		((JButton)e.getSource()).setEnabled(false);
		try {
			strategy = factory.createProduct(e.getActionCommand());
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Pass in paintpanel to this new strategy, within that command do paintpanel.addMouseListener(this) ... addMouseMotionListener(ths)
		this.view.getPaintPanel().setDrawComponents(strategy);
		System.out.println(e.getActionCommand());
	}

	
}
