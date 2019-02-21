package notebook.exception;

public class UserDataModelStringException extends Exception {

    private String fieldName;

    public UserDataModelStringException(String s, String fieldName) {
        super(s);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
