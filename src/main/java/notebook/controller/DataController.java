package notebook.controller;

import notebook.exception.UserDataModelStringException;
import notebook.initializer.DataInitializer;
import notebook.model.UserData;

public class DataController {

    private ViewDataController viewDataController;
    private DataInitializer dataInitializer;

    public DataController(ViewDataController viewDataController) {
        this.viewDataController = viewDataController;
        this.dataInitializer = new DataInitializer(viewDataController);
    }

    public UserData processUserData() {

        UserData userData = new UserData();
        dataInitializer.fillUserDataModel(userData);

        SqlController sqlController = new SqlController(userData, viewDataController);

        boolean nicknameCorrect = false;
        while (!nicknameCorrect) {
            try {
                sqlController.verifyNickname();
                nicknameCorrect = true;
            } catch (UserDataModelStringException e) {
                e.printStackTrace();
                dataInitializer.fillKeyFields(userData);
            }
        }

        return userData;

    }

}
