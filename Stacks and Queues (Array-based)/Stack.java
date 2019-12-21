/*
Name: Tanvir Tatla
File Description: This class is an LIFO Stack interface. It is supposed to
act like the built in Stack class. This class is built off of the
ArrayList-like interface.
 */
public class Stack {
    ArrayList stack = new ArrayList();

    /*
    push - pushes an object to the top of this stack
    @param object = Object that you want to add to this stack
    @Pre TRUE
    @Post pushes the specified element to the top of this stack
    */
    public void push(Object object) {
        stack.add(object);
    }

    /*
    pop - Removes the object at the top of this stack
    @Pre TRUE
    @Post returns the object at the top of this stack
     */
    public Object pop() {
        int lastIndex = size() - 1;
        return stack.remove(lastIndex);
    }

    /*
    size - gets the number of elements in this stack
    @Pre TRUE
    @Post returns the number of elements in this stack
    */
    public int size() {
        return stack.size();
    }

    /*
    toString - used for when you want to print the elements in this stack
    @Pre TRUE
    @Post returns a String containing each element inside curly brackets and
    separated by commas and a space.
    */
    public String toString() {
        return stack.toString();
    }

    /*
    isEmpty - checks if this Stack is empty or not
    @Pre TRUE
    @Post returns true if this stack contains no elements
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /*
    equals - checks if an object is equal to this queue
    @param object = the object you want to compare this queue to
    @Pre TRUE
    @Post returns true if the specified object is equal to this queue
     */
    public boolean equals(Object other) {
        // if the object is null or not a Stack, then they aren't equal
        if (other == null || !(other instanceof Stack)) return false;
        Stack that = (Stack) other;

        // if both stacks are the same size, but the elements at every indices
        // don't match, then they are not equal
        if (this.size() == that.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (!stack.equals(that.stack)) return false;
            }
        }
        // if both stacks aren't the same size, then they are not equal
        else if (this.size() != that.size()) return false;

        // if this method hasn't returned false yet, then they must be equal
        return true;
    }
}
