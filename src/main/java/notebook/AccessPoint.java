package notebook;


import notebook.controller.DataController;
import notebook.controller.ViewDataController;
import notebook.model.UserData;

public class AccessPoint {

    private ViewDataController viewDataController;
    private DataController dataController;

    public AccessPoint(ViewDataController viewDataController, DataController dataController) {
        this.viewDataController = viewDataController;
        this.dataController = dataController;
    }

    public void startProgram() {
        UserData userData = dataController.processUserData();
        viewDataController.printAllUserData(userData.toString());
    }


}
