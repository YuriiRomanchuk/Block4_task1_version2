package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.validator.Validator;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class IntInitializer<T> implements FieldInitializer<T> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<Integer> validator;
    private final BiConsumer<T, Integer> consumer;
    private final Map<String, String> userDataValues;
    private final List<String> errorsList;

    public IntInitializer(String fieldName, ViewDataController viewDataController,
                          Validator<Integer> validator,
                          Map<String, String> userDataValues,
                          List<String> errorsList,
                          BiConsumer<T, Integer> consumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.consumer = consumer;
        this.userDataValues = userDataValues;
        this.errorsList = errorsList;
    }

    @Override
    public void initialize(T model) {

        if (userDataValues.size() > 0) {

            try {
                Integer i = Integer.valueOf(userDataValues.get(fieldName));
                if (validator.validateValue(i)) {
                    consumer.accept(model, i);
                } else {
                    errorsList.add("Value in " + fieldName + " is not validate!");
                }
            } catch (Exception e) {
                errorsList.add("Value in " + fieldName + " is not validate!");
            }

        } else {
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
}



