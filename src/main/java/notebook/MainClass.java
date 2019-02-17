package notebook;

import notebook.controller.ViewDataController;
import notebook.model.UserDataModel;

public class MainClass {

    public static void main(String[] args) {
        ViewDataController viewDataController = new ViewDataController(System.in);
        AccessPoint accessPoint = new AccessPoint(viewDataController, new UserDataModel());
        accessPoint.startProgram();
    }
}
