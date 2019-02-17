package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.validator.Validator;

import java.util.function.BiConsumer;

public class IntInitializer<T> implements FieldInitializer<T> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<Integer> validator;
    private final BiConsumer<T, Integer> consumer;

    public IntInitializer(String fieldName, ViewDataController viewDataController, Validator<Integer> validator, BiConsumer<T, Integer> consumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.consumer = consumer;
    }

    @Override
    public void initialize(T model) {

        boolean continueInitialize = true;
        viewDataController.printInputFieldData(fieldName);

        while (continueInitialize) {
            int i = viewDataController.inputIntValue(fieldName);
            if (validator.validateValue(i)) {
                consumer.accept(model, i);
                continueInitialize = false;
            } else {
                viewDataController.printWrongInputData(fieldName);
            }
        }

    }
}



