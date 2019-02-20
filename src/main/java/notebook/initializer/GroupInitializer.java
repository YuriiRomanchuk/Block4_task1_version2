package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.currentEnum.Groups;
import notebook.model.UserData;
import notebook.validator.Validator;

import java.util.function.BiConsumer;

public class GroupInitializer implements FieldInitializer<UserData> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<UserData, Groups> biConsumer;

    public GroupInitializer(String fieldName, ViewDataController viewDataController, Validator<String> validator, BiConsumer<UserData, Groups> biConsumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.biConsumer = biConsumer;
    }

    @Override
    public void initialize(UserData userData) {

        boolean continueInitialize = true;
        viewDataController.printInputFieldData(fieldName);
        while (continueInitialize) {
            String s = viewDataController.inputStringValue(fieldName);
            if (validator.validateValue(s)) {
                biConsumer.accept(userData, Groups.valueOf(s));
                continueInitialize = false;
            } else {
                viewDataController.printWrongInputData(fieldName);
            }
        }

    }
}
