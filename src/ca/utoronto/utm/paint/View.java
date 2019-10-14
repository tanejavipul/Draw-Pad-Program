package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private JColorChooser colorChooser;
	private LineToolPanel lineToolPanel;
	
	/**
	 * Sets all the Panels 
	 * @param model
	 */
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		Container c=this.getContentPane();
	    // c.add(new JButton("North"),BorderLayout.NORTH);
		// c.add(new JButton("South"),BorderLayout.SOUTH);
		// c.add(new JButton("East"),BorderLayout.EAST);
		this.model=model;
		this.colorChooser = new JColorChooser();
		this.paintPanel = new PaintPanel(model, this, this.colorChooser);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		
		this.lineToolPanel = new LineToolPanel(this);
		JPanel centerPanel = new JPanel();
		
		centerPanel.add(lineToolPanel);
		

		c.add(centerPanel, BorderLayout.NORTH);
		c.add(this.shapeChooserPanel,BorderLayout.WEST);
		c.add(this.colorChooser, BorderLayout.SOUTH);
	
		
		
		
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		this.pack();
		// this.setSize(200,200);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public PaintModel getPaintModel(){
		return this.model;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}
	/**
	 * Returns the actions when button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Exit")	
		{
			System.exit(6);
		}
		else if(e.getActionCommand() == "Undo")
		{
			this.getPaintPanel().Undo();
		}
		else if(e.getActionCommand() == "Redo") {
			this.getPaintPanel().Redo();
		}
	}
}
