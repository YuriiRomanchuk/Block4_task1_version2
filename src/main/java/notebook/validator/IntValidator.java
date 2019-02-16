package notebook.validator;

import notebook.model.UserDataModel;

import java.util.function.BiConsumer;

public class IntValidator implements Validator<Integer> {

    private BiConsumer<UserDataModel, String> biConsumer;
    private String fieldName;
    private boolean obligatoryField;

    public IntValidator(BiConsumer<UserDataModel, String> biConsumer, String fieldName) {
        this.biConsumer = biConsumer;
        this.fieldName = fieldName;
    }

    @Override
    public void validateValue(Integer value) {

    }
}
