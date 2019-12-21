import java.io.File;

/**
 * @author Tanvir Tatla
 *
 * FindFile is a class that allow you to search for a file in a directory and
 * print the locations of that target file.
 */
public class FindFile {
    private int maxFiles = 10;
    private int count;
    private String[] files;
    private String fileName;

    /**
     Constructor for FindFile
     @param maxFiles  the maximum number of files to search
     maxFiles must be greater than zero. If you try to set it to zero or
     less, then it will be set to 10.
     String[] files is set to a new String array of size maxFiles.
     count is set to zero.
     */
    public FindFile(int maxFiles) {
        if (maxFiles <= 0) {
            System.out.println("Invalid maxFiles. maxFiles has been set to 10" +
                    " instead.");
        } else {
            this.maxFiles = maxFiles;
        }
        files = new String[this.maxFiles];
        count = 0;
    }

    /**
    Method directorySearch: searches for a file in a directory and stores its
     location in a String array.
     @param target - the name of the file to search
     @param dirName - the name of the directory to search in
     @return searches a directory for a file and places the locations it finds
     into the files instance variable.
     @throws IllegalArgumentException
     */
    public void directorySearch(String target, String dirName) {
        File dir = new File(dirName);

        // if the directory isn't valid then throw an Exception
        try {
            if (!dir.exists() && !dir.isDirectory()) {
                throw new IllegalArgumentException();
            }
        } // catch the exception and print an error message and exit
        catch (IllegalArgumentException e) {
            System.err.println(dirName + " is not a valid directory.");
            System.exit(0);
        }

        // put all the files and subdirectories in the starting directory
        // into a File array
        File[] fileList = dir.listFiles();

        // loop over the file array
        for (int i = 0; i < fileList.length; i++) {
            // if the file or subdirectory in the starting directory is null,
            // then skip this iteration
            if (fileList[i] == null) continue;

            // if the element in fileList is a subdirectory and the subdirectory
            // is not null, then make a recursive call to search the
            // subdirectory.
            if (fileList[i].isDirectory() && fileList[i].listFiles() != null)
                directorySearch(target, fileList[i].toString());

            // if the element in fileList is a file
                // check if its name is equal to the target file name
            else if (fileList[i].isFile()) {
                if (fileList[i].getName().equals(target)) {
                    // if they are equal then add its location to files array
                    // and add one to count
                    files[count++] = fileList[i].toString();

                    // if count is equal to maxFiles, then the maximum number
                    // of files to search has been reached
                    if (count == maxFiles) throw new IllegalArgumentException();
                }
            }
        }
        fileName = target;
    }

    public int getCount() {
        return count;
    }

    public String[] getFiles() {
        return files;
    }

    /**
    Method printLocations: prints the locations in the files array instance
     variable
     @Pre Assumes directorySearch has been called prior to this method or
     else it will print nothing
     @return Prints every location of the target file that is currently being
     stored in the files instance variable.
     */
    public void printLocations() {
        // prints the number of locations found for the target file
        System.out.println(getCount() + " file(s) with the name '" +
                fileName + "' were found: ");
        // loops over the locations in files and prints them
        for (int i = 0; i < count; i++) {
            System.out.println(files[i]);
        }
        System.out.println();
    }
}
