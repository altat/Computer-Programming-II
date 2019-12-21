import java.util.Arrays;

public class ObjectList {
    private Object[] myObjects = new Object[100];
    private int numElements = 0;

    /*
    add - adds an Object to the end of this list
    @param newElement = Object that you want to add to myObjects array
    @Pre TRUE
    @Post appends the specified element to the end myObjects class variable
    */
    public void add(Object newElement) {
        if (myObjects.length < numElements + 1) {
            resizeList();
        }
        myObjects[numElements++] = newElement;
    }

    /*
    getLength - gets the number of elements in this list
    @Pre TRUE
    @Post returns numElements class variable
    */
    public int getLength() {
        return numElements;
    }

    /*
    get - gets the element at the specified index of this list
    @param index = int that represents the index of an array
    @Pre TRUE
    @Post returns the FractionCounter at the specified index
    */
    public FractionCounter get(int index) {
        return (FractionCounter) myObjects[index];
    }

    /*
    resizeList - makes the array myObjects class variable 50% bigger
    @Pre TRUE
    @Post sets myObjects class variable to a new larger array with all of the
    elements of the old array
    */
    private void resizeList() {
        int oldSize = myObjects.length;
        int newSize = oldSize + (oldSize / 2);
        myObjects = Arrays.copyOf(myObjects, newSize);
    }

    /*
    toString - puts each element in this list into a String
    @Pre TRUE
    @Post returns a String containing each element separated by a line
    */
    @Override
    public String toString() {
        String retVal = "";
        // loop over the number of elements in myObjects
        for (int i = 0; i < numElements; i++) {
            retVal += myObjects[i] + "\n";
        }
        return retVal;
    }
}
