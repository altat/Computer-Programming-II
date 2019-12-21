import java.awt.*;

/*
@author Tanvir Tatla

File description: Triforce is a subclass of Shape
Triforce contains methods unique to itself and overrides methods in Shape (like
 draw and getArea)
 */
public class Triforce extends Shape{
    private int side;

    /*
    Constructor for Triforce
    @param int x: x-coordinate
    int y: y-coordinate
    int side: the side length of the entire Triforce
     */
    public Triforce(int x, int y, int side) {
        super(x,y);
        this.side = side;
    }

    /*
    getArea - gets the area of the Triforce
    @Pre TRUE
    @Post returns a double that represents this Triforce's area
     */
    public double getArea() {
        // side length of the smaller triangles
        int smallSide = side/2;

        // calculates the area of Triforce as one big triangle
        double bigArea = (Math.sqrt(3)/4) * side * side;

        // calulates the area of the upside down middle triangle
        double smallArea = (Math.sqrt(3)/4) * smallSide * smallSide;

        // subtracts the middle triangle area from the overall area
        return bigArea - smallArea;
    }

    /*
    draw - draws a Triforce
    @param Graphics g: instance of Graphics
    @Pre TRUE
    @Post draws 3 triangles with their corners touching and fills them in
    with YELLOW. The gap in the middle is filled in with BLACK.
     */
    public void draw(Graphics g) {
        // left corner
        int x1 = getX();
        int y1 = getY();

        // right corner
        int x3 = side + x1;
        int y3 = y1;

        // top corner
        int x2 = findMidpointX(x1, x3);
        int y2 = y1 - side;

        // midpoint of leftmost line
        int x4 = findMidpointX(x1, x2);
        int y4 = findMidpointY(y1, y2);

        // midpoint of right line
        int x5 = findMidpointX(x2, x3);
        int y5 = findMidpointY(y2, y3);

        // midpint of bottom line
        int x6 = x2;
        int y6 = y1;

        g.setColor(Color.YELLOW);

        // int array of left triangle coordinates
        int[] leftX = {x1, x6, x4};
        int[] leftY = {y1, y6, y4};

        // rightmost triangle coordinates
        int[] rightX = {x6, x5, x3};
        int[] rightY = {y6, y5, y3};

        // coordinates of top triangle
        int[] topX = {x4, x5, x2};
        int[] topY = {y4, y5, y2};

        // fills the left, right, and top triangles with yellow
        g.fillPolygon(leftX, leftY, 3);
        g.fillPolygon(rightX, rightY, 3);
        g.fillPolygon(topX, topY, 3);

        g.setColor(Color.BLACK);

        // draws the outer triangle
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);

        // draws the inner triangles
        g.drawLine(x4, y4, x5, y5);
        g.drawLine(x5, y5, x6, y6);
        g.drawLine(x6, y6, x4, y4);

        // coordinates of the upside down triangle (gap)
        int[] middleX = {x4, x5, x6};
        int[] middleY = {y4, y5, y6};

        // fills the gap with black
        g.fillPolygon(middleX, middleY, 3);
    }

    /*
    getSide - getter method for side
    @Pre TRUE
    @Post returns the side instance variable of this Triforce
     */
    public int getSide() {
        return side;
    }

    /*
    setSide - setter method for side
    @Pre TRUE
    @Post sets the side instance variable
     */
    public void setSide(int side) {
        this.side = side;
    }

    /*
    findMidpointX - finds the midpoint between two x-coordinates
    @param int x1: the first x-coordinate
    int x2: the second x-coordinate
    @Pre TRUE
    @Post returns the midpoint of the x-coordinates
     */
    private int findMidpointX(int x1, int x2) {
        return (x1 + x2)/2;
    }

    /*
    findMidpointY - finds the midpoint between two y-coordinates
    @param int y1: the first y-coordinate
    int y2: the second y-coordinate
    @Pre TRUE
    @Post returns the midpoint of the y-coordinates
     */
    private int findMidpointY(int y1, int y2) {
        return (y1 + y2)/2;
    }
}
