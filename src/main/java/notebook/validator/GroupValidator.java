package notebook.validator;

import notebook.currentEnum.Groups;

import java.util.Arrays;

public class GroupValidator implements Validator<String> {

    private boolean obligatoryField;

    public GroupValidator(boolean obligatoryField) {
        this.obligatoryField = obligatoryField;
    }

    @Override
    public boolean validateValue(String value) {
        try {
            Groups.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(String.format("Invalid group %s! Groups include: ", value));
            Arrays.stream(Groups.values()).forEach(g -> System.out.print(String.format("%s \\s", g)));
            e.printStackTrace();
            return false;
        }
    }

    public boolean isObligatoryField() {
        return obligatoryField;
    }
}
