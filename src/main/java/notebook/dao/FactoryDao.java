package notebook.dao;

import java.sql.Connection;

public class FactoryDao {

    private Connection connection;

    public FactoryDao(Connection connection) {
        this.connection = connection;
    }
}
