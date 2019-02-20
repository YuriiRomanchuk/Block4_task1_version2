package notebook.exception;

import notebook.initializer.StringInitializer;
import notebook.model.UserData;

public class UserDataModelStringException extends Exception {

    private StringInitializer<UserData> initializer;

    public UserDataModelStringException(String s, StringInitializer<UserData> initializer) {
        super(s);
        this.initializer = initializer;
    }

    public StringInitializer<UserData> getInitializer() {
        return initializer;
    }
}
