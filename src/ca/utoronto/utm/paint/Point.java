package ca.utoronto.utm.paint;

/**
 *  Class holds a value of point.
 *  The x value 
 *  The y value
 * 
 *
 */
public class Point {
	int x, y;
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	
	/**
	 * Return X value
	 * @return x value
	 */
	public int getX() {
		return x;
	}
	/**
	 * Change X Value
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Return Y Value
	 * @return y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Change Y value
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
