public class Scope {
    int classVariable;

    public void local() {
        int localVariable;

        classVariable = 2;  // class-level variable can be accessed anywhere in class
    }

    public void other() {
        // localVariable = 4;  It cannot resolve symbol 'localVariable' which means local variables cannot be accessed
                            // from anywhere. It can only be accessed from the method it was defined in.
    }
}
