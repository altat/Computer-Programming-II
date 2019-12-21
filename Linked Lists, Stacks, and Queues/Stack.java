/**
 * @author Tanvir Tatla
 *
 * Stack inherits from the List class.
 */
public class Stack extends List{

    /**
     * push - inserts an Object to the top of this Stack
     * @param obj: the Object to push
     */
    public void push(Object obj) {
        super.insert(obj, 0);
    }

    /**
     * pop - removes the object at the top of this Stack.
     * @return returns the Object that was removed.
     */
    public Object pop() {
        try {
            // throw an exception if this Stack is empty
            if(super.isEmpty())
                throw new LinkedListException("Empty Stack");
        } catch (LinkedListException e) {
            System.out.println(e);
        }

        // since this method invokes the remove method from its superclass
        // (List), set invokedByChild to true in order to avoid throwing 2
        // exception.
        setInvokedByChild(true);
        return super.remove(0);
    }

    // overrides the superclass's methods so they cannot be used to do
    // something that Stack's were not meant to do.
    @Override
    public void insert(Object next, int index) {
        this.push(next);
    }

    @Override
    public Object remove(int index) {
        setInvokedByChild(true);
        return this.pop();
    }

    /**
     * main - driver that tests the methods in Stack
     */
    public static void main(String[] args) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        //creates characters for the lists
        Object obj1 = (Character) 't';
        Object obj2 = (Character) 'a';
        Object obj3 = (Character) 'n';
        Object obj4 = (Character) 'v';
        Object obj5 = (Character) 'i';
        Object obj6 = (Character) 'r';

        //inserts the characters in backward so they spell
        //the name correctly
        s1.push(obj6);
        s1.push(obj5);
        s1.push(obj4);

        //tests to make sure that insert and push do the same thing
        s1.insert(obj3, 2);
        s1.push(obj2);
        s1.push(obj1);
        System.out.println(s1.toString());

        //removes half the characters, and checks if pop and remove do the same
        // thing
        s1.pop();
        s1.remove(4);
        System.out.println(s1.pop());

        //remove from empty stack
        s2.pop();

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
