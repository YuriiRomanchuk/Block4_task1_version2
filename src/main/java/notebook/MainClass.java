package notebook;

import notebook.controller.ViewDataController;
import notebook.model.UserData;

public class MainClass {

    public static void main(String[] args) {
        ViewDataController viewDataController = new ViewDataController(System.in);
        AccessPoint accessPoint = new AccessPoint(viewDataController, new UserData());
        accessPoint.startProgram();
    }
}
