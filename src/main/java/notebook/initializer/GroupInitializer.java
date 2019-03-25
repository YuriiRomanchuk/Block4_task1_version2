package notebook.initializer;

import notebook.controller.ViewDataController;
import notebook.currentEnum.Groups;
import notebook.model.UserData;
import notebook.validator.Validator;

import java.util.List;
import java.util.function.BiConsumer;

public class GroupInitializer implements FieldInitializer<UserData> {

    private final String fieldName;
    private final ViewDataController viewDataController;
    private final Validator<String> validator;
    private final BiConsumer<UserData, Groups> biConsumer;
    private final String currentValue;
    private final List<String> errorsList;


    public GroupInitializer(String fieldName, ViewDataController viewDataController,
                            Validator<String> validator,
                            String currentValue,
                            List<String> errorsList,
                            BiConsumer<UserData, Groups> biConsumer) {
        this.fieldName = fieldName;
        this.viewDataController = viewDataController;
        this.validator = validator;
        this.biConsumer = biConsumer;
        this.currentValue = currentValue;
        this.errorsList = errorsList;
    }

    @Override
    public void initialize(UserData userData) {

        if (validator.validateValue(currentValue)) {
            biConsumer.accept(userData, Groups.valueOf(currentValue));
        } else {
            errorsList.add("Value in " + fieldName + " is not validate!");
        }

    }
}
