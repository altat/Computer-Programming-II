import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Name: Tanvir Tatla
File Description: This file reads fractions from a text file and prints out a
list of unique fractions and their corresponding count
 */

public class FractionsV1 {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "fractions.txt";
        int fileLines = countLines(fileName);
        double[] numerators = storeNumerators(fileName, fileLines);
        double[] denominators = storeDenominators(fileName, fileLines);
        String[] simpleFractions = new String[fileLines];

        // adds simplified version of fractions to simpleFractions
        for (int i = 0; i < denominators.length; i++) {
            simpleFractions[i] = simplifyFraction(numerators[i],
                    denominators[i]);
        }

        String[] fractionCount = countFractions(simpleFractions);
        String[] uniqueFractions = eliminateDuplicates(fractionCount);

        // prints each String element in uniqueFractions array
        for (int i = 0; i < uniqueFractions.length; i++) {
            System.out.println(uniqueFractions[i]);
        }
    }

    /*
    countLines - counts the number of lines (and fractions) in the text file
    @param the name of the file to read
    @Pre assumes a text file with the specified name exists and can be read.
    Also assumes that number of fractions in file is equal to number of lines
    @Post returns the number of lines in the specified text file
    */
    public static int countLines(String fileName) throws FileNotFoundException {
        int fileLines = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        if (file.canRead()) {
            // sentinel loop that looks for next line in file
            while (scanner.hasNextLine()) {
                // if line exists then increase fileLines by 1
                scanner.nextLine();
                fileLines++;
            }
        }
        return fileLines;
    }

    /*
    storeNumerators - places the numerator of each fraction into an array
    @param fileName: the name of the file  fileLines: the number of lines in
    the file
    @Pre assumes the file has one fraction per line in format A/B
    @Post returns an array containing the number before the "/" of each line
    in the file
    */
    public static double[] storeNumerators(String fileName, int fileLines)
            throws FileNotFoundException {
        double[] numerator = new double[fileLines];
        int index = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        if (file.canRead()) {
            // sentinel loop that looks for next line in file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // create array with 2 elements (numerator and denominator)
                String[] array = line.split("/");
                // first element is numerator
                numerator[index] = Double.parseDouble(array[0]);
                index++;
            }
        }
        return numerator;
    }

    /*
    storeDenominators - places the denominator of each fraction into an array
    @param fileName: the name of the file  fileLines: the number of lines in
    the file
    @Pre assumes the file has one fraction per line in format A/B
    @Post returns a double array containing the number after the "/" of each
    line in the file
    */
    public static double[] storeDenominators(String fileName, int fileLines)
            throws FileNotFoundException {
        double[] denominator = new double[fileLines];
        int index = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        if (file.canRead()) {
            // sentinel loop that looks for next line in file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // create array with 2 elements (numerator and denominator)
                String[] array = line.split("/");
                // 2nd element of array is denominator
                denominator[index] = Double.parseDouble(array[1]);
                index++;
            }
        }
        return denominator;
    }

    /*
    findGCD - finds the greatest common divisor of the numerator and denominator
    @param the numerator and denominator of the fraction
    @Pre TRUE
    @Post returns the greatest common divisor of two numbers
    */
    public static int findGCD(double numerator, double denominator) {
        // if denominator is zero then gcd is numerator
        if (denominator == 0) {
            return (int) numerator;
        } else {
            // get remainder from dividing numerator by denominator
            // use recursion to keep going until remainder is zero
            return findGCD(denominator, numerator % denominator);
            //example:  15 / 25 -> 25 / (15 % 25) -> 25 / 15
            //          25 / 15 -> 15 / (25 % 15) -> 15 / 10
            //          15 / 10 -> 10 / (15 % 10) -> 10 / 5
            //          10 / 5  -> 5  / (10 % 5)  -> 5 / 0
            //          gcd = 5
        }
    }

    /*
    simplifyFraction - simplifies a fraction
    @param the numerator and denominator of the fraction
    @Pre TRUE
    @Post returns a simplified fraction as a String
    */
    public static String simplifyFraction(double numerator,
                                          double denominator) {
        int gcd = findGCD(numerator, denominator);
        // divide numerator and denominator by gcd to simplify fraction
        return (int) (numerator / gcd) + "/" + (int) (denominator / gcd);
    }

    /*
    countFractions - counts the occurrence of every fraction in an array
    @param a String array containing fractions in the format A/B
    @Pre TRUE
    @Post return String array containing each fraction and its # of occurrences
     */
    public static String[] countFractions(String[] fractionList) {
        String[] occurrences = new String[fractionList.length];

        for (int i = 0; i < fractionList.length; i++) {
            occurrences[i] = compareFractions(fractionList, fractionList[i]);
        }
        return occurrences;
    }

    /*
    compareFractions - compares the elements of a String array to a String
    target and counts the number of occurrences of that target
    @param fractionList = String array of fractions in format A/B
    @Pre TRUE
    @Post return String of target and its number of occurrences in the
    String array
    */
    public static String compareFractions(String[] fractionList,
                                          String target) {
        int occurrence = 0;

        // loops over array
        for (int i = 0; i < fractionList.length; i++) {
            // if target found then increase occurrence by 1
            if (fractionList[i].equals(target)) {
                occurrence++;
            }
        }
        return target + " has a count of " + occurrence;
    }

    /*
    eliminateDuplicates - removes duplicate elements from an array
    @param fractions = String array of fractions in format A/B
    @Pre TRUE
    @Post returns an array without any duplicate elements
    */
    public static String[] eliminateDuplicates(String[] fractions) {
        int newLength = fractions.length;

        // find length of the array if duplicate elements were removed
        for (int i = 0; i < fractions.length; i++) {
            for (int j = i + 1; j < fractions.length; j++) {
                // if duplicate found then decrease length by 1
                if (fractions[j].equals(fractions[i])) {
                    newLength--;
                    break;
                }
            }
        }

        // create new array with size that excludes duplicates
        String[] newFractions = new String[newLength];
        int index = 0;
        boolean isDuplicate;

        // adds unique String elements to new array
        for (int i = 0; i < fractions.length; i++) {
            isDuplicate = false;
            for (int j = i + 1; j < fractions.length; j++) {
                // if duplicate found then change boolean to true
                if (fractions[j].equals(fractions[i])) {
                    isDuplicate = true;
                }
            }
            // if element isn't duplicate then place it into new array
            if (!isDuplicate) {
                newFractions[index++] = fractions[i];
            }
        }
        return newFractions;
    }
}
