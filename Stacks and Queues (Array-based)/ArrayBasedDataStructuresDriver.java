/*
 *  Name: Tanvir Tatla
 *  Driver for ArrayList(ArrayList), Stack and Queue
 */
public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		//stackTests();
		//queueTests();
		arrayListTests();
	}

	/*
	arrayListTests tests every substantive method of ArrayList
	 */
	private static void arrayListTests() {
		//todo: make more tests here
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList();

		try {
			a.insert('B', 0);
			a.insert('a',0);
			a.insert('t',1);

			b.insert('B', 0);
			b.insert('a',0);
			b.insert('t',1);

			b.insert('H', 500);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(a.toString());
		System.out.println("The size of a is " + a.size());
		System.out.println("The index of t is " + a.indexOf('t'));
		System.out.println("The index of H is " + a.indexOf('H'));
		System.out.println("The object at index 2 is " + a.get(2));
		System.out.println("Are a and b equal?  " + a.equals(b));

		while(a.isEmpty() == false) {
			System.out.println(a.remove(0));
		}

		try {
			b.remove(500);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	queueTests tests every substantive method of Queue
	 */
	private static void queueTests() {
		//todo: make more tests here
		Queue a = new Queue();
		Queue b = new Queue();

		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');

		b.enqueue('B');
		b.enqueue('a');
		b.enqueue('t');

		System.out.println(a.toString());
		System.out.println("The size of b is " + b.size());
		System.out.println("Is a empty?  " + a.isEmpty());
		System.out.println("Are a and b equal?  " + a.equals(b));

		while(a.isEmpty() == false) {
			System.out.println(a.dequeue());
		}

		System.out.println("Is a empty?  " + a.isEmpty());
	}

	/*
	stackTests tests every substantive method of Stack
	 */
	private static void stackTests() {
		//todo: make more tests here
		Stack a = new Stack();
		Stack b = new Stack();

		a.push('B');
		a.push('a');
		a.push('t');

		b.push('B');
		b.push('a');
		b.push('t');

		System.out.println(a.toString());
		System.out.println("The size of a is " + a.size());
		System.out.println("Is b empty?  " + b.isEmpty());
		System.out.println("Are a and b equal?  " + b.equals(a));

		a.pop();
		System.out.println("Are a and b still equal?  " + b.equals(a));
		System.out.println("The size of a after popping is " + a.size());

		while(a.isEmpty() == false) {
			System.out.println(a.pop());
		}
	}
}
