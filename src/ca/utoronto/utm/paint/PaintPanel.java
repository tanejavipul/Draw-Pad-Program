package ca.utoronto.utm.paint;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/
/**
 * Uses Mouse information to draw shapes/lines according to button options selected.
 * 
 *
 */
class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener, ChangeListener {
	private int i=0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	
	
	private Drawing drawComponents;
	private JColorChooser colorchooser;
	private Color color = Color.black;
	private int thickness;
	private boolean outline, polyline = false;
	private ShapeManipulatorStrategy strategy;
	private ArrayList<Drawing> OtherDrawings = new ArrayList<Drawing>();
	
	public PaintPanel(PaintModel model, View view, JColorChooser colorchooser)
	{
		this.strategy = new CircleManipulatorStrategies(model, this);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.colorchooser = colorchooser;
		this.colorchooser.getSelectionModel().addChangeListener(this);
		this.setDrawComponents(this.strategy);
		this.outline = true;
		this.model = model;
		this.model.addObserver(this);
		this.view=view;
	}

	/**
	 * Removes the last shape added to the screen
	 */

	public void Undo() {
		
		if (this.model.getDrawings().size() > 0) {
			
			Drawing new1 = (this.model.getDrawings().remove(this.model.getDrawings().size() -1));
			if (this.model.getDrawings().size()== 0) {
				
				this.OtherDrawings.add(new1);
			}
			while(new1 == this.model.getDrawings().get(this.model.getDrawings().size()-1) && this.model.getDrawings().size()-1 > 0 ) {
				this.OtherDrawings.add(new1);
				new1 = this.model.getDrawings().remove(this.model.getDrawings().size() -1);
			}
			if(this.model.getDrawings().size() == 1) {
				new1 = this.model.getDrawings().remove(this.model.getDrawings().size() -1);
				this.OtherDrawings.add(new1);
			}
			this.repaint();
			
		}
		}

	/**
	 *  Adds the last shape removed from the screen
	 */
	
	public void Redo(){
		if (this.OtherDrawings.size() > 0) {
			
			Drawing new2 = this.OtherDrawings.remove(this.OtherDrawings.size() -1);
			if (this.OtherDrawings.size()== 0) {
				
				this.model.getDrawings().add(new2);
			}
			while(new2 == this.OtherDrawings.get(this.OtherDrawings.size()-1) && this.OtherDrawings.size()-1 > 0 ) {

				this.model.getDrawings().add(new2);
				new2 = this.OtherDrawings.remove(this.OtherDrawings.size() -1);
			}
			if(this.OtherDrawings.size() == 1) {
				new2 = this.OtherDrawings.remove(this.OtherDrawings.size() -1);
				this.model.getDrawings().add(new2);
			}
			this.repaint();
			
		}
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// Origin is at the top left of the window 50 over, 75 down
        this.model.draw(g2d);
        
        /*
        ArrayList<Drawing> drawings = this.model.getDrawings();
		for(Drawing d: this.model.getDrawings())
		{
			 execute(d,g2d);
		}*/
		g2d.dispose();
	
	}
	
	/**
	 * Updates the object
	 */
	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 * Calls on the strategies of the specific shapes
	 * @param strategy
	 */
	public void setDrawComponents(ShapeManipulatorStrategy strategy) {
		this.drawComponents = strategy.setShape();
		this.strategy = strategy;
		

	}

	/**
	 *  Controller aspect of this
	 */
	
	public void setColor(Color color){
		this.color=color;
	}

	/**
	 * Sets thickness of lines of the different shapes
	 * @param x
	 */

	
	public Color getColor(){
		return this.color;
	}

	public void setThickness(JSlider x)
	{
		this.thickness = x.getValue();
	}

	/**
	 * Fills the shape completely or the outline depending on the option picked
	 * @param x
	 */

	
	public int getThickness()
	{
		return this.thickness;
	}

	public void setFillStyleSelection(String x) //Fill or Outline
	{
		if (x == "Fill")
		{
			this.outline = false;
		}
		else
		{
			this.outline = true;
		}
	}
	
	public boolean getOutline(){
		return this.outline;
	}
	
	// MouseMotionListener below

	/**
	 * Mouse event that happens when mouse is moved.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		this.strategy.mouseDragged(e);
		//this.model.addDraw(this.drawComponents);
	}

	// MouseListener below

	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		this.strategy.mouseClicked(e);

	}

	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
//		this.drawComponents.setColour(this.color);
//		this.drawComponents.setThickness(this.thickness);
//		this.drawComponents.setFillStyleSelector(this.outline);
		this.strategy.mousePressed(e);
		
	}

	/**
	 * Mouse event that happens when mouse is released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		this.strategy.mouseReleased(e);
	}
		
	/**
	 * Mouse event that happens when mouse is entered.
	 */
	@Override
	public void mouseEntered(MouseEvent e) 
	{

	}

	/**
	 * Mouse event that happens when mouse is exited.
	 */
	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}

	/**
	 * Sets the chosen color to the shape.
	 */
	public void stateChanged(ChangeEvent e) {
		this.setColor(this.colorchooser.getColor());
	}
	
}
