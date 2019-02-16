package notebook;

import notebook.controller.ViewDataController;
import notebook.initializer.UserDataModelInitializer;

public class MainClass {

    public static void main(String[] args) {
        AccessPoint accessPoint = new AccessPoint(new ViewDataController(System.in), new UserDataModelInitializer());
        accessPoint.startProgram();
    }

}
