package notebook.validator;

public class IntValidator implements Validator<Integer> {

    private boolean obligatoryField;

    public IntValidator(boolean obligatoryField) {
        this.obligatoryField = obligatoryField;
    }

    @Override
    public boolean validateValue(Integer value) {
        return true;
    }

    public boolean isObligatoryField() {
        return obligatoryField;
    }
}
