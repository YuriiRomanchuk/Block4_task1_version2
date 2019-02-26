package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.currentEnum.Groups;
import notebook.model.UserData;
import notebook.validator.Validator;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class GroupInitializer implements FieldInitializer<UserData> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<UserData, Groups> biConsumer;
    private final Map<String, String> userDataValues;
    private final List<String> errorsList;


    public GroupInitializer(String fieldName, ViewDataController viewDataController,
                            Validator<String> validator,
                            Map<String, String> userDataValues,
                            List<String> errorsList,
                            BiConsumer<UserData, Groups> biConsumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.biConsumer = biConsumer;
        this.userDataValues = userDataValues;
        this.errorsList = errorsList;
    }

    @Override
    public void initialize(UserData userData) {

        if (userDataValues.size() > 0) {

            String s = userDataValues.get(fieldName);

            if (validator.validateValue(s)) {
                biConsumer.accept(userData, Groups.valueOf(s));
            } else {
                errorsList.add("Value in " + fieldName + " is not validate!");
            }

        } else {

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
}
