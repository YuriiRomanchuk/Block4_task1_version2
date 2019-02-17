package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.model.UserDataModel;
import notebook.validator.Validator;

import java.util.function.BiConsumer;

public class StringInitializer implements FieldInitializer<UserDataModel> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<UserDataModel, String> consumer;

    public StringInitializer(String fieldName, ViewDataController viewDataController, Validator<String> validator, BiConsumer<UserDataModel, String> consumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.consumer = consumer;
    }

    @Override
    public void initialize(UserDataModel userDataModel) {

        boolean continueInitialize = true;

        while (continueInitialize) {
            String s = viewDataController.inputStringValue(fieldName);
            if (validator.validateValue(s)) {
                consumer.accept(userDataModel, s);
                continueInitialize = false;
            }
        }
    }
}
