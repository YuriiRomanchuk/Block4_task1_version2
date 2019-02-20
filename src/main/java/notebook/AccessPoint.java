package notebook;


import notebook.controller.DataController;
import notebook.controller.ViewDataController;
import notebook.exception.UserDataModelStringException;
import notebook.controller.SqlController;
import notebook.model.UserData;

public class AccessPoint {

    private ViewDataController viewDataController;
    private UserData userData;
    private DataController dataController;

    public AccessPoint(ViewDataController viewDataController, UserData userData) {
        this.viewDataController = viewDataController;
        this.userData = userData;
        this.dataController = new DataController(userData, viewDataController);
    }

    public void startProgram() {
        dataController.fillUserDataModel();

        SqlController sqlController = new SqlController(userData, viewDataController);

        boolean nicknameCorrect = false;
        while (!nicknameCorrect) {
            try {
                sqlController.verifyNickname();
                nicknameCorrect = true;
            } catch (UserDataModelStringException e) {
                e.printStackTrace();
                e.getInitializer().initialize(userData);
            }
        }

        viewDataController.printAllUserData(userData.toString());
    }


}
