import java.util.*;
import javax.swing.*;
import java.awt.*;

/*
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * 
 * Author: Rob Nash
 *
 * Slightly Modified by: Tanvir Tatla
 */


class PolyDemo extends JFrame {
	
	/*
	Constructor for PolyDemo
	 */
	public PolyDemo() {
		getContentPane().add( new PolyDemoPanel() );
		//just some windowing stuff that must happen for all Frames
		setSize( 300,300 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	/*
	main method creates a new PolyDemo
	 */
	public static void main( String args[] ) {
		PolyDemo myApp = new PolyDemo();
	}
	
	
	//this is our first "inner" or internal class 
	//the purpose of this class is solely to support the JFrame class above, and I don't want it reused in arbitrary contexts, so by nesting this class here
	//I can indicate the intent a bit more clearly that this class "goes with" the class above it
	//In general, each class is a separate entity that should be contained in a separate file
	public class PolyDemoPanel extends JPanel {		
		Shape[] myShapes= new Shape[20];

		/*
		Constructor for PolyDemoPanel
		 */
		public PolyDemoPanel() {
			//Shape a = new Shape( getRandInt(), getRandInt());
			//Shape b = new Circle( getRandInt(), getRandInt(), getRandInt() );
		
			//a = new Square(getRandInt(), getRandInt(), getRandInt(), getRandInt() );
		
			//a = getRandShape();

			//( (Circle) b ).getRadius();
		
		
			/*********************************************************************************************************************
			* Code for populating our myShapes changes minimally when new classes are introduced (only in getRandShape())
			*********************************************************************************************************************/
			for( int i = 0; i < myShapes.length; i++ ) {
				myShapes[i] =  getRandShape();
			}
		}
		
		/*********************************************************************************************************************
		 * Code for drawing our shapes doesn't change at all! Since we intended to take advantage of polymorphism, we coded 
		 * this "in general" with respect to the superclass, and not specific to any subclass.
		 *********************************************************************************************************************/
		/*
		paint - draws every shape in myShapes array
		@param Graphics g - instance of Graphics
		@Pre TRUE
		@Post draws every shape in the myShapes array
		 */
		public void paint( Graphics g ) {
			super.paint(g);  //don't remove - required for GUI widgets to draw correctly
			/************************
			 * Late Binding Demo
			 ************************/
			for( int i = 0; i < myShapes.length; i++ ){
				//which draw method is invoked here? There are many forms of the method (polymorphic), so which is chosen?
				//Java has RTTI about every object, and it uses this info to choose the correct method to invoke!
				myShapes[i].draw( g );
				System.out.println(myShapes[i].getArea());
			}
		}
			
		/*
		getRandInt - gets a random number
		@Pre TRUE
		@POST returns a random integer
		 */
		public int getRandInt() {
			return ( (int) ( Math.random() * 200 ) );	
		}

		/*
		getRandShape - gives you a random shape
		@Pre TRUE
		@Post returns a random shape out of 5 choices. The Shape could either
		 be a Cube, Pokeball, Cylinder, Triforce, or Circle.
		 */
		public Shape getRandShape() {
			Shape retVal = null;
			final int x = getRandInt();
			final int y = getRandInt();
			
			
			/********************************
			 * Polymorphic extensibility demo
			 *
			 *******************************/
			switch( ( int )(Math.random() * 5) ) {
				case 0: 	retVal = new Cube( x,y,getRandInt());
							break;
				case 1: 	retVal = new Pokeball(x,y,getRandInt());
							break;
				case 2: 	retVal = new Cylinder(x,y,getRandInt(),getRandInt());
							break;
				case 3: 	retVal = new Triforce( x,y, getRandInt());
							break;
                case 4:     retVal = new Circle(x,y,getRandInt(),false);
                            break;
			}
		
			return retVal;
		}
	}	
	
}











