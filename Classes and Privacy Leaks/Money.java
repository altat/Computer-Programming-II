/*
Name: Tanvir Tatla
File Description: This class represents US Money as two integers (Money and
cents).
Class invariants: Cents can never be greater than 99.
All amounts will be positive or zero.
 */
public class Money {
    private int dollars = 0,
            cents = 0;

    /*
    no-arg, empty Constructor
     */
    public Money() {
    }

    /*
    Constructor that sets dollars to specified value and cents to zero.
    dollars can't be less than zero.
    @param dol: int value for setting dollars
     */
    public Money(int dol) {
        setMoney(dol,0);
    }

    /*
    Constructor that sets dollars and cents to specified values. Dollars and
    cents can't be less than zero.
    @param dol: int value for setting dollars
    cents: int value for setting cents
     */
    public Money(int dol, int cent) {
        setMoney(dol, cent);
    }

    /*
    Copy Constructor - sets dollars and cents equal to the value of
    another Money object's instance variables.
    @param other: Money object to copy
     */
    public Money(Money other) {
        if (other == null) {
            System.err.println("Money can't be null");
            System.exit(-1);
        }
        dollars = other.dollars;
        cents = other.cents;
    }

    /*
    getDollars - getter method that returns dollars.
    @Pre TRUE
    @Post returns dollars instance variable
     */
    public int getDollars() {
        return dollars;
    }

    /*
    getCents - getter method that returns cents
    @Pre TRUE
    @Post returns cents instance variable
    */
    public int getCents() {
        return cents;
    }

    /*
    setMoney - setter method to set the dollars and cents. if cents is
    greater than 99, this method reduces cents until it is 99 or less by
    adding to dollars.
    @param dollars: int value to set dollars to
    cents: int value to set cents to
    @Pre True
    @Post sets dollars and cents instance variables. cents will never be
    greater than 99. dollars and cents can't be less than zero.
     */
    public void setMoney(int dollars, int cents) {
        checkMoney(dollars, cents);
        this.dollars = dollars;

        // if cents is GT 99, then reduce cents
        if (cents > 99) {
            //divide the value by 100, giving you the integer value and no
            // remainder (dollars)
            int tempDollars = (cents / 100);
            //take modulus 100 of the value, giving you the remainder
            // value (cents)
            int tempCents = (cents % 100);

            this.dollars += tempDollars;
            this.cents = tempCents;
        } else {
            this.cents = cents;
        }
    }

    /*
    getMoney - getter method for the total money amount
    @Pre TRUE
    @Post returns a double that represents the total dollars and cents
     */
    public double getMoney() {
        double dollars = this.dollars;
        double cents = this.cents;

        // divide cents by 100 to get decimal
        return dollars + (cents / 100);
    }

    /*
    add - adds dollars to an instance of Money
    @param int dollars: the amount of dollars to add
    @Pre TRUE
    @Post adds the specified amount of dollars with the current dollars of this
    */
    public void add(int dollars) {
        checkDollars(dollars);
        this.dollars += dollars;
    }

    /*
    add - adds dollars and cents to an instance of Money
    @param int dollars: the amount of dollars to add
    int cents: the amount of cents to add
    @Pre TRUE
    @Post adds the specified amount of dollars and cents to the current dollars
    and cents .reduces cents.
    */
    public void add(int dollars, int cents) {
        checkMoney(dollars, cents);
        int newDollars = this.dollars + dollars;
        int newCents = this.cents + cents;

        setMoney(newDollars, newCents);
    }

    /*
add - adds instance variable values of another Money object to this
@param Money other: the object to add
@Pre TRUE
@Post adds the instance variables of other to the instance variables of this
*/
    public void add(Money other) {
        // add if other money is not null
        if (other != null) {
            add(other.dollars, other.cents);
        }

        // exit if other money is null
        else {
            System.err.println("Money cannot be null.");
            System.exit(-1);
        }
    }

    /*
    equals - checks if two Money instances are equal
    @param Object o: the object to compare with this
    @Pre TRUE
    @Post returns true if they are equal and false if they aren't
     */
    @Override
    public boolean equals(Object o) {
        //if they have the same addresses, they are equal
        if (this == o) return true;

        //if o is null or not an instance of Money, they are not equal
        if (o == null || !(o instanceof Money)) return false;

        Money money = (Money) o;
        return dollars == money.dollars && cents == money.cents;
    }

    /*
    toString - used to print a Money object as a String
    @Pre TRUE
    @Post returns a String in the form of $X.XX
     */
    @Override
    public String toString() {
        return String.format("$%.2f", getMoney());
    }

    /*
    checkDollars - checks if the specified dollar amount is valid
    @param int dol: the dollar amount
    @Pre TRUE
    @Post Exits if dol is less than zero
     */
    private void checkDollars(int dol) {
        if (dol < 0) {
            System.err.println("Dollars can't be less than zero.");
            System.exit(-1);
        }
    }

    /*
    checkCents - checks if the specified cent amount is valid
    @param int cent: the cent amount
    @Pre TRUE
    @Post Exits if cent is less than zero
     */
    private void checkCents(int cent) {
        if (cent < 0) {
            System.err.println("Cents can't be less than zero.");
            System.exit(-1);
        }
    }

    /*
    checkMoney - checks if the specified dollars and cents amount is valid
    @param int dol: the dollar amount
    int cent: the cent amount
    @Pre TRUE
    @Post Exits if dol and/or cent is less than zero
     */
    private void checkMoney(int dol, int cent) {
        checkDollars(dol);
        checkCents(cent);
    }
}
