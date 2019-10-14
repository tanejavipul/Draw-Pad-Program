package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 * Keeps data of all the points made
 * 
 *
 */


public class Polyline extends Drawing
{
	private ArrayList<Point> points;
	private boolean newPolyline = true;
	/**
	 * Creates new poly line with Point and colour
	 * @param start (point)
	 * @param colour
	 */
	public Polyline()
	{
		points=new ArrayList<Point>();
	}

	/**
	 * Add a new point
	 * @param newPoint
	 */
	public void addPoint(Point newPoint)
	{
		this.points.add(newPoint);
	}
	/**
	 * Get all the Points
	 * @return arraylist of points
	 */
	public ArrayList<Point> getPoints()
	{
		return this.points;
	}

	/**
	 * Mouse event that happens when mouse is clicked.
	 */
	public void mouseClicked(MouseEvent e)
	{
		Point point = new Point(e.getX(), e.getY());
		addPoint(point);		

	}
	
	
	/**
	 * Draws the polyline on the screen.
	 */
	@Override
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

	
	