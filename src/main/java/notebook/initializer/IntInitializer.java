package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.validator.Validator;

import java.util.List;
import java.util.function.BiConsumer;

public class IntInitializer<T> implements FieldInitializer<T> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<Integer> validator;
    private final BiConsumer<T, Integer> consumer;
    private final int currentValue;
    private final List<String> errorsList;

    public IntInitializer(String fieldName, ViewDataController viewDataController,
                          Validator<Integer> validator,
                          int currentValue,
                          List<String> errorsList,
                          BiConsumer<T, Integer> consumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.consumer = consumer;
        this.currentValue = currentValue;
        this.errorsList = errorsList;
    }

    @Override
    public void initialize(T model) {

        try {
            if (validator.validateValue(currentValue)) {
                consumer.accept(model, currentValue);
            } else {
                errorsList.add("Value in " + fieldName + " is not validate!");
            }
        } catch (Exception e) {
            errorsList.add("Value in " + fieldName + " is not validate!");
        }

    }
}



