package notebook.controller;

import notebook.Patterns;
import notebook.initializer.*;
import notebook.model.UserAddress;
import notebook.model.UserData;
import notebook.validator.GroupValidator;
import notebook.validator.IntValidator;
import notebook.validator.StringValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataController {

    private UserData userData;
    private ViewDataController viewDataController;

    public DataController(UserData userData, ViewDataController viewDataController) {
        this.userData = userData;
        this.viewDataController = viewDataController;
    }

    public void fillUserDataModel() {
        List<FieldInitializer<UserData>> fieldInitializers = receiveMainInitializer();
        for (FieldInitializer<UserData> fieldInitializer : fieldInitializers) {
            fieldInitializer.initialize(userData);
        }

        userData.setFullName(userData.getLastName() +
                " " + userData.getFirstName().substring(0, 1) + "." +
                " " + userData.getMiddleName().substring(0, 1) + ".");

        Date date = new Date();
        userData.setEntryDate(date);
        userData.setDateOfLastChange(date);
    }

    private List<FieldInitializer<UserData>> receiveMainInitializer() {

        StringValidator stringValidator = new StringValidator(true, Patterns.stringRegex);
        StringValidator stringNumberValidator = new StringValidator(true, Patterns.regexStringNumber);
        StringValidator phoneNumberValidator = new StringValidator(true, Patterns.regexPhoneNumber);
        StringValidator phoneNumberValidatorNonObligatory = new StringValidator(false, Patterns.regexPhoneNumber);
        StringValidator emailValidator = new StringValidator(true, Patterns.regexEmail);
        StringValidator numberValidator = new StringValidator(true, Patterns.regexNumber);
        GroupValidator groupValidator = new GroupValidator(true);
        IntValidator intValidator = new IntValidator(true);

        List<FieldInitializer<UserData>> initializers = new ArrayList<>();

        initializers.add(new StringInitializer<>("lastName", viewDataController, stringValidator, UserData::setLastName));
        initializers.add(new StringInitializer<>("firstName", viewDataController, stringValidator, UserData::setFirstName));
        initializers.add(new StringInitializer<>("middleName", viewDataController, stringValidator, UserData::setMiddleName));
        initializers.add(new StringInitializer<>("nickname", viewDataController, stringNumberValidator, UserData::setNickname));
        initializers.add(new GroupInitializer("groupName", viewDataController, groupValidator, UserData::setGroupName));
        initializers.add(new StringInitializer<>("comment", viewDataController, stringNumberValidator, UserData::setComment));
        initializers.add(new StringInitializer<>("skype", viewDataController, stringNumberValidator, UserData::setSkype));
        initializers.add(new StringInitializer<>("email", viewDataController, emailValidator, UserData::setEmail));
        initializers.add(new StringInitializer<>("homePhoneNumber", viewDataController, phoneNumberValidator, UserData::setHomePhoneNumber));
        initializers.add(new StringInitializer<>("mobilePhoneNumber", viewDataController, phoneNumberValidator, UserData::setMobilePhoneNumber));
        initializers.add(new StringInitializer<>("mobilePhoneNumberSecond", viewDataController, phoneNumberValidatorNonObligatory, UserData::setMobilePhoneNumberSecond));
        initializers.add(new AddressInitializer("Address", viewDataController, receiveAddressFieldInitializer(stringValidator, stringNumberValidator, intValidator), UserData::setUserAddresses));
        return initializers;
    }


    public List<FieldInitializer<UserAddress>> receiveAddressFieldInitializer(StringValidator stingValidator, StringValidator stingNumberValidator, IntValidator intValidator) {

        List<FieldInitializer<UserAddress>> addressInitializers = new ArrayList<>();
        addressInitializers.add(new StringInitializer<>("city", viewDataController, stingValidator, UserAddress::setCity));
        addressInitializers.add(new StringInitializer<>("street", viewDataController, stingNumberValidator, UserAddress::setStreet));
        addressInitializers.add(new StringInitializer<>("houseNumber", viewDataController, stingNumberValidator, UserAddress::setHouseNumber));
        addressInitializers.add(new IntInitializer<>("flatNumber", viewDataController, intValidator, UserAddress::setFlatNumber));
        addressInitializers.add(new IntInitializer<>("index", viewDataController, intValidator, UserAddress::setIndex));
        return addressInitializers;
    }


}
