package notebook;

import notebook.resourcefile.ResourceFileReader;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        /*ViewDataController viewDataController = new ViewDataController(System.in);
        AccessPoint accessPoint = new AccessPoint(viewDataController, new DataController(viewDataController));
        accessPoint.startProgram();*/

    /*    DataSource postgresConnector = new DataSource();
        postgresConnector.ConnectBase();*/

        ResourceFileReader resourceFileReader = new ResourceFileReader();
        List<String> strings = resourceFileReader.receiveFileStrings("file/SqlConnectData");
        List<String> parseStrings = resourceFileReader.parseFileStrings(strings, ";");

        parseStrings.forEach(s -> System.out.println(s));

    }
}
