import java.awt.*;

/* Class Shape
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes
 */

/*the superclass in our inheritance hierarchy
  all "common" features, functions and data should go here
  for example, all shapes in Java2D have a x,y that declares their position
  and many of the shapes exposed have a width and a height (but not all, so
  we didn't put width and height here)
*/
class Shape extends Object {
	private int x = 0;
	private int y = 0;
	private Color myColor;

	/*
	Shape Constructor
	@param int x: x coordinate of Shape
	int y: y coordinate of Shape
	 */
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

    /*
    Shape Constructor
    @param int x: x coordinate of Shape
    int y: y coordinate of Shape
    Color color: the color of the Shape
     */
	public Shape(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		myColor = color;
	}

	/*
	getArea - should be overridden by Shape subclasses
	@Pre TRUE
	@Post should return the area of a shape as a double
	 */
	public double getArea(){ return -1; }

    /*
    getArea - should be overridden by Shape subclasses
    @param Graphics g: an instance of Graphics
    @Pre TRUE
    @Post should draw the shape
     */
	public void draw( Graphics g ){}

	/*
	getX - getter for x-coordinate
	@Pre TRUE
	@Post returns the x-coordinate of this shape
	 */
	public int getX() { return x; }

    /*
    getY - getter for y-coordinate
    @Pre TRUE
    @Post returns the y-coordinate of this shape
     */
	public int getY() { return y; }


    /*
    setX - setter for x-coordinate
    @param int x: the x-coordinate to set
    @Pre TRUE
    @Post sets the x-coordinate of this shape
     */
	public void setX(int x) {
		this.x = x;
	}

    /*
    setX - setter for x-coordinate
    @param int x: the x-coordinate to set
    @Pre TRUE
    @Post sets the x-coordinate of this shape
     */
	public void setY(int y) {
		this.y = y;
	}
}