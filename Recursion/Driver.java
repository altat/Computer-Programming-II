/**
 * @author Tanvir Tatla
 *
 * This class is a driver for the FindFile class. It contains the tests for
 * methods in FindFile
 */
public class Driver {

    // Contains the tests for FindFile
    public static void main(String[] args) {
        //replace the pathToSearch and targetFiles with your own path and
        // file names.

        String pathToSearch = "C:\\";

        // tests directorySearch for a file that exists once
        String targetFile1 = "Once.txt";
        FindFile finder1 = new FindFile(2);
        finder1.directorySearch(targetFile1, pathToSearch);
        finder1.printLocations();

        // tests for a file that does not exist
        String targetFile2 = "DostNotExist.txt";
        FindFile finder2 = new FindFile(1);
        finder2.directorySearch(targetFile2, pathToSearch);
        finder2.printLocations();

        // tests for a file that exists twice
        String targetFile3 = "Twice.txt";
        FindFile finder3 = new FindFile(3);
        finder3.directorySearch(targetFile3, pathToSearch);
        finder3.printLocations();

        // tests FindFile for when an invalid maxFiles is entered in its
        // constructor
        FindFile finder4 = new FindFile(0);
        finder4.directorySearch(targetFile1, pathToSearch);
        finder4.printLocations();

        // tests directorySearch when the target file exists maxFiles number of
        // times or more.
        String targetFile5 = "MAX_NUMBER_OF_FILES_TO_FIND.txt";
        FindFile finder5 = new FindFile(1);
        try {
            finder5.directorySearch(targetFile5, pathToSearch);
        } catch (IllegalArgumentException e) {
            finder5.printLocations();
            //System.exit(0);  //uncomment if you want the last test to run
        }

        // tests directorySearch when the starting directory does not exist
        String invalidPath = "Finland";
        FindFile finder6 = new FindFile(4);
        finder6.directorySearch(targetFile1, invalidPath);
    }
}
