package notebook;


import notebook.controller.ViewDataController;
import notebook.initializer.AddressInitializer;
import notebook.initializer.FieldInitializer;
import notebook.initializer.GroupInitializer;
import notebook.initializer.StringInitializer;
import notebook.model.UserDataModel;
import notebook.validator.GroupValidator;
import notebook.validator.IntValidator;
import notebook.validator.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class AccessPoint {

    ViewDataController viewDataController;
    UserDataModel userDataModel;

    public AccessPoint(ViewDataController viewDataController, UserDataModel userDataModel) {
        this.viewDataController = viewDataController;
        this.userDataModel = userDataModel;
    }

    public void startProgram() {

        List<FieldInitializer<UserDataModel>> fieldInitializers = receiveMainInitializer();

        for (FieldInitializer<UserDataModel> fieldInitializer : fieldInitializers) {
            fieldInitializer.initialize(userDataModel);
        }

        viewDataController.printAllUserData(userDataModel.toString());
    }


    private List<FieldInitializer<UserDataModel>> receiveMainInitializer() {

        StringValidator stingValidator = new StringValidator(true, Patterns.stringRegex);
        StringValidator stingNumberValidator = new StringValidator(true, Patterns.regexStringNumber);
        StringValidator phoneNumberValidator = new StringValidator(true, Patterns.regexPhoneNumber);
        StringValidator phoneNumberValidatorNonObligatory = new StringValidator(false, Patterns.regexPhoneNumber);
        StringValidator emailValidator = new StringValidator(true, Patterns.regexEmail);
        StringValidator numberValidator = new StringValidator(true, Patterns.regexNumber);
        GroupValidator groupValidator = new GroupValidator(true);
        IntValidator intValidator = new IntValidator(true);

        List<FieldInitializer<UserDataModel>> initializers = new ArrayList<>();

        initializers.add(new StringInitializer("lastName", viewDataController, stingValidator, UserDataModel::setLastName));
        initializers.add(new StringInitializer("firstName", viewDataController, stingValidator, UserDataModel::setFirstName));
        initializers.add(new StringInitializer("middleName", viewDataController, stingValidator, UserDataModel::setMiddleName));
        initializers.add(new StringInitializer("nickname", viewDataController, stingNumberValidator, UserDataModel::setNickname));
        initializers.add(new GroupInitializer("groupName", viewDataController, groupValidator, UserDataModel::setGroupName));
        initializers.add(new StringInitializer("comment", viewDataController, stingNumberValidator, UserDataModel::setComment));
        initializers.add(new StringInitializer("skype", viewDataController, stingNumberValidator, UserDataModel::setSkype));
        initializers.add(new StringInitializer("email", viewDataController, emailValidator, UserDataModel::setEmail));
        initializers.add(new StringInitializer("homePhoneNumber", viewDataController, phoneNumberValidator, UserDataModel::setLastName));
        initializers.add(new StringInitializer("mobilePhoneNumber", viewDataController, phoneNumberValidator, UserDataModel::setLastName));
        initializers.add(new StringInitializer("mobilePhoneNumberSecond", viewDataController, phoneNumberValidatorNonObligatory, UserDataModel::setLastName));

        initializers.add(new AddressInitializer("Address", viewDataController, receiveAddressFieldInitializer(), UserDataModel::setUserDataAddresses));

/*

        List<Validator> validators = new ArrayList<>();
        validators.add(new StringValidator<>("lastName", true, Patterns.stringRegex, UserDataModel::setLastName));
        validators.add(new StringValidator<>("firstName", true, Patterns.stringRegex, UserDataModel::setFirstName));
        validators.add(new StringValidator<>("middleName", true, Patterns.stringRegex, UserDataModel::setMiddleName));
        validators.add(new StringValidator<>("nickname", true, Patterns.regexStringNumber, UserDataModel::setNickname));
        validators.add(new GroupValidator<>("groupName", true, UserDataModel::setGroupName));
        validators.add(new StringValidator<>("comment", true, Patterns.regexPhoneNumber, UserDataModel::setComment));
        validators.add(new StringValidator<>("skype", true, Patterns.regexStringNumber, UserDataModel::setSkype));
        validators.add(new StringValidator<>("email", true, Patterns.regexEmail, UserDataModel::setEmail));
        validators.add(new StringValidator<>("homePhoneNumber", true, Patterns.regexNumber, UserDataModel::setHomePhoneNumber));
        validators.add(new StringValidator<>("mobilePhoneNumber", true, Patterns.regexPhoneNumber, UserDataModel::setMobilePhoneNumber));
        validators.add(new StringValidator<>("mobilePhoneNumberSecond", true, Patterns.stringRegex, UserDataModel::setMobilePhoneNumberSecond));
*/
        return initializers;
    }


    public List<FieldInitializer> receiveAddressFieldInitializer() {


        return new ArrayList<>();
    }

    /*public List*/
}
