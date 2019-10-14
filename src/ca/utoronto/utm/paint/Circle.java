package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
/**
 * Class hold information about a circle
 * 
 * 
 *
 */
public class Circle extends Drawing
{
	private Point centre;
	private int radius;
	private Point pointTwo;
	
	/**
	 * 
	 * @param centre a point from Point class
	 * @param radius Radius of the circle
	 * @param colour what colour is the circle
	 */
	public Circle()
	{
		super();
	}



	/**
	 * 
	 * @return the centre point
	 */
	public Point getCentre() 
	{
		return centre;
	}

	/**
	 * change center point
	 * @param centre
	 */
	public void setCentre(Point centre) 
	{
		this.centre = centre;
	}
	
	
	/**
	 * Set Point Two
	 * @param pointTwo
	 */
	public void setPointTwo(Point p) 
	{
		this.pointTwo = p;
		int x = Math.abs(p.getX()-this.centre.getX());
		int y = Math.abs(p.getY()-this.centre.getY());
		this.radius = (int)(Math.sqrt(((x*x)+(y*y)))); 
	}
	
	
	/**
	 * Get the radius made
	 * @return Radius
	 */
	public int getRadius() 
	{
		return radius;
	}
	
	
	public void mouseReleased(MouseEvent e) 
	{
		Point point = new Point(e.getX(), e.getY());
		setPointTwo(point);
	}
	
	public void mousePressed(MouseEvent e) 
	{
		Point point = new Point(e.getX(), e.getY());
		setCentre(point);		
	}
	
	public void mouseDragged(MouseEvent e)
	{
		Point point = new Point(e.getX(), e.getY());
		setPointTwo(point);
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	
	/**
	 * Draws the circle on the screen with the chosen colors.
	 */
	@Override
	public void execute(Graphics2D g2d) //accept method for us
	{
		g2d.setColor(super.getColour());
		g2d.setStroke(new BasicStroke(this.getThickness()));
	    if(super.getFillStyleSelector())
	    {
	    	g2d.drawOval(this.centre.getX()-this.radius, this.centre.getY()-this.radius, this.radius*2, this.radius*2);
	    }
	    else
	    {
	    	g2d.fillOval(this.centre.getX()-this.radius, this.centre.getY()-this.radius, this.radius*2, this.radius*2);
	    }
	}
	


}
