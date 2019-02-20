package notebook.controller;

import notebook.Patterns;
import notebook.exception.UserDataModelStringException;
import notebook.initializer.StringInitializer;
import notebook.model.UserData;
import notebook.validator.StringValidator;

import java.util.Arrays;

public class SqlController {

    private UserData userData;
    private ViewDataController viewDataController;
    private String[] occupiedNicknames = {"anybis", "petro666", "ybivatel"};

    public SqlController(UserData userData, ViewDataController viewDataController) {
        this.userData = userData;
        this.viewDataController = viewDataController;
    }


    public void verifyNickname() throws UserDataModelStringException {

        long count = Arrays.stream(occupiedNicknames).filter(s -> s.equals(userData.getNickname())).count();

        if (count != 0l) {
            StringValidator stringNumberValidator = new StringValidator(true, Patterns.regexStringNumber);
            throw new UserDataModelStringException("Current nick name is busy!", new StringInitializer<>("nickname", viewDataController, stringNumberValidator, UserData::setNickname));
        }
    }


}
