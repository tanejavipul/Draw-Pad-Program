package ca.utoronto.utm.paint;

import java.awt.AWTException;

public class ShapeFactory {
	
	private PaintModel model;
	private PaintPanel paintpanel;

	public ShapeFactory(PaintModel model, PaintPanel paintpanel) {
		this.model = model;
		this.paintpanel =  paintpanel;
	}
	/**
	 * Implements the factory design stategy by creating instances of the shape strategies
	 * @param product
	 * @return
	 * @throws AWTException 
	 */
	public ShapeManipulatorStrategy createProduct(String product) throws AWTException {
		System.out.println("Z2 " + this.model);
		if (product.equals("Rectangle"))
			return new RectangleManipulatorStrategies(this.model, this.paintpanel);
		if (product.equals("Circle"))
			return new CircleManipulatorStrategies(this.model, this.paintpanel);
		if (product.equals("Square"))
			return new SquareManipulatorStrategies(this.model, this.paintpanel);
		if (product.equals("Polyline"))
			return new PolylineManipulatorStrategies(this.model, this.paintpanel);
		if (product.equals("Squiggle"))
			return new SquiggleManipulatorStrategies(this.model, this.paintpanel);
		if (product.equals("Oval"))
			return new OvalManipulatorStrategies(this.model, this.paintpanel);
		if (product.equals("Eraser"))
			return new EraserManipulatorStrategies(this.model, this.paintpanel);
		if (product.equals("PixelChooser"))
			return new PixelChooserManipulatorStrategies(this.model, this.paintpanel);
		return null;
	}

}
