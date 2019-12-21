/**
 * @author Tanvir Tatla
 *
 * Queue inherits from the List class.
 */
public class Queue extends List{

    /**
     * enqueue- inserts an Object to the front of this Queue
     * @param obj: the Object to enqueue
     */
    public void enqueue(Object obj) {
        super.insert(obj, 0);
    }

    /**
     * dequeue - removes the object at the end of this Queue.
     * @return returns the Object that was removed.
     */
    public Object dequeue() {
        try {
            // throw an exception if this Queue is empty
            if(super.isEmpty())
                throw new LinkedListException("Empty Queue");
        } catch (LinkedListException e) {
            System.out.println(e);
        }

        // since this method invokes the remove method from its superclass
        // (List), set invokedByChild to true in order to avoid throwing 2
        // exceptions.
        setInvokedByChild(true);
        return super.remove(super.size() - 1);
    }

    // overrides the superclass's methods so they cannot be used to do
    // something that Queue's were not meant to do.
    @Override
    public void insert(Object next, int index) {
        this.enqueue(next);
    }

    @Override
    public Object remove(int index) {
        setInvokedByChild(true);
        return this.dequeue();
    }

    /**
     * main - driver that tests the methods in Queue
     */
    public static void main(String[] args) {
        Queue q1 = new Queue();
        Queue q2 = new Queue();

        //creates characters for the lists
        Object obj1 = (Character) 't';
        Object obj2 = (Character) 'a';
        Object obj3 = (Character) 'n';
        Object obj4 = (Character) 'v';
        Object obj5 = (Character) 'i';
        Object obj6 = (Character) 'r';

        //inserts the characters in backward so they spell
        //the name correctly
        q1.enqueue(obj6);
        q1.enqueue(obj5);
        q1.enqueue(obj4);

        //tests to make sure that insert and enqueue do the same thing
        q1.insert(obj3, 2);
        q1.enqueue(obj2);
        q1.enqueue(obj1);
        System.out.println(q1.toString());

        //removes half the characters, and checks if remove and dequeue do
        // the same thing
        q1.dequeue();
        q1.remove(0);
        System.out.println(q1.dequeue());

        //remove from empty queue
        q2.dequeue();

        System.out.println(q1.toString());
        System.out.println(q2.toString());
    }
}
