import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Name: Tanvir Tatla
File Description: This file reads fractions from a text file and prints out a
list of unique fractions and their corresponding count
 */

public class FractionDriver {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("fractions.txt");
        ObjectList fractions = new ObjectList();
        Scanner scanner = new Scanner(file);

        // sentinel loop looking for next line in text file
        while (scanner.hasNextLine()) {
            Fraction newFraction = createFraction(scanner);

            // if there aren't any FractionCounters in the ObjectList
            if (fractions.getLength() < 1) {
                // then create a FractionCounter and add it to ObjectList
                FractionCounter count = new FractionCounter(newFraction);
                fractions.add(count);
            } else {
                boolean counted = false;

                // loops over the number of elements in the ObjectList
                for (int i = 0; i < fractions.getLength(); i++) {
                    FractionCounter currentCount = fractions.get(i);

                    // if the current fraction is the same as the new
                    // fraction, then add one to the fraction's count
                    if (currentCount.compareAndIncrement(newFraction)) {
                        // then break since it has been counted
                        counted = true;
                        break;
                    }
                }

                // if newFraction has not been counted
                if (!counted) {
                    // then add it to the ObjectList as a FractionCounter
                    FractionCounter newCount = new FractionCounter(newFraction);
                    fractions.add(newCount);
                }
            }
        }
        scanner.close();
        System.out.println(fractions.toString());
    }

    /*
    createFraction - creates a fraction by reading from a text file
    @param scanner = Scanner object that can read a text file
    @Pre assumes that the scanner is reading a text file and that the file has
    one fraction per line in the format A/B
    @Post returns a Fraction object with data numerator and denominator
    */
    public static Fraction createFraction(Scanner scanner) {
        int numerator, denominator;
        String[] splitFraction = scanner.nextLine().split("/");
        numerator = Integer.parseInt(splitFraction[0]);
        denominator = Integer.parseInt(splitFraction[1]);
        Fraction newFraction = new Fraction(numerator, denominator);
        return newFraction;
    }
}
