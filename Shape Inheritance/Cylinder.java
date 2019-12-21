import java.awt.*;

/*
@author Tanvir Tatla

File description: Cylinder is a subclass of Shape
Cylinder contains methods unique to itself and overrides methods in Shape (like
 draw and getArea)
 */
public class Cylinder extends Shape{
    private double radius;
    private double height;

    /*
    Constructor for Cylinder
    @param int x: the x-coordinate of the top of the Cylinder
    int y: the y-coordinate of the top of the Cylinder
    double radius: the radius of the cylinder
    double height: the height of the cylinder
     */
    public Cylinder(int x, int y, double radius, double height) {
        super(x,y);
        this.radius = radius;
        this.height = height;
    }

    /*
    getArea - gets the surface area of this Cylinder
    @Pre TRUE
    @Post returns a double that represents this Cylinder's surface area
     */
    public double getArea() {
        return (2 * Math.PI * radius) + (2 * Math.PI * radius * radius);
    }

    /*
    draw - draws a Cylinder
    @param Graphics g: instance of Graphics
    @Pre TRUE
    @Post Draws two ovals and connects the left and rightmost points of each
    oval with vertical lines.
     */
    public void draw(Graphics g) {
        int x = getX();
        int y = getY();
        int radius = (int) getRadius();
        int height = (int) getHeight();
        int diameter = radius * 2;
        int halfRadius = radius/2;

        // draws the top circle of the Cylinder
        g.drawOval(x, y, diameter, radius);

        // draws the bottom circle of the cylinder
        g.drawOval(x, y + height, diameter, radius);

        // draws vertical lines that connect the two circles
        g.drawLine(x, y + halfRadius, x, y + height + halfRadius);
        g.drawLine(x + diameter, y + halfRadius,
                x + diameter, y + height + halfRadius);
    }

    /*
    getRadius - getter method for radius
    @Pre TRUE
    @Post returns the radius instance variable of this Cylinder
     */
    public double getRadius() {
        return radius;
    }

    /*
    setRadius - setter method for radius
    @param double radius: the radius to set
    @Pre TRUE
    @Post sets the radius instance variable of this Cylinder
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /*
    getHeight - getter method for height
    @Pre TRUE
    @Post returns the height instance variable of this Cylinder
     */
    public double getHeight() {
        return height;
    }

    /*
    setHeight - setter method for height
    @param double height: the height to set
    @Pre TRUE
    @Post sets the height instance variable of this Cylinder
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
