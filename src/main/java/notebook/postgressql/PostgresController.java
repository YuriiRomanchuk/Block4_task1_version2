package notebook.postgressql;

import java.sql.Connection;

public class PostgresController {

    private Connection connection;

    public PostgresController(Connection connection) {
        this.connection = connection;
    }


}
