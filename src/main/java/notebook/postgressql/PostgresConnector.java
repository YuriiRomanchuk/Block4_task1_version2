package notebook.postgressql;

import notebook.resourcefile.ResourceFileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgresConnector {

    private String pathToSqlConnectData;
    private String separator;
    private Map<String, String> sqlConnectionData;

    public PostgresConnector(String pathToSqlConnectData, String separator) {
        this.pathToSqlConnectData = pathToSqlConnectData;
        this.separator = separator;
        prepareSqlConnectionData();
    }


    public Connection receiveSqlConnection() {

        return ConnectBase(sqlConnectionData.get("serverName"),
                sqlConnectionData.get("port"),
                sqlConnectionData.get("baseName"),
                sqlConnectionData.get("login"),
                sqlConnectionData.get("password"));
    }


    private void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection ConnectBase(String serverName, String port, String baseName, String login, String password) {

        loadDriver();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://" + serverName + ":" + port + "/" + baseName + "",
                "" + login + "",
                "" + password + "")) {
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }

    private void prepareSqlConnectionData() {

        Map<String, String> sqlConnectionData = new HashMap<>();

        ResourceFileReader resourceFileReader = new ResourceFileReader();
        List<String> strings = resourceFileReader.parseFileStrings(resourceFileReader.receiveFileStrings(pathToSqlConnectData), separator);

        for (String string : strings) {
            int index = string.indexOf(":");
            sqlConnectionData.put(string.substring(0, index - 1), string.substring(index + 1));
        }

    }

}
