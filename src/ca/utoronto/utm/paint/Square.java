package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
/**
 * Holds information of Square.
 * this class extends from Rectangle as it similar.
 * 
 *
 */
public class Square extends Drawing
{
	
	private Point pointOne, pointTwo;
	private int length, height; //going to be using variable in square
	
	/**
	 * Takes the point and colour of square
	 * @param pointOne
	 * @param colour
	 */
	public Square()
	{
		super();
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
	 * Draws the square on the screen.
	 */
	@Override
	public void execute(Graphics2D g2d) //accept method for us
	{
		int finalX=0, finalY=0;
		int maxLength = Math.max(this.length, this.height);
		
		if(this.pointOne.getX() > this.pointTwo.getX() && this.pointOne.getY() > this.pointTwo.getY())
		{
			finalX = this.pointOne.getX() - maxLength;
			finalY = this.pointOne.getY() - maxLength;
		}
		else if(this.pointOne.getX() < this.pointTwo.getX() && this.pointOne.getY() > this.pointTwo.getY())
		{
			finalX = this.pointOne.getX();
			finalY = this.pointOne.getY() - maxLength;
		}
		else if(this.pointOne.getX() > this.pointTwo.getX() && this.pointOne.getY() < this.pointTwo.getY())
		{
			finalX = this.pointOne.getX() - maxLength;
			finalY = this.pointOne.getY();
		}
		else
		{
			finalX = this.pointOne.getX();
			finalY = this.pointOne.getY();
		}
	    g2d.setColor(this.getColour());
	    g2d.setStroke(new BasicStroke(this.getThickness()));
	    if(super.getFillStyleSelector())
	    {
	    	g2d.drawRect(finalX, finalY, maxLength, maxLength);  
	    }
	    else
	    {
	    	 g2d.fillRect(finalX, finalY, maxLength, maxLength);
	    }
	}

}
