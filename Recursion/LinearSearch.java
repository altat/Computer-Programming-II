import java.util.Arrays;

/**
 * @author Tanvir
 *
 * This class is for linearly searching for a word in a String array. It
 * inherits from SearchAlgorithm
 */
public class LinearSearch extends SearchAlgorithm {

    /**
     * search: iteratively searches for a word in a String array
     * @param words a String array
     * @param wordToFind a String word to search for
     * @return Returns the index of the word to find in the array
     * @throws ItemNotFoundException
     * Implements a method in SearchAlgorithm
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        // loops over the words array
        for (int i = 0; i < words.length; i++) {
            // increments the count every time a comparison is made
            incrementCount();

            // if it finds the word then return the index in the array
            if (words[i].equals(wordToFind))
                return i;
        }
        // if never found, an exception is thrown
        throw new ItemNotFoundException();
    }

    /**
     * recSearch: recursively searches for a word in a String array
     * @param words a String array
     * @param wordToFind
     * @return Returns the index of the word to find
     * @throws ItemNotFoundException
     * Implements a method in SearchAlgorithm
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        // increments the count for every search
        incrementCount();

        // if the array only has one element
        if (words.length == 1) {

            // check if that element is the word to find
            if (words[words.length - 1].equals(wordToFind))
                // return the index if it is the word to find
                return words.length - 1;

            // if it's not the word, then throw an exception
            else {
                throw new ItemNotFoundException();
            }
        }

        // if the last element in the array is the word, then return the
        // index of the element
        if (words[words.length - 1].equals(wordToFind))
            return words.length - 1;

        // otherwise create a new array without the last word and repeat
        // this method (make a recursive call)
        else {
            String[] newWords = Arrays.copyOf(words, words.length - 1);
            return recSearch(newWords, wordToFind);
        }
        /*
        recSearch causes a stack overflow. It is unable to complete its
        search for the words in the driver.
         */
    }
}