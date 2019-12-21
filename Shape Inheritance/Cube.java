import java.awt.*;

/*
@author Tanvir Tatla

File description: Cube is a subclass of Shape
Cube contains methods unique to itself and overrides methods in Shape (like
 draw and getArea)
 */
public class Cube extends Shape{
    private double side;

    /*
    Constructor for Cube
    @param int x: x-coordinate
    int y: y-coordinate
    int side: the side length of the Cube
     */
    public Cube(int x, int y, double side) {
        super(x,y);
        this.side = side;
    }

    /*
    getArea - gets the surface area of the Cube
    @Pre TRUE
    @Post returns a double that represents this Cube's surface area
     */
    public double getArea() {
        return 6*side*side;
    }

    /*
    draw - draws a Cube
    @param Graphics g: instance of Graphics
    @Pre TRUE
    @Post draws 2 squares and connects their corners with lines
     */
    public void draw(Graphics g) {
        int side = (int)getSide();
        int x1 = getX();
        int y1 = getY();

        // coordinates of the cube's back side
        int x2 = x1 + (side/3);
        int y2 = y1 - (side/3);

        // draws the front side of the cube
        g.drawRect(x1,y1,side,side);

        // draws the back side of the cube
        g.drawRect(x2, y2, side, side);

        // draws lines connecting the corners of the front and back sides
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x1 + side, y1 + side, x2 + side, y2 + side);
        g.drawLine(x1 + side, y1, x2 + side, y2);
        g.drawLine(x1, y1 + side, x2, y2 + side);
    }

    /*
    getSide - getter method for side
    @Pre TRUE
    @Post returns the side instance variable of this Cube
     */
    public double getSide() {
        return side;
    }

   /*
   setSide - setter method for side
   @Pre TRUE
   @Post sets the side instance variable
    */
    public void setSide(double side) {
        this.side = side;
    }
}
