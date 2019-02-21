package notebook;

import notebook.controller.DataController;
import notebook.controller.ViewDataController;

public class MainClass {

    public static void main(String[] args) {
        ViewDataController viewDataController = new ViewDataController(System.in);
        AccessPoint accessPoint = new AccessPoint(viewDataController, new DataController(viewDataController));
        accessPoint.startProgram();
    }
}
