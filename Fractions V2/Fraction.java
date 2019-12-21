/*
Name: Tanvir Tatla
File Description: This class is a simple abstractions that represents the
ratio of two numbers. It stores the fractions in reduced form.
 */
public class Fraction {
    private int numerator, denominator;

    public Fraction() {
    }

    /*
    constructor that calls setReducedFraction method
     */
    public Fraction(int numerator, int denominator) {
        setReducedFraction(numerator, denominator);
    }

    /*
    getNumerator - Getter method for numerator
    @Pre TRUE
    @Post returns numerator class variable
    */
    public int getNumerator() {
        return numerator;
    }

    /*
    setNumerator - Setter method for numerator
    @param numerator = int that represents first number of ratio
    @Pre TRUE
    @Post sets numerator class variable
    */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /*
    getDenominator - Getter method for denominator
    @Pre TRUE
    @Post returns denominator class variable
    */
    public int getDenominator() {
        return denominator;
    }

    /*
    setDenominator - Setter method for denominator
    @param denominator = int that represents second number of ratio
    @Pre TRUE
    @Post sets denominator class variable
    */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /*
    equals - compares two fractions to see if their ratios are equal
    @param other = other Fraction object to compare 'this' with
    @Pre TRUE
    @Post returns true if the ratios are equal and false if they are not
    */
    public boolean equals(Fraction other) {
        boolean isEqual = false;
        if (this.denominator == other.denominator && this.numerator ==
                other.numerator) {
            isEqual = true;
        }
        return isEqual;
    }

    /*
    toString - converts the class variables into a String
    @Pre TRUE
    @Post returns ratio as a string in format A/B
    */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /*
    findGCD - finds the greatest common divisor of two numbers
    @param two ints that represent the numerator and denominator of the ratio
    @Pre TRUE
    @Post returns an int that represents the greatest common divisor of the
    numerator and denominator
    */
    private int findGCD(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        } else {
            return findGCD(denominator, numerator % denominator);
        }
    }

    /*
    setReducedFraction - reduces a ratio
    @param the numerator and denominator of the fraction
    @Pre TRUE
    @Post sets the class variables numerator and denominator to their reduced
     forms
    */
    private void setReducedFraction(int numerator, int denominator) {
        int gcd = findGCD(numerator, denominator);
        this.numerator = (numerator / gcd);
        this.denominator = (denominator / gcd);
    }
}
