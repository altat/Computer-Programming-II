import java.awt.*;

/*
@author Tanvir Tatla

File description: Circle is a subclass of Shape
Circle contains methods unique to itself and overrides methods in Shape (like
 draw and getArea)
 */
public class Circle extends Shape{
    private double radius;
    private boolean filled;

    /*
    Constructor for Circle
    @param int xOrigin: the x-coordinate of the Circle's origin
    int yOrigin: the y-coordinate of the Circle's origin
    double radius: the Circle's radius
    boolean isFilled: whether the circle should be filled with the color white
     */
    public Circle(int xOrigin, int yOrigin, double radius, boolean isFilled) {
        super(xOrigin, yOrigin);
        this.radius = radius;
        this.filled = isFilled;
    }

    /*
    getArea - gets the area of a circle
    @Pre TRUE
    @Post returns a double that represents this circle's area
    */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /*
    draw - draws a circle
    @param Graphics g: instance of Graphics
    @Pre TRUE
    @Post either draws a circle with a black outline or a white circle with a
     black outline
     */
    public void draw(Graphics g) {
        int radius = (int)getRadius();
        // subtracts radius from x and y so that circle is drawn with center
        // at x and y
        int x = getX() - radius;
        int y = getY() - radius;
        int diameter = radius*2;

        // if the circle should be filled
        if (filled) {
            // then fill the circle with white
            g.setColor(Color.WHITE);
            g.fillOval(x,y, diameter, diameter);
        }

        // draw circle with black outline
        g.setColor(Color.BLACK);
        g.drawOval(x,y, diameter, diameter);
    }

    /*
    getRadius - getter method for radius
    @Pre TRUE
    @Post returns the radius instance variable of this circle
     */
    public double getRadius() {
        return radius;
    }

    /*
    setRadius - setter method for radius
    @param double radius: the radius to set
    @Pre TRUE
    @Post sets the radius instance variable of this circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /*
    isFilled - gets the filled status of this circle
    @Pre TRUE
    @Post returns true or false
     */
    public boolean isFilled() {
        return filled;
    }

    /*
    setFilled - sets the filled status of this Circle
    @param boolean filled: whether the circle should be filled or not
    @Pre TRUE
    @Post sets filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
