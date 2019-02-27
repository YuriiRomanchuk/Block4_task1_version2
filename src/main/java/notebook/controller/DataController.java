package notebook.controller;

import notebook.initializer.DataInitializer;
import notebook.model.UserData;
import notebook.postgressql.PostgresConnector;

import java.util.List;
import java.util.Map;

public class DataController {

    private ViewDataController viewDataController;
    private DataInitializer dataInitializer;

    public DataController(ViewDataController viewDataController) {
        this.viewDataController = viewDataController;
        this.dataInitializer = new DataInitializer(viewDataController);
    }

    public UserData processUserData(Map<String, String> userDataValues, List<String> errorsData) {

        UserData userData = new UserData();
        dataInitializer.fillInitializer(userDataValues, errorsData);
        dataInitializer.fillUserDataModel(userData);

        PostgresConnector postgresConnector = new PostgresConnector("file/SqlConnectData", ";");



       /* SqlController sqlController = new SqlController(userData, viewDataController);

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
*/
        return userData;

    }

}

