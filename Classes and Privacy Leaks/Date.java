/*
Name: Tanvir Tatla
File Description: This class represents a date in our world.
Class invariants: All days days should be between [1-31]
Each month should be between [1-12]
Each month has exactly 31 days
All years should be between [2014 – 2024]
Entering an invalid date should print an error message to the console, and
the program should immediately exit.
 */
public class Date {
    private int month, day, year;

    /*
    Constructor that sets the month, day and year. Does not accept invalid values
    @param int month: a number representation of month (1-12)
    int day: a number representation of day
    int year: a number representation of year
    */
    public Date(int month, int day, int year) {
        setDate(month, day, year);
    }

    /*
    Copy Constructor - sets month, day, and year equal to the values of another
    Date object's instance variables.
    @param other: Date object to copy
     */
    public Date(Date other) {
        if (other == null) {
            System.err.println("Date can't be null.");
            System.exit(-1);
        }
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    /*
    getYear - getter method that gets year
    @Pre TRUE
    @Post returns year instance variable
     */
    public int getYear() {
        return year;
    }

    /*
    getMonth - getter method that gets month
    @Pre TRUE
    @Post returns month instance variable
     */
    public int getMonth() {
        return month;
    }

    /*
getDay - getter method that gets day
@Pre TRUE
@Post returns day instance variable
 */
    public int getDay() {
        return day;
    }

    /*
    setYear - setter method that sets year
    @param int year: 4 digit year (2014-2024)
    @Pre TRUE
    @Post sets the year if a valid year is entered
     */
    public void setYear(int year) {
        // if year is valid, then set it
        if (checkYear(year)) {
            this.year = year;
        } else {
            System.exit(-1);
        }
    }

    /*
    setMonth - setter method that sets month
    @param int month: 1 or 2 digit month (1-12 or 01-12)
    @Pre TRUE
    @Post sets the month if a valid month is entered
     */
    public void setMonth(int month) {
        // if month is valid then set it
        if (checkMonth(month)) {
            this.month = month;
        } else {
            System.exit(-1);
        }
    }

    /*
    setDay - setter method that sets day
    @param int day: 1 or 2 digit day  (1-31 or 01-31)
    @Pre TRUE
    @Post sets the day if a valid day is entered
     */
    public void setDay(int day) {
        //if day is valid then set it
        if (checkDay(day)) {
            this.day = day;
        } else {
            System.exit(-1);
        }
    }

    /*
    setDate - setter method that sets the entire date
    @param int month: 1 or 2 digit month
    int day: 1 or 2 digit day
    int year 4 digit year
    @Pre TRUE
    @Post sets the date if valid ints are given
     */
    public void setDate(int month, int day, int year) {
        // if every value is valid, then set them
        if (checkDate(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        } else {
            System.exit(-1);
        }
    }

    /*
    isAfter - checks if this is after the specified date
    @param Date compareTo: the date to compare this with
    @Pre TRUE
    @Post returns true if this is after or the same as the specified date and
    false otherwise
     */
    public boolean isAfter(Date compareTo) {
        if (compareTo == null) {
            System.err.println("Date can't be null.");
            System.exit(-1);
        }

        // if compareTo has a greater year, then this is not after
        if (this.year < compareTo.year) return false;

        // if the years are the same but compareTo has a greater month, then
        // it's not after
        else if (this.year == compareTo.year && this.month < compareTo.month)
            return false;

        // if the year and month are the same but this' day is less than
        // compareTo's day, then this is not after
        else if (this.year == compareTo.year && this.month == compareTo.month
                && this.day < compareTo.day) return false;

        // this is after compareTo if the above conditions were not met
        else return true;
    }

    /*
    equals - checks if two Date instances are equal
    @param Object o: the object to compare with this
    @Pre TRUE
    @Post returns true if they are equal and false if they aren't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Date)) return false;

        Date date = (Date) o;
        return month == date.month && day == date.day && year == date.year;
    }

    /*
    toString - used to print a Date object as a String
    @Pre TRUE
    @Post returns a String in the form of MM/DD/YYYY
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    /*
    checkMonth - checks if the specified month is valid
    @param int month: number of the month
    @Pre TRUE
    @Post Exits if month is not between 1 and 12, inclusive
     */
    private boolean checkMonth(int month) {
        if (month < 1 || month > 12) {
            System.err.println("The month must be between 1 and 12.");
            return false;
        }

        return true;
    }

    /*
    checkDay - checks if the specified day is valid
    @param int day: number of the day
    @Pre TRUE
    @Post Exits if day is not between 1 and 31, inclusive
     */
    private boolean checkDay(int day) {
        if (day < 1 || day > 31) {
            System.err.println("The day must be between 1 and 31.");
            return false;
        }

        return true;
    }

    /*
    checkYear - checks if the specified year is valid
    @param int year: number of the year
    @Pre TRUE
    @Post Exits if year is not between 2014-2024, inclusive
     */
    private boolean checkYear(int year) {
        if (year < 2014 || year > 2024) {
            System.err.println("The year must be between 2014 and 2024.");
            return false;
        }

        return true;
    }

    /*
    checkDate - checks if the specified Date is valid
    @param int month: number of the month
    int day: number of the day
    int year: number of the year
    @Pre TRUE
    @Post Exits if the month, day, and/or year does not follow the class
    invariants. Prints an error message for each invalid value.
     */
    private boolean checkDate(int month, int day, int year) {
        boolean isValid = true;
        if (!checkMonth(month)) isValid = false;
        if (!checkDay(day)) isValid = false;
        if (!checkYear(year)) isValid = false;
        return isValid;
    }
}
