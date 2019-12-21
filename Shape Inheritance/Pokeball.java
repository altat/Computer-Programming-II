import java.awt.*;

/*
@author Tanvir Tatla

File description: Pokeball is a subclass of Shape
Pokeball contains methods unique to itself and overrides methods in Shape (like
 draw and getArea)
 */
public class Pokeball extends Shape{
    private double radius;

    /*
    Constructor for Pokeball
    @param int x: the x-origin of the Pokeball
    int y: the y-origin of the Pokeball
    double radius: the radius of the Pokeball
     */
    public Pokeball(int x, int y, double radius) {
        super(x,y);
        this.radius = radius;
    }

    /*
    getArea - gets the surface area of the Pokeball
    @Pre TRUE
    @Post returns a double that represents this Pokeball's surface area
     */
    public double getArea() {
        return 4*Math.PI * radius * radius;
    }

    /*
    draw - draws a Pokeball
    @param Graphics g: instance of Graphics
    @Pre TRUE
    @Post Draws a circle and fills the top half with red and bottom half with
     white. Draws a horizontal line through the middle. Then draws a smaller
     white circle in the middle and an even smaller circle inside the white
     circle.
     */
    public void draw(Graphics g) {
        int x = getX();
        int y = getY();
        int radius = (int)getRadius();
        int diameter = radius*2;

        g.setColor(Color.RED);

        // fills the top half of the outer circle with red
        g.fillArc(x - radius, y - radius, diameter,diameter,
                0,180);

        g.setColor(Color.WHITE);

        //fills the bottom half with white
        g.fillArc(x - radius, y - radius, diameter,diameter,
                0,-180);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(radius/20));

        // draws the outer circle's outline
        Circle outer = new Circle(x, y, radius, false);
        outer.draw(g);

        // draws the horizontal line across the middle
        g2.drawLine(x - radius, y, x + radius, y);

        // draws a smaller white circle inside the outer circle
        Circle inner = new Circle(x,y,radius/4, true);
        inner.draw(g);

        int buttonRadius = (int)inner.getRadius();
        buttonRadius -= inner.getRadius()/4;

        g2.setStroke(new BasicStroke(1));

        // draws an outline of a circle inside the inner circle
        Circle button = new Circle(x, y, buttonRadius, false);
        button.draw(g);
    }

    /*
    getRadius - getter method for radius
    @Pre TRUE
    @Post returns the radius instance variable of this Pokeball
     */
    public double getRadius() {
        return radius;
    }

    /*
    setRadius - setter method for radius
    @param double radius: the radius to set
    @Pre TRUE
    @Post sets the radius instance variable of this Pokeball
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
