/*
Name: Tanvir Tatla
File Description: This class is an FIFO Queue interface. It is supposed to
act like the built in Queue class. This class is built off of the
ArrayList-like interface.
 */
public class Queue {
    ArrayList queue = new ArrayList();

    /*
    enqueue - adds an Object to the end of this queue
    @param object = Object that you want to add to this queue
    @Pre TRUE
    @Post appends the specified element to the end of this queuee
    */
    public void enqueue(Object object) {
        queue.add(object);
    }

    /*
    dequeue - Retrieves and removes the head of this queue
    @Pre TRUE
    @Post returns the head of this queue
     */
    public Object dequeue() {
        return queue.remove(0);
    }

    /*
    size - gets the number of elements in this queue
    @Pre TRUE
    @Post returns the number of elements in this queue
    */
    public int size() {
        return queue.size();
    }

    /*
    toString - used for when you want to print the elements in this queue
    @Pre TRUE
    @Post returns a String containing each element inside curly brackets and
    separated by commas and a space.
    */
    public String toString() {
        return queue.toString();
    }

    /*
    isEmpty - checks if this Queue is empty or not
    @Pre TRUE
    @Post returns true if this queue contains no elements
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /*
    equals - checks if an object is equal to this queue
    @param object = the object you want to compare this queue to
    @Pre TRUE
    @Post returns true if the specified object is equal to this queue
     */
    public boolean equals(Object object) {
        // if the object is null or not a Queue, then they aren't equal
        if (object == null || !(object instanceof Queue)) return false;
        Queue that = (Queue) object;

        // if both queues are the same size, but the elements at every indices
        // don't match, then they are not equal
        if (this.size() == that.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (!queue.equals(that.queue)) return false;
            }
        }
        // if both queues aren't the same size, then they are not equal
        else if (this.size() != that.size()) return false;

        // if this method hasn't returned false yet, then they must be equal
        return true;
    }
}
