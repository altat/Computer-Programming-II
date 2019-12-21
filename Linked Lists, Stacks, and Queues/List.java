/**
 * @author Tanvir Tatla
 *
 * List is a linked list class (it uses Nodes and references).
 */
public class List {
    private Node head;
    private boolean invokedByChild = false;

    private class Node {
        private Object data;
        private Node next;

        public Node(){
            data = null;
            next = null;
        }

        public Node (Object obj, Node n) {
            data = obj;
            next = n;
        }
    }

    /**
     * insert - inserts a Object to this List at the specified index.
     * @param next: the object to add.
     * @param index: the index at which the object should be added.
     */
    public void insert(Object next, int index) {
        // if the list is empty, then set the head
        if (head == null) {
            head = new Node(next, null);
        }

        // if the list has one element
        else if (head.next == null) {
            // and if the index is zero, then store head in a temp Node and
            // set head as the new object and have it point to the old head
            if (index == 0) {
                Node temp = head;
                head = new Node(next, temp);
            }
            // otherwise set the Node after head with the new Object
            else
                head.next = new Node(next, null);
        }

        // if there are two or more elements in this List
        else if (head.next != null) {
            Node current = head;

            // iterate over each element until you get to the Node one index
            // ahead of where you want to insert.
            for (int i = 0; i < index - 1; i++) {
                // if the next Node is null, then you have reached the end of
                // this List and you can exit this loop.
                if (current.next == null)
                    break;
                current = current.next;
            }

            // if the index is zero then just set the head and have it point
            // to the old head.
            if (index == 0) {
                head = new Node(next, current);
            }
            // otherwise create a copy of the next Node and set the next node
            // to the new Object and have it point to the copy of the old
            // next Node.
            else {
                Node temp = current.next;
                current.next = new Node(next, temp);
            }
        }
    }

    /**
     * Removes an object from this List at the specified index.
     * @param index: the index of the object to remove
     * @return returns the removed Object
     */
    public Object remove(int index) {
        // create an empty Node that will store a copy of the removed Node
        Node copy = new Node();

        // if this List is empty
        if (head == null){
            try {
                // then throw an exception if remove was not invoked by a
                // subclass
                if (!invokedByChild)
                    throw new LinkedListException("Empty List");
            } catch (LinkedListException e) {
                System.out.println(e);
            }
        }

        // if this List has one element
        else if (head.next == null) {
            // if the index is zero (head needs to be removed)
            if (index == 0) {
                // make a copy of the head and then set head to null
                copy = head;
                head = null;
            }
        }

        // if there is two or more elements in this List
        else if (head.next != null) {
            Node current = head;

            // if the index is NOT past the size of this List
            if (!(index > size() - 1)) {

                // iterate over the elements until you get to the element one
                // space ahead of the one you want to remove
                for (int i = 0; i < index - 1; i++) {
                    // if the next Node is null, then exit the loop because you
                    // have reached the tail of this List
                    if (current.next == null) {
                        break;
                    }
                    current = current.next;
                }


                // if the head needs to be removed, then make a copy and remove head
                if (index == 0) {
                    copy = head;
                    head = head.next;
                }
                // otherwise make a copy of the next node and overwrite the next
                // Node as the next next Node.
                else {
                    copy = current.next;
                    current.next = current.next.next;
                }
            } else {
                try {
                    throw new LinkedListException("Index is greater than List " +
                            "size.");
                } catch (LinkedListException e) {
                    System.out.println(e);
                }
            }
        }

        return copy.data;
    }

    /**
     * size - counts the number of elements currently in this List.
     * @return returns the size of this List.
     */
    public int size() {
        int size = 0;
        Node current = head;

        // while the current Node is not null
        while (current != null) {
            // add one to size and move to the next Node
            size++;
            current = current.next;
        }

        return size;
    }

    /**
     * toString - places the objects in this List into a string and separates
     * them with commas and spaces.
     * @return returns a string consisting of the objects in this List.
     */
    @Override
    public String toString() {
        String retVal = "{";
        Node current = head;

        // while the current Node is not null
        while (current != null) {
            // if the current Node is the head, then add it to the string and
            // move to the next iteration of the loop
            if (current == head) {
                retVal += current.data.toString();
                current = current.next;
                continue;
            }

            // add the current Node's data and set the next Node to current
            retVal += ", " + current.data.toString();
            current = current.next;
        }

        retVal += "]";
        return retVal;
    }

    /**
     * isEmpty - checks to see if this List is empty
     * @return returns true if it is empty and false if it is not.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * indexOf - tells you the index of an Object
     * @param target: the Object to search for
     * @return returns the index of the target Object. returns -1 if the
     * target does not exist.
     */
    public int indexOf(Object target) {
        int index = 0;
        Node current = head;

        // while current is not null
        while (current != null) {
            // if a match is found, then return the value of index
            if (current.data.equals(target))
                return index;

            // otherwise add one to index and set the next Node to current
            else {
                index++;
                current = current.next;
            }
        }

        // return -1 if not found
        return -1;
    }

    /**
     * append - appends an Object to the end of this list.
     * @param obj: the Object to add.
     */
    public void append(Object obj) {
        int index = size();
        insert(obj, index);
    }

    /**
     * setInvokedByChild - sets the invokedByChild instance variable
     * @param invokedByChild: set this as true in a child class method if the
     *                      child class method uses the remove method from this
     *                      class.
     */
    protected void setInvokedByChild(boolean invokedByChild) {
        this.invokedByChild = invokedByChild;
    }

    /**
     * main - driver that tests the methods in List
     */
    public static void main(String[] args) {
        List l1 = new List();
        List l2 = new List();
        List l3 = new List();

        //creates characters for the lists
        Object object1 = (Character) 't';
        Object object2 = (Character) 'a';
        Object object3 = (Character) 'n';
        Object object4 = (Character) 'v';
        Object object5 = (Character) 'i';
        Object object6 = (Character) 'r';

        //adds characters to the list in careful order
        //so that if the methods are correct,
        //the name will be spelled correct
        l1.insert(object2, 1);
        l1.insert(object1, 0);
        l1.insert(object4, 3);
        l1.insert(object3, 2);
        l1.insert(object5, 10);
        l1.insert(object6, 5);
        System.out.println(l1.toString());
        System.out.println();

        //adds characters to the next list
        l2.insert(object1, 0);
        l2.insert(object2, 1);
        l2.insert(object3, 2);
        System.out.println(l2.toString());

        //removes from l3 empty list and body of l2
        l3.remove(6);
        l2.remove(1);
        System.out.println(l2.toString());

        //tries removing past the size of l2
        l2.remove(50);

        l2.remove(0);
        l2.remove(0);
        l2.remove(0);

        //checks size, isEmpty, and indexOf
        System.out.println(l1.size());
        System.out.println(l2.size());
        System.out.println(l1.isEmpty());
        System.out.println(l2.isEmpty());
        System.out.println(l1.indexOf('v'));
        System.out.println(l1.indexOf('t'));
        System.out.println(l1.indexOf('q'));

        //appends five objects to the end for "train"
        l3.append(object1);
        l3.append(object6);
        l3.append(object2);
        l3.append(object5);
        l3.append(object3);
        System.out.println(l3.toString());
    }
}
