package notebook.validator;

import notebook.currentEnum.Groups;
import notebook.model.UserDataModel;

import java.util.function.BiConsumer;

public class GroupValidator implements Validator<Groups> {

    private BiConsumer<UserDataModel, String> biConsumer;
    private String fieldName;
    private boolean obligatoryField;

    public GroupValidator(String fieldName, boolean obligatoryField, BiConsumer<UserDataModel, String> biConsumer) {
        this.biConsumer = biConsumer;
        this.fieldName = fieldName;
        this.obligatoryField = obligatoryField;
    }


    @Override
    public void validateValue(Groups value) {

    }
}
