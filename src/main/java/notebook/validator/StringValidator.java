package notebook.validator;

public class StringValidator implements Validator<String> {

    private String regex;
    private boolean obligatoryField;

    public StringValidator(boolean obligatoryField, String regex) {
        this.regex = regex;
        this.obligatoryField = obligatoryField;
    }

    @Override
    public boolean validateValue(String value) {
        return value.matches(regex);
    }

    public boolean isObligatoryField() {
        return obligatoryField;
    }
}
