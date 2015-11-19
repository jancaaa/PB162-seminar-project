package cz.muni.fi.pb162.project.db;

import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.io.IOException;


/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 18. 11. 2015
 */
public class MyStorage implements Storage {
    private Connector connector;
    private int maxAttempts;

    public MyStorage(Connector connector, int maxAttempts) throws IllegalArgumentException {
        if (connector == null) {
            throw new IllegalArgumentException("connector is null!");
        } else {
            this.connector = connector;
        }
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("maxAttempts is not correct parameter!");
        } else {
            this.maxAttempts = maxAttempts;
        }
    }

    /**
     * Stores data in remote Db server.
     *
     * @param host Address of remote DB server
     * @param data Data to store
     * @throws DbUnreachableException if DB is unreachable
     * @throws CannotStoreException   if the method failed during the storing data into DB
     */
    @Override
    public void store(String host, Object data) throws DbUnreachableException, CannotStoreException {
        Connection connection;
        try {
            connection = connector.getConnection(host);
        } catch (NoRouteToHostException ex) {
            throw new DbUnreachableException("No route to host!", ex);
        } catch (UnknownHostException ex) {
            throw new DbUnreachableException("Host unreachable!", ex);
        }

        for (int i = 1; i <= maxAttempts; i++) {
            try {
                connection.sendData(data);
            } catch (IOException ex) {
                if (i == maxAttempts)
                    throw new CannotStoreException("Data could not be stored!", ex);
            }
        }
    }
}
