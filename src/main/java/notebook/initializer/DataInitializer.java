package notebook.initializer;

import notebook.Patterns;
import notebook.controller.ViewDataController;
import notebook.model.UserAddress;
import notebook.model.UserData;
import notebook.validator.GroupValidator;
import notebook.validator.IntValidator;
import notebook.validator.StringValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DataInitializer {

    ViewDataController viewDataController;
    List<FieldInitializer<UserData>> mainInitializers = new ArrayList<>();
    List<FieldInitializer<UserData>> keyInitializers = new ArrayList<>();

    public DataInitializer(ViewDataController viewDataController) {
        this.viewDataController = viewDataController;
    }

    public void fillUserDataModel(UserData userData) {

        for (FieldInitializer<UserData> fieldInitializer : mainInitializers) {
            fieldInitializer.initialize(userData);
        }

    }

    public void fillKeyFields(UserData userData) {
        for (FieldInitializer<UserData> fieldInitializer : keyInitializers) {
            fieldInitializer.initialize(userData);
        }
    }

    public void fillInitializer(Map<String, String> userDataValues, List<String> errorsList) {

        StringValidator stringValidator = new StringValidator(true, Patterns.stringRegex);
        StringValidator stringNumberValidator = new StringValidator(true, Patterns.regexStringNumber);
        StringValidator phoneNumberValidator = new StringValidator(true, Patterns.regexPhoneNumber);
        StringValidator phoneNumberValidatorNonObligatory = new StringValidator(false, Patterns.regexPhoneNumber);
        StringValidator emailValidator = new StringValidator(true, Patterns.regexEmail);
        StringValidator numberValidator = new StringValidator(true, Patterns.regexNumber);
        GroupValidator groupValidator = new GroupValidator(true);
        IntValidator intValidator = new IntValidator(true);


        StringInitializer<UserData> nickname = new StringInitializer<>("nickname", viewDataController, stringNumberValidator, userDataValues, errorsList, UserData::setNickname);
        mainInitializers.add(nickname);
        keyInitializers.add(nickname);

        mainInitializers.add(new StringInitializer<>("lastName", viewDataController, stringValidator, userDataValues, errorsList, (userData, lastName) -> userData.setLastName(lastName)));
        mainInitializers.add(new StringInitializer<>("firstName", viewDataController, stringValidator, userDataValues, errorsList, UserData::setFirstName));
        mainInitializers.add(new StringInitializer<>("middleName", viewDataController, stringValidator, userDataValues, errorsList, UserData::setMiddleName));
        mainInitializers.add(new GroupInitializer("groupName", viewDataController, groupValidator, userDataValues, errorsList, UserData::setGroupName));
        mainInitializers.add(new StringInitializer<>("comment", viewDataController, stringNumberValidator, userDataValues, errorsList, UserData::setComment));
        mainInitializers.add(new StringInitializer<>("skype", viewDataController, stringNumberValidator, userDataValues, errorsList, UserData::setSkype));
        mainInitializers.add(new StringInitializer<>("email", viewDataController, emailValidator, userDataValues, errorsList, UserData::setEmail));
        mainInitializers.add(new StringInitializer<>("homePhoneNumber", viewDataController, phoneNumberValidator, userDataValues, errorsList, UserData::setHomePhoneNumber));
        mainInitializers.add(new StringInitializer<>("mobilePhoneNumber", viewDataController, phoneNumberValidator, userDataValues, errorsList, UserData::setMobilePhoneNumber));
        mainInitializers.add(new StringInitializer<>("mobilePhoneNumberSecond", viewDataController, phoneNumberValidatorNonObligatory, userDataValues, errorsList, UserData::setMobilePhoneNumberSecond));
        mainInitializers.add(new AddressInitializer<>("Address", viewDataController, receiveAddressFieldInitializer(userDataValues, errorsList, stringValidator, stringNumberValidator, intValidator), UserData::setUserAddresses));
        mainInitializers.add(model -> model.setFullName(model.getLastName() +
                " " + (!model.getFirstName().isEmpty()? model.getFirstName().substring(0, 1): "") + "." +
                " " + (!model.getMiddleName().isEmpty()? model.getMiddleName().substring(0, 1) : "") + "."));
        mainInitializers.add(model -> {
            Date date = new Date();
            model.setEntryDate(date);
            model.setDateOfLastChange(date);
        });

    }

    private List<FieldInitializer<UserAddress>> receiveAddressFieldInitializer(Map<String, String> userDataValues,
                                                                               List<String> errorsList,
                                                                               StringValidator stingValidator,
                                                                               StringValidator stingNumberValidator,
                                                                               IntValidator intValidator) {

        List<FieldInitializer<UserAddress>> addressInitializers = new ArrayList<>();
        addressInitializers.add(new StringInitializer<>("city", viewDataController, stingValidator, userDataValues, errorsList, UserAddress::setCity));
        addressInitializers.add(new StringInitializer<>("street", viewDataController, stingNumberValidator, userDataValues, errorsList, UserAddress::setStreet));
        addressInitializers.add(new StringInitializer<>("houseNumber", viewDataController, stingNumberValidator, userDataValues, errorsList, UserAddress::setHouseNumber));
        addressInitializers.add(new IntInitializer<>("flatNumber", viewDataController, intValidator, userDataValues, errorsList, UserAddress::setFlatNumber));
        addressInitializers.add(new IntInitializer<>("index", viewDataController, intValidator, userDataValues, errorsList, UserAddress::setIndex));
        return addressInitializers;
    }


}
