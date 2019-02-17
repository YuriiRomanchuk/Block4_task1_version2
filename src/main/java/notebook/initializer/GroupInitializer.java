package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.currentEnum.Groups;
import notebook.model.UserDataModel;
import notebook.validator.Validator;

import java.util.function.BiConsumer;

public class GroupInitializer implements FieldInitializer<UserDataModel> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<UserDataModel, Groups> biConsumer;

    public GroupInitializer(String fieldName, ViewDataController viewDataController, Validator<String> validator, BiConsumer<UserDataModel, Groups> biConsumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.biConsumer = biConsumer;
    }

    @Override
    public void initialize(UserDataModel userDataModel) {

        boolean continueInitialize = true;

        while (continueInitialize) {
            viewDataController.printInputFieldData(fieldName);
            String s = viewDataController.inputStringValue(fieldName);
            if (validator.validateValue(s)) {
                biConsumer.accept(userDataModel, Groups.valueOf(s));
                continueInitialize = false;
            }
        }

    }
}
