package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.validator.Validator;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class StringInitializer<T> implements FieldInitializer<T> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<T, String> consumer;
    private final Map<String, String> userDataValues;
    private List<String> errorsList;

    public StringInitializer(String fieldName,
                             ViewDataController viewDataController,
                             Validator<String> validator,
                             Map<String, String> userDataValues,
                             List<String> errorsList,
                             BiConsumer<T, String> consumer
    ) {
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

            String s = userDataValues.get(fieldName);

            if (!validator.isObligatoryField() && s.isEmpty()) {
                consumer.accept(model, "");
                return;
            }

            if (validator.validateValue(s)) {
                consumer.accept(model, s);
            } else {
                errorsList.add("Value in " + fieldName + " is not validate!");
            }

        } else {

            if (!inputNonObligatoryField(validator.isObligatoryField(), fieldName)) {
                consumer.accept(model, "");
                return;
            }

            viewDataController.printInputFieldData(fieldName);
            boolean continueInitialize = true;
            while (continueInitialize) {
                String s = viewDataController.inputStringValue(fieldName);
                if (validator.validateValue(s)) {
                    consumer.accept(model, s);
                    continueInitialize = false;
                } else {
                    viewDataController.printWrongInputData(fieldName);
                }
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
