public class Car {
    String make;
    String model;
    int odometer;

    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1.toString());

        Car c2 = new Car();
        System.out.println(c2.toString());
        c2.printThis(); // Both print the same address because 'this' is a reference variable that refers to an object.
                        // In this case, 'this' refers to the object named c2.

        Car c3 = new Car();
        System.out.println(c3);
        System.out.println(c3.toString());

        Car c4 = new Car("Audi");
        c4.printThis();

        Car c5 = new Car("Tesla", "Model S");
        c5.printThis();

        Rectangle r1 = new Rectangle(2, 2, 6,6);
        r1.printMemoryAddress();

        Rectangle r2 = new Rectangle(2,2,6,6);
        System.out.println(r1.equals(r2));
        System.out.println("Ares is " + r2.getArea());
        System.out.println(r2.draw());
    }

    public Car() {

    }

    public Car(String make) {
        this.make = make;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void printThis() {
        System.out.println(this);
    }

    public String toString() {
        return "make: " + this.make + "   model: " + this.model + "   odometer: " + this.odometer ;
    }
}
