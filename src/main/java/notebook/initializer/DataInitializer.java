package notebook.initializer;

import notebook.Patterns;
import notebook.controller.ViewDataController;
import notebook.model.UserAddress;
import notebook.model.UserData;
import notebook.model.dto.UserAddressDto;
import notebook.model.dto.UserDataDto;
import notebook.validator.GroupValidator;
import notebook.validator.IntValidator;
import notebook.validator.StringValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<FieldInitializer<UserData>> fillInitializer(UserDataDto userDataDto, List<String> errorsList) {

        StringValidator stringValidator = new StringValidator(true, Patterns.stringRegex);
        StringValidator stringNumberValidator = new StringValidator(true, Patterns.regexStringNumber);
        StringValidator phoneNumberValidator = new StringValidator(true, Patterns.regexPhoneNumber);
        StringValidator phoneNumberValidatorNonObligatory = new StringValidator(false, Patterns.regexPhoneNumber);
        StringValidator emailValidator = new StringValidator(true, Patterns.regexEmail);
        GroupValidator groupValidator = new GroupValidator(true);

        List<FieldInitializer<UserData>> mainInitializers = new ArrayList<>();

        StringInitializer<UserData> nickname = new StringInitializer<>("nickname", viewDataController, stringNumberValidator, userDataDto.getNickname(), errorsList, UserData::setNickname);
        mainInitializers.add(nickname);
        keyInitializers.add(nickname);

        mainInitializers.add(new StringInitializer<>("lastName", viewDataController, stringValidator, userDataDto.getLastName(), errorsList, (userData, lastName) -> userData.setLastName(lastName)));
        mainInitializers.add(new StringInitializer<>("firstName", viewDataController, stringValidator, userDataDto.getFirstName(), errorsList, UserData::setFirstName));
        mainInitializers.add(new StringInitializer<>("middleName", viewDataController, stringValidator, userDataDto.getMiddleName(), errorsList, UserData::setMiddleName));
        mainInitializers.add(new GroupInitializer("groupName", viewDataController, groupValidator, userDataDto.getGroupName(), errorsList, UserData::setGroupName));
        mainInitializers.add(new StringInitializer<>("comment", viewDataController, stringNumberValidator, userDataDto.getComment(), errorsList, UserData::setComment));
        mainInitializers.add(new StringInitializer<>("skype", viewDataController, stringNumberValidator, userDataDto.getSkype(), errorsList, UserData::setSkype));
        mainInitializers.add(new StringInitializer<>("email", viewDataController, emailValidator, userDataDto.getEmail(), errorsList, UserData::setEmail));
        mainInitializers.add(new StringInitializer<>("homePhoneNumber", viewDataController, phoneNumberValidator, userDataDto.getHomePhoneNumber(), errorsList, UserData::setHomePhoneNumber));
        mainInitializers.add(new StringInitializer<>("mobilePhoneNumber", viewDataController, phoneNumberValidator, userDataDto.getMobilePhoneNumber(), errorsList, UserData::setMobilePhoneNumber));
        mainInitializers.add(new StringInitializer<>("mobilePhoneNumberSecond", viewDataController, phoneNumberValidatorNonObligatory, userDataDto.getMobilePhoneNumberSecond(), errorsList, UserData::setMobilePhoneNumberSecond));
        mainInitializers.add(model -> model.setFullName(model.getLastName() +
                " " + (!model.getFirstName().isEmpty() ? model.getFirstName().substring(0, 1) : "") + "." +
                " " + (!model.getMiddleName().isEmpty() ? model.getMiddleName().substring(0, 1) : "") + "."));
        mainInitializers.add(model -> {
            Date date = new Date();
            model.setEntryDate(date);
            model.setDateOfLastChange(date);
        });

        return  mainInitializers;

    }

    public List<FieldInitializer<UserAddress>> AddressInitializer(UserAddressDto userAddressDto, List<String> errorsList) {

        StringValidator stringValidator = new StringValidator(true, Patterns.stringRegex);
        StringValidator stringNumberValidator = new StringValidator(true, Patterns.regexStringNumber);
        IntValidator intValidator = new IntValidator(true);

        List<FieldInitializer<UserAddress>> addressInitializers = new ArrayList<>();
        addressInitializers.add(new StringInitializer<>("city", viewDataController, stringValidator, userAddressDto.getCity(), errorsList, UserAddress::setCity));
        addressInitializers.add(new StringInitializer<>("street", viewDataController, stringNumberValidator, userAddressDto.getStreet(), errorsList, UserAddress::setStreet));
        addressInitializers.add(new StringInitializer<>("houseNumber", viewDataController, stringNumberValidator, userAddressDto.getHouseNumber(), errorsList, UserAddress::setHouseNumber));
        addressInitializers.add(new IntInitializer<>("flatNumber", viewDataController, intValidator, userAddressDto.getFlatNumber(), errorsList, UserAddress::setFlatNumber));
        addressInitializers.add(new IntInitializer<>("index", viewDataController, intValidator, userAddressDto.getIndex(), errorsList, UserAddress::setIndex));

        return addressInitializers;
    }

}
