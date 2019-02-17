package notebook;


import notebook.controller.DataController;
import notebook.controller.ViewDataController;
import notebook.model.UserDataModel;

public class AccessPoint {

    private ViewDataController viewDataController;
    private UserDataModel userDataModel;
    private DataController dataController;

    public AccessPoint(ViewDataController viewDataController, UserDataModel userDataModel) {
        this.viewDataController = viewDataController;
        this.userDataModel = userDataModel;
        this.dataController = new DataController(userDataModel, viewDataController);
    }

    public void startProgram() {
        dataController.fillUserDataModel();
        viewDataController.printAllUserData(userDataModel.toString());
    }


}
