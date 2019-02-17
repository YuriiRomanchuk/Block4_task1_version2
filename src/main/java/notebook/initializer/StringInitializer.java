package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.validator.Validator;

import java.util.function.BiConsumer;

public class StringInitializer<T> implements FieldInitializer<T> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<T, String> consumer;

    public StringInitializer(String fieldName, ViewDataController viewDataController, Validator<String> validator, BiConsumer<T, String> consumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.consumer = consumer;
    }

    @Override
    public void initialize(T model) {

        if (!inputNonObligatoryField(validator.isObligatoryField(), fieldName)) {
            consumer.accept(model, "");
            return;
        }

        boolean continueInitialize = true;
        while (continueInitialize) {
            viewDataController.printInputFieldData(fieldName);
            String s = viewDataController.inputStringValue(fieldName);
            if (validator.validateValue(s)) {
                consumer.accept(model, s);
                continueInitialize = false;
            }
        }
    }

    private boolean inputNonObligatoryField(boolean obligatoryField, String fieldName) {
        if (!obligatoryField) {
            return viewDataController.receiveAnswerAboutInputValue(fieldName);
        }
        return true;
    }
}
