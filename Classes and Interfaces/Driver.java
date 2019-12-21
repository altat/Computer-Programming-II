import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This driver tests if Bill, Money, and Date are serializable. It also tests
 * if ArrayList and ExpenseAccount are iterable. Finally it tests whether
 * ExpenseAccount accepts anything other than Bills.
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        Money m1 = new Money(799, 99);
        Date d1 = new Date(12, 25, 2015);
        Bill b1 = new Bill(new Money(211), d1, "Comcast");

        // Tests if Serializable has been implemented correctly
        FileOutputStream fos = new FileOutputStream("serialize.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(b1);
        oos.writeObject(m1);
        oos.writeObject(d1);
        oos.close();

        Bill b2 = b1.clone();
        Bill b3 = new Bill(new Money(8), d1, "Verizon");
        Bill b4 = new Bill(new Money(57), d1, "Electric Company");

        ExpenseAccount ea = new ExpenseAccount();

        ea.add(b1);
        ea.add(b2);
        ea.add(b3);
        ea.add(b4);

        // Test if iterable and iterator have been implemented correctly
        int i = 1;
        for (Object obj : ea)
            System.out.println(obj + "\nThe Bill above is bill #" + i++ +
                    " in ExpenseAccount.\n");

        // checks if Expense Account accepts a Date or Money
        ea.add(d1);
        ea.add(m1);

        System.out.println("Expense Account has " + ea.size() + " bills.");
    }
}
