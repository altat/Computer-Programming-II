public class PointDriver {
    public static void main(String[] args){
        Point p = new Point();

        p.publicMethod();
        // p.privateMethod(); //It says 'privateMethod()' has private access in 'Point'

        p.x = 2;
        // p.y = 2;  //It says 'y' has private access in 'Point'
    }
}
