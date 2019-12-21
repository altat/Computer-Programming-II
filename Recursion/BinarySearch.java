import java.util.Arrays;

/**
 * @author Tanvir
 *
 * This class contains methods for seraching for a word in a String array. It
 * uses a binary search algorithm. It inherits from SearchAlgorithm.
 */
public class BinarySearch extends SearchAlgorithm {

    /**
     * search: searches for a word in a String array
     * @param words a String array
     * @param wordToFind a String word to search for
     * @return
     * @throws ItemNotFoundException
     * Implements a method in SearchAlgorithm
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int lowIndex = 0;
        int highIndex = words.length - 1;
        int middleIndex;

        //while lowIndex is still less than or equal to high
        while (lowIndex <= highIndex) {
            // incrementCount for each loop
            this.incrementCount();
            middleIndex = (highIndex + lowIndex) / 2;

            // compare the middle word to the target and return if they are
            // equal
            if(wordToFind.compareTo(words[middleIndex]) == 0)
                return middleIndex;

            // if the middle word starts with a larger letter than target,
            // the array is cut to the lower half
            else if(wordToFind.compareTo(words[middleIndex]) < 0)
                highIndex = middleIndex - 1;

            // if the middle word starts with a smaller letter than target,
            // the array is cut to the upper half
            else if(wordToFind.compareTo(words[middleIndex]) > 0)
                lowIndex = middleIndex + 1;
        }
        //if the word is never found, then an exception is thrown
        throw new ItemNotFoundException();
    }

    /**
     * recSearch: recursively searches for a word in a String array
     * @param words a String array
     * @param wordToFind a String word to search for
     * @return
     * @throws ItemNotFoundException
     * Implements a method in SearchAlgorithm
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        int lowIndex = 0;
        int highIndex = words.length - 1;
        int middleIndex = (highIndex + lowIndex) / 2;

        //if lowIndex is still less than or equal to highIndex
        if (lowIndex <= highIndex) {
            this.incrementCount();

            // compare the middle word to the target and return it if they
            // are equal
            if(wordToFind.compareTo(words[middleIndex]) == 0)
                return middleIndex;

            //if the middle word starts with a larger letter, the method is
            // called again with the array cut to the lower half.
            else if(wordToFind.compareTo(words[middleIndex]) < 0) {
                highIndex = middleIndex - 1;
                return recSearch(Arrays.copyOfRange(words, lowIndex, highIndex + 1), wordToFind);
            }

            //if the middle word starts with a smaller letter, the method is
            // called again with the array cut to the upper half.
            else if(wordToFind.compareTo(words[middleIndex]) > 0) {
                lowIndex = middleIndex + 1;
                return recSearch(Arrays.copyOfRange(words, lowIndex, highIndex + 1), wordToFind) + lowIndex;
            }
        }
        //if the word is never found, then an exception is thrown
        throw new ItemNotFoundException();
    }
}