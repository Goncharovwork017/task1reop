package by.traning.nc.dev3.connectionpool;

import by.traning.nc.dev3.finals.Constants;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ivan on 11.04.2017.
 */
public enum ConnectionPool {
    INSTANCE;

    private DataSource dataSource;
    private Connection connection;

    {
        try{
            InitialContext initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup(Constants.DATABASE_SOURCE);
        }
        catch(NamingException e){
        }
    }

    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    public void initConnection(Connection connection) {
        if(connection != null){
            try {
                connection.close();
            }
            catch (SQLException e) {
            }
        }
    }
}