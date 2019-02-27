package notebook.postgressql;

import notebook.resourcefile.ResourceFileReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PostgresController {

    private PostgresConnector postgresConnector;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public PostgresController(PostgresConnector postgresConnector) {
        this.postgresConnector = postgresConnector;
        initializeBase();
    }

    private void initializeBase() {

        ResourceFileReader resourceFileReader = new ResourceFileReader();
        List<String> stringsQuery = resourceFileReader.parseFileStrings(resourceFileReader.receiveFileStrings("file/TextQueriesToCreateTables"), ";");

        for (String query : stringsQuery) {
            receiveQueryResult(query);
        }

    }

    private ResultSet receiveQueryResult(String query) {

        try {
            connection = postgresConnector.receiveSqlConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
