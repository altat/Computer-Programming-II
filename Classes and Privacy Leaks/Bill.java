/*
Name: Tanvir Tatla
File Description: This class represents an outstanding or paid bill. The
class should contain the amount of the bill as a Money object, the due date
of the bill (a Date object) and a Date object to track the date paid (null if
not yet paid).

Class invariants: paidDate will always be before or on the dueDate
dueDate and amount cannot change once there is a paidDate
 */
public class Bill {
    private Money amount;
    private Date dueDate, paidDate;
    private String originator;

    /*
    Constructor that sets the amount of Money, dueDate, and originator
    @param Money amount: the amount of Money in the Bill
    Date dueDate: the date that this bill is due
    String originator: to whom the bill should be paid to
    */
    public Bill(Money amount, Date dueDate, String originator) {
        this.amount = new Money(amount);
        this.dueDate = new Date(dueDate);
        setOriginator(originator);
        this.paidDate = null;
    }

    /*
    Copy Constructor - sets amount, dueDate,originator, and paidDate equal to
    the values of another Bill object's instance variables.
    @param Bill toCopy: object to copy
     */
    public Bill(Bill toCopy) {
        if (toCopy == null) {
            System.err.println("Bill can't be null.");
            System.exit(-1);
        }
        this.amount = toCopy.amount;
        this.dueDate = toCopy.dueDate;
        this.originator = toCopy.originator;
        this.paidDate = toCopy.paidDate;
    }

    /*
    getAmount - getter method that gets amount (Money)
    @Pre TRUE
    @Post returns a new Money copy that is equal to the amount instance variable
     */
    public Money getAmount() {
        return new Money(amount);
    }

    /*
    getDueDate - getter method that gets dueDate
    @Pre TRUE
    @Post returns a copy of dueDate instance variable
     */
    public Date getDueDate() {
        return new Date(dueDate);
    }

    /*
    getOriginator - getter method that gets originator
    @Pre TRUE
    @Post returns a String that has the same value as originator
     */
    public String getOriginator() {
        return originator;
    }

    /*
    isPaid - checks if this Bill has been paid
    @Pre TRUE
    @Post returns true if paidDate is not null
     */
    public boolean isPaid() {
        // if paidDate is not null, then a paidDate exists and therefore this
        // bill has been paid
        if (paidDate != null) return true;
        return false;
    }

    /*
    setPaid - setter method that sets datePaid
    @param Date datePaid: the date that this bill was paid
    @Pre TRUE
    @Post Returns true and sets datePaid if the specified Date is not after
    dueDate. Returns false and does not set datePaid if the specified date is
    after the dueDate
     */
    public boolean setPaid(Date datePaid) {
        // the paidDate can't be after the dueDate
        if (datePaid.isAfter(dueDate)) return false;
        else {
            paidDate = new Date(datePaid);
            return true;
            //return true since the paidDate has successfully been set
        }
    }

    /*
    setDueDate - setter method that sets dueDate
    @param Date nextDate: the new dueDate
    @Pre TRUE
    @Post Returns true and sets dueDate as long as this Bill has not been
    paid. Returns false and does not set dueDate if this Bill has been paid.
     */
    public boolean setDueDate(Date nextDate) {
        // you can't set dueDate if the bill has already been paid
        if (isPaid()) return false;
        else {
            dueDate = new Date(nextDate);
            return true;
        }
    }

    /*
    setAmount - setter method that sets amount
    @param Money amount: the new amount
    @Pre TRUE
    @Post Returns true and sets amount as long as this Bill has not been
    paid. Returns false and does not set amount if this Bill has been paid.
     */
    public boolean setAmount(Money amount) {
        // the bill amount can't change if the bill has been paid
        if (isPaid()) return false;
        else {
            this.amount = new Money(amount);
            return true;
        }
    }

    /*
    setOriginator - setter method that sets originator
    @param String originator: the company that gets paid from this bill
    @Pre TRUE
    @Post sets the originator as long as the given value is not null. Exits
    if it is null.
     */
    public void setOriginator(String originator) {
        // only set originator if the argument passed is not null
        if (originator == null) {
            System.err.println("Originator cannot be null.");
            System.exit(-1);
        }
        this.originator = originator;
    }

    /*
    toString - use this to print a report of this bill
    @Pre TRUE
    @Post returns a String containing the amount due, due date, whom to pay
    (originator), and if this bill has been paid. If it has been paid, then
    also add the paid date.
     */
    @Override
    public String toString() {
        String retVal = "";
        retVal += "Amount due: " + amount + "\n";
        retVal += "Due on: " + dueDate + "\n";
        retVal += "Pay to: " + originator + "\n";
        retVal += "Has been paid: " + isPaid();
        if (isPaid()) retVal += "\nPaid on: " + paidDate;
        return retVal;
    }

    /*
    equals - checks if two Bill instances are equal
    @param Object o: the object to compare with this
    @Pre TRUE
    @Post returns true if they are equal and false if they aren't
     */
    @Override
    public boolean equals(Object toCompare) {
        if (this == toCompare) return true;
        if (toCompare == null || !(toCompare instanceof Bill)) return false;

        Bill that = (Bill) toCompare;

        // if this bill is paid, then compare all instance variables
        if (this.isPaid()) {
            return amount.equals(that.amount)
                    && dueDate.equals(that.dueDate)
                    && originator.equals(that.originator)
                    && paidDate.equals(that.paidDate);
        }

        // if this is not paid but that bill is paid, then they are not equal
        else if (that.isPaid() && !this.isPaid()) {
            return false;
        }

        // if neither is paid, then exclude checking paidDate
        else {
            return amount.equals(that.amount)
                    && dueDate.equals(that.dueDate)
                    && originator.equals(that.originator);
        }
    }
}
