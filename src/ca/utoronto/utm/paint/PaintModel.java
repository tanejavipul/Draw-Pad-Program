package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Keeps data of all the shapes/lines made 
 * For each shape/line there is method to add shape/line 
 * or return all the Arraylist of shape/line.
 */
public class PaintModel extends Observable {
	
	private ArrayList<Drawing> draw = new ArrayList<Drawing>();
	
	public void addDraw(Drawing d){
		this.draw.add(d);
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Drawing> getDrawings(){
		return this.draw;
	}
	
	public void draw(Graphics2D g2d)
	{
		for(Drawing d: this.getDrawings())
		{
			d.execute(g2d);
		}
		
	}
	
}
