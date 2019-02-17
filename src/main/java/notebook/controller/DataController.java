package notebook.controller;

import notebook.Patterns;
import notebook.initializer.*;
import notebook.model.UserDataAddress;
import notebook.model.UserDataModel;
import notebook.validator.GroupValidator;
import notebook.validator.IntValidator;
import notebook.validator.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class DataController {

    private UserDataModel userDataModel;
    private ViewDataController viewDataController;

    public DataController(UserDataModel userDataModel, ViewDataController viewDataController) {
        this.userDataModel = userDataModel;
        this.viewDataController = viewDataController;
    }

    public void fillUserDataModel() {
        List<FieldInitializer<UserDataModel>> fieldInitializers = receiveMainInitializer();
        for (FieldInitializer<UserDataModel> fieldInitializer : fieldInitializers) {
            fieldInitializer.initialize(userDataModel);
        }
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

        initializers.add(new StringInitializer<>("lastName", viewDataController, stingValidator, UserDataModel::setLastName));
        initializers.add(new StringInitializer<>("firstName", viewDataController, stingValidator, UserDataModel::setFirstName));
        initializers.add(new StringInitializer<>("middleName", viewDataController, stingValidator, UserDataModel::setMiddleName));
        initializers.add(new StringInitializer<>("nickname", viewDataController, stingNumberValidator, UserDataModel::setNickname));
        initializers.add(new GroupInitializer("groupName", viewDataController, groupValidator, UserDataModel::setGroupName));
        initializers.add(new StringInitializer<>("comment", viewDataController, stingNumberValidator, UserDataModel::setComment));
        initializers.add(new StringInitializer<>("skype", viewDataController, stingNumberValidator, UserDataModel::setSkype));
        initializers.add(new StringInitializer<>("email", viewDataController, emailValidator, UserDataModel::setEmail));
        initializers.add(new StringInitializer<>("homePhoneNumber", viewDataController, phoneNumberValidator, UserDataModel::setLastName));
        initializers.add(new StringInitializer<>("mobilePhoneNumber", viewDataController, phoneNumberValidator, UserDataModel::setLastName));
        initializers.add(new StringInitializer<>("mobilePhoneNumberSecond", viewDataController, phoneNumberValidatorNonObligatory, UserDataModel::setLastName));

        initializers.add(new AddressInitializer("Address", viewDataController, receiveAddressFieldInitializer(stingValidator, stingNumberValidator, intValidator), UserDataModel::setUserDataAddresses));
        return initializers;
    }


    public List<FieldInitializer> receiveAddressFieldInitializer(StringValidator stingValidator, StringValidator stingNumberValidator, IntValidator intValidator) {

        List<FieldInitializer<UserDataAddress>> addressInitializers = new ArrayList<>();
        addressInitializers.add(new StringInitializer<>("city", viewDataController, stingValidator, UserDataAddress::setCity));
        addressInitializers.add(new StringInitializer<>("street", viewDataController, stingNumberValidator, UserDataAddress::setStreet));
        addressInitializers.add(new StringInitializer<>("houseNumber", viewDataController, stingNumberValidator, UserDataAddress::setHouseNumber));
        addressInitializers.add(new IntInitializer<>("flatNumber", viewDataController, intValidator, UserDataAddress::setFlatNumber));
        addressInitializers.add(new IntInitializer<>("index", viewDataController, intValidator, UserDataAddress::setIndex));
        return new ArrayList<>();
    }


}
