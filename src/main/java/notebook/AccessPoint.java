package notebook;


import notebook.controller.ViewDataController;
import notebook.initializer.UserDataModelInitializer;
import notebook.model.UserDataModel;
import notebook.validator.GroupValidator;
import notebook.validator.StringValidator;
import notebook.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class AccessPoint {

    ViewDataController viewDataController;
    UserDataModelInitializer userDataModelInitializer;

    public AccessPoint(ViewDataController viewDataController, UserDataModelInitializer userDataModelInitializer) {
        this.viewDataController = viewDataController;
        this.userDataModelInitializer = userDataModelInitializer;
    }

    public void startProgram() {

        List<Validator> validators = receiveValidators();

    }


    private List<Validator> receiveValidators() {

        List<Validator> validators = new ArrayList<>();
        validators.add(new StringValidator("lastName", Patterns.stringRegex, UserDataModel::setLastName));
        validators.add(new StringValidator("firstName", Patterns.stringRegex, UserDataModel::setFirstName));
        validators.add(new StringValidator("middleName", Patterns.stringRegex, UserDataModel::setMiddleName));
        validators.add(new StringValidator("nickname", Patterns.regexStringNumber, UserDataModel::setNickname));
        validators.add(new GroupValidator("groupName", true, UserDataModel::setFullName));
        validators.add(new StringValidator("comment", Patterns.regexPhoneNumber, UserDataModel::setComment));
        validators.add(new StringValidator("skype", Patterns.regexStringNumber, UserDataModel::setSkype));
        validators.add(new StringValidator("email", Patterns.regexEmail, UserDataModel::setEmail));
        validators.add(new StringValidator("homePhoneNumber", Patterns.regexNumber, UserDataModel::setHomePhoneNumber));
        validators.add(new StringValidator("mobilePhoneNumber", Patterns.regexPhoneNumber, UserDataModel::setMobilePhoneNumber));
        validators.add(new StringValidator("mobilePhoneNumberSecond", Patterns.stringRegex, UserDataModel::setMobilePhoneNumberSecond));
        return validators;
    }
}
