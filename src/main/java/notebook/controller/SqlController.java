package notebook.controller;

import notebook.exception.UserDataModelStringException;
import notebook.model.UserData;

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
            throw new UserDataModelStringException("Current nick name is busy!", "nickname");
        }
    }


}
