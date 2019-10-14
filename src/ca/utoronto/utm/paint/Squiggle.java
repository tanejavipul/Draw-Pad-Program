package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Store all the points that make a squiggle
 * 
 *
 */
public class Squiggle extends Drawing
{
	private ArrayList<Point> points=new ArrayList<Point>();
	
	
	/**
	 * Takes the point and colour of squiggle
	 * @param pointOne
	 * @param colour
	 */
	public Squiggle()
	{
		super();
	}
	
	/**
	 * Set point to which previous point connects to
	 * @param newPoint
	 */
	public void addPoint(Point newPoint)
	{
		this.points.add(newPoint);
	}
	
	/**
	 * return ArrayList of points
	 * @return arraylist of points
	 */
	public ArrayList<Point> getPoints()
	{
		return this.points;
	}
	
	
	/**
	 * Mouse event that happens when mouse is released.
	 */
	public void mouseReleased(MouseEvent e) 
	{
		Point point = new Point(e.getX(), e.getY());
		addPoint(point);
	}
	/**
	 * Mouse event that happens when mouse is pressed.
	 */
	public void mousePressed(MouseEvent e) 
	{
		Point point = new Point(e.getX(), e.getY());
		addPoint(point);
	}
	/**
	 * Mouse event that happens when mouse is dragged.
	 */
	public void mouseDragged(MouseEvent e)
	{
		Point point = new Point(e.getX(), e.getY());
		addPoint(point);
	}
	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	
	/**
	 * Draws the squiggle on the screen
	 */
	public void execute(Graphics2D g2d) //accept method for us
	{
		for(int i=0;i<this.points.size()-1; i++)
		{
			Point p1=points.get(i);
			Point p2=points.get(i+1);
			g2d.setColor(this.getColour());
			g2d.setStroke(new BasicStroke(this.getThickness()));
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

}
