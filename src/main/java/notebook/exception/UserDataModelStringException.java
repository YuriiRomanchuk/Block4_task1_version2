package notebook.exception;

import notebook.initializer.IntInitializer;

public class fieldFillingException extends Exception {

    IntInitializer initializer;

    public fieldFillingException(String s, IntInitializer initializer) {
        super(s);
        this.initializer = initializer;
    }
}
