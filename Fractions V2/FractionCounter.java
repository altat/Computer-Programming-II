/*
Name: Tanvir Tatla
File Description: This class stores a reference to a Fraction object and a
count of how many times this fraction object has been seen in the input file.
 */
public class FractionCounter {
    private Fraction fraction;
    private int count = 1;

    /*
    constructor that takes in a fraction object and sets the fraction class
    variable equal to that object
     */
    public FractionCounter(Fraction fraction) {
        this.fraction = fraction;
    }

    /*
    compareAndIncrement - compares a Fraction object to the class Fraction
    object and checks if they equal. If they are equal, it adds one to count.
    @param newFraction = other Fraction object
    @Pre TRUE
    @Post returns true and adds 1 to count class variable if both Fraction
     objects are equal or returns false if they are not equal
    */
    public boolean compareAndIncrement(Fraction newFraction) {
        boolean isEqual = false;
        if (fraction.equals(newFraction)) {
            isEqual = true;
            count++;
        }
        return isEqual;
    }

    /*
    toString - tells you the count of a fraction in the input file
    @Pre TRUE
    @Post returns the fraction and count as a String
    */
    @Override
    public String toString() {
        return fraction + " has a count of " + count;
    }
}
