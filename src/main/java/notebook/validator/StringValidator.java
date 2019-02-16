package notebook.validator;

import notebook.model.UserDataModel;

import java.util.function.BiConsumer;

public class StringValidator implements Validator<String> {

    private String regex;
    private BiConsumer<UserDataModel, String> biConsumer;
    private String fieldName;
    private boolean obligatoryField;

    public StringValidator(String fieldName, boolean obligatoryField, String regex, BiConsumer<UserDataModel, String> biConsumer) {
        this.regex = regex;
        this.biConsumer = biConsumer;
        this.fieldName = fieldName;
        this.obligatoryField = obligatoryField;
    }

    @Override
    public void validateValue(String value) {


    }
}
