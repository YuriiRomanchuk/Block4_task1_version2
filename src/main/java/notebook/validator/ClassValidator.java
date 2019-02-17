package notebook.validator;

import notebook.currentEnum.Groups;

import java.util.function.BiConsumer;

public class ClassValidator<T> implements Validator<Class, T> {

    private BiConsumer<T, Class> biConsumer;
    private String fieldName;
    private boolean obligatoryField;

    public ClassValidator(String fieldName, boolean obligatoryField, BiConsumer<T, Class> biConsumer) {
        this.biConsumer = biConsumer;
        this.fieldName = fieldName;
        this.obligatoryField = obligatoryField;
    }

    @Override
    public boolean validateValue(Class value, T currentObject) {
        return false;
    }

    @Override
    public String getFieldName() {
        return null;
    }

    @Override
    public boolean isObligatoryField() {
        return false;
    }
}
