package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class Oval extends Drawing
{
	
	private Point pointOne, pointTwo;
	private int length, height; //going to be using variable in square
	
	/**
	 * Takes the point and colour of rectangle
	 * @param  pointOne
	 * @param  colour
	 */
	public Oval()
	{
		super();
	}
	
	
	/**
	 * Sets the first point of the oval
	 * @param p
	 */
	public void setPointOne(Point p)
	{
		this.pointOne = p;
	}
	
	
	
	/**
	 * Return first point inputed
	 * @return Point One
	 */
	public Point getPointOne() 
	{
		return this.pointOne;
	}
	
	/**
	 * Return Point Two
	 * @return Point Two
	 */
	public Point getPointTwo() 
	{
		return this.pointTwo;
	}
	
	/**
	 * Set Point Two
	 * @param pointTwo
	 */
	public void setPointTwo(Point pointTwo) 
	{
		this.pointTwo = pointTwo;
	    this.length = Math.abs(this.pointOne.getX() - pointTwo.getX());
	    this.height = Math.abs(this.pointOne.getY() - pointTwo.getY());
	}
	
	/**
	 * Get Length (Calculated in setPointTwo method)
	 * @return
	 */
	public int getLength() 
	{
		return this.length;
	}
	
	/**
	 * Get Height (Calculated in setPointTwo method)
	 * @return
	 */
	public int getHeight() 
	{
		return this.height;
	}
	
	/**
	 * Mouse event that happens when mouse is released.
	 */
	public void mouseReleased(MouseEvent e) 
	{
		Point point = new Point(e.getX(), e.getY());
		setPointTwo(point);
	}
	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	public void mousePressed(MouseEvent e) 
	{
		Point point = new Point(e.getX(), e.getY());
		setPointOne(point); 
	}
	
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	public void mouseDragged(MouseEvent e)
	{
		Point point = new Point(e.getX(), e.getY());
		setPointTwo(point);
	}
	
	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	public void mouseClicked(MouseEvent e)
	{
		
	}

	
	/**
	 * Draws the oval on the screen.
	 */
	@Override
	public void execute(Graphics2D g2d) //accept method for us
	{
		int minX = Math.min(this.pointOne.getX(), this.pointTwo.getX());
		int minY = Math.min(this.pointOne.getY(), this.pointTwo.getY());
		g2d.setColor(super.getColour());
		g2d.setStroke(new BasicStroke(super.getThickness()));
		if(super.getFillStyleSelector())
		{
			g2d.drawOval(minX, minY, this.length, this.height);
		}
		else
		{
			g2d.fillOval(minX, minY, this.length, this.height);
		}
	}

	
	

}
