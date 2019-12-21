/**
 Name: Tanvir Tatla
 File Description: This class is like ArrayList except it only accepts Bills.
 It extends ArrayList
 */
public class ExpenseAccount extends ArrayList{

    /**
     add - adds an Object to the end of this list
     @param obj: Bill that you want to add to ExpenseAccount
     @Pre TRUE
     @return appends the specified element to the end of this list
     */
    public void add(Object obj) {
        if(this.check(obj))
            super.add(obj);
        else
            System.out.println("Not a valid bill");
    }

    /**
    insert - places an object at the specified index
    @param obj: the Bill you want to insert
    @param index: the index you want to place the object at
    @Pre TRUE
    @return Inserts the specified element at the specified position in this
    list. Shifts the element currently at that position and any subsequent
    elements to the right
     */
    public void insert(Object obj, int index) {
        if(this.check(obj))
            super.insert(obj, index);
        else
            System.err.println("Not a valid bill");
    }

    /**
     remove - Removes the element at the specified position in this list.
     Shifts any subsequent elements to the left
     @param index: the position of the element to be removed
     @Pre TRUE
     @return returns the Bill that was removed from the list
     */
    public Bill remove(int index){
        return (Bill) super.remove(index);
    }

    /**
     size - gets the number of elements in this list
     @Pre TRUE
     @return returns numElements class variable
     */
    public int size() {
        return super.size();
    }

    /**
     toString - puts each element in this list into a String
     @Pre TRUE
     @return  returns a String containing each element inside curly brackets and
     separated by commas and a space.
     */
    public String toString() {
        return super.toString();
    }

    /**
     isEmpty - checks if the ExpenseAccount is empty or not
     @Pre TRUE
     @return returns true if this list contains no elements
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     get - gets the element at the specified index of this list
     @param index: int that represents the index of an array
     @Pre TRUE
     @return returns the Bill at the specified index
     */
    public Bill get(int index) {
        return (Bill) super.get(index);
    }

    /**
     equals - used for when you want to check if two ExpenseAccounts contain
     the same elements
     @param other: the object you want to compare this ExpenseAccount to
     @Pre TRUE
     @return returns true if the specified object is equal to this list
     */
    public boolean equals(Object other) {
        // if the object is null or not an ExpenseAccount, then they aren't
        // equal
        if (other == null || !(other instanceof ExpenseAccount)) return false;
        ExpenseAccount that = (ExpenseAccount) other;

        // if both lists are the same size, but the elements at every indices
        // don't match, then they are not equal
        if (this.size() == that.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i) != that.get(i)) return false;
            }
        }
        // if both lists aren't the same size, then they are not equal
        else if (this.size() != that.size()) return false;

        // if this method hasn't returned false yet, then they must be equal
        return true;
    }

    /**
     * check - Checks if the specified object is an instance of a Bill
     * @param obj: the object to check
     * @return true if the object is a Bill and false if it is not
     */
    public boolean check(Object obj) {
        return(obj != null && obj instanceof Bill);
    }
}
