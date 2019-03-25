package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.validator.Validator;

import java.util.List;
import java.util.function.BiConsumer;

public class StringInitializer<T> implements FieldInitializer<T> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<T, String> consumer;
    private final String currentValue;
    private List<String> errorsList;

    public StringInitializer(String fieldName,
                             ViewDataController viewDataController,
                             Validator<String> validator,
                             String currentValue,
                             List<String> errorsList,
                             BiConsumer<T, String> consumer
    ) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.consumer = consumer;
        this.currentValue = currentValue;
        this.errorsList = errorsList;
    }

    @Override
    public void initialize(T model) {

        if (!validator.isObligatoryField() && currentValue.isEmpty()) {
            consumer.accept(model, "");
            return;
        }

        if (validator.validateValue(currentValue)) {
            consumer.accept(model, currentValue);
        } else {
            errorsList.add("Value in " + fieldName + " is not validate!");
        }

    }

    private boolean inputNonObligatoryField(boolean obligatoryField, String fieldName) {
        if (!obligatoryField) {
            return viewDataController.receiveAnswerAboutInputValue(fieldName);
        }
        return true;
    }
}
