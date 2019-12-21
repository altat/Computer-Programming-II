import java.util.Iterator;

/**
Name: Tanvir Tatla
File Description: This class is an ArrayList-like interface. It is supposed
to function like the built-in ArrayList class.
 */
public class ArrayList implements Iterable{
    private Object[] myObjects = new Object[100];
    private int numElements = 0;

    /**
    add - adds an Object to the end of this list
    @param newElement: Object that you want to add to myObjects array
    @Pre TRUE
    @Post appends the specified element to the end of myObjects class variable
    */
    public void add(Object newElement) {
        // if myObjects isn't big enough for another element
        if (numElements + 1 >= myObjects.length) {
            // make myObjects bigger
            resizeList();
        }
        myObjects[numElements++] = newElement;
    }

    /**
    insert - places an object at the specified index
    @param object: the object you want to insert  index = the index you want
     to place the object at
    @Pre TRUE
    @Post Inserts the specified element at the specified position in this list.
    Shifts the element currently at that position and any subsequent elements
    to the right
     */
    public void insert(Object object, int index) {
        // index cannot be less than 0 or greater than this list's size
        if (index > numElements || index < 0) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }

        // if list isn't big enough for another element
        if (numElements + 1 >= myObjects.length) {
            // make list bigger
            resizeList();
        }

        // Shifts the element currently at that position and any subsequent
        // element to the right
        for (int i = index; i < numElements; i++) {
            myObjects[i + 1] = myObjects[i];
        }
        myObjects[index] = object;
        numElements++;
    }

    /**
    remove - Removes the element at the specified position in this list.
    Shifts any subsequent elements to the left
    @param index: the position of the element to be removed
    @Pre TRUE
    @Post returns the object that was removed from the list
     */
    public Object remove(int index) {
        Object value = myObjects[index];

        // index cannot be greater than list's size or less than zero
        if (index > numElements - 1 || index < 0) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }

        // Shifts any subsequent elements of the removed element to the left
        for (int i = index; i < numElements; i++) {

            // if the subsequent element's index is bigger than this list's
            // length, then make this list bigger
            if (i + 1 >= myObjects.length) resizeList();

            myObjects[i] = myObjects[i+1];
        }

        numElements--;
        return value;
    }

    /**
    size - gets the number of elements in this list
    @Pre TRUE
    @Post returns numElements class variable
    */
    public int size() {
        return numElements;
    }

    /**
    toString - puts each element in this list into a String
    @Pre TRUE
    @Post returns a String containing each element inside curly brackets and
    separated by commas and a space.
    */
    @Override
    public String toString() {
        String retVal = "{";

        // if list isn't empty then add elements to String retVal
        if (!this.isEmpty()) {
            // fencepost loop
            // add initial "post" (loop and a half)
            retVal += myObjects[0];

            // place wire and post
            for (int i = 1; i < numElements; i++) {
                retVal += ", " + myObjects[i];
            }
        }
        retVal += "}";
        return retVal;
    }

    /**
    isEmpty - checks if the ArrayList is empty or not
    @Pre TRUE
    @Post returns true if this list contains no elements
     */
    public boolean isEmpty() {
        if (this.size() > 0) {
            return false;
        }
        return true;
    }

    /**
    indexOf - tells you the index of the specified object
    @param object: the object you want to know the index of
    @Pre TRUE
    @Post returns the index of the first occurrence of the specified element
    in the list. returns -1 if the object was not found in this list.
     */
    public int indexOf(Object object) {
        int index = -1;

        // searches each index of list until it finds a match
        for (int i = 0; i < numElements; i++) {
            if (myObjects[i] == object) {
                // sets index when it finds the matching object
                index = i;
            }
        }
        return index;
    }

    /**
    get - gets the element at the specified index of this list
    @param index: int that represents the index of an array
    @Pre TRUE
    @Post returns the FractionCounter at the specified index
    */
    public Object get(int index) {
        // index can't be less than zero or greater than list's size
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        return myObjects[index];
    }

    /**
    equals - used for when you want to print the elements in this list
    @param other: the object you want to compare this list to
    @Pre TRUE
    @Post returns true if the specified object is equal to this list
     */
    public boolean equals(Object other) {
        // if the object is null or not an ArrayList, then they aren't equal
        if (other == null || !(other instanceof ArrayList)) return false;
        ArrayList that = (ArrayList) other;

        // if both lists are the same size, but the elements at every indices
        // don't match, then they are not equal
        if (this.size() == that.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (myObjects[i] != that.myObjects[i]) return false;
            }
        }
        // if both lists aren't the same size, then they are not equal
        else if (this.size() != that.size()) return false;

        // if this method hasn't returned false yet, then they must be equal
        return true;
    }

    /**
    resizeList - makes the array myObjects class variable 50% bigger
    @Pre TRUE
    @Post sets myObjects class variable to a new larger array with all of the
    elements of the old array
    */
    private void resizeList() {
        int oldSize = myObjects.length;
        int newSize = oldSize + (oldSize / 2);
        // create a temporary array that is 50% bigger than myObjects
        Object[] tempArr = new Object[newSize];

        // Copy each element of myObjects to the temporary array
        for (int i = 0; i < numElements; i++) {
            tempArr[i] = myObjects[i];
        }

        // set myObjects equal to the temporary array
        myObjects = tempArr;
    }

    /**
     * iterator - creates and returns a new arrayIterator
     * @return returns a new arrayIterator
     */
    public Iterator<Object> iterator() {
        return new arrayIterator();
    }

    /**
     * This class is to allow ArrayList and its children to implement Iterable
     */
    protected class arrayIterator implements Iterator {
        protected int iteration = 0;

        /**
         * hasNext - checks if there is another element in the list
         * @return true if there is another element and false if there is not
         */
        public boolean hasNext() {
            return iteration < ArrayList.this.size();
        }

        /**
         * next - gets the next object in the list
         * @return returns the next object in the list
         */
        public Object next() {
            return myObjects[iteration++];
        }
    }
}
