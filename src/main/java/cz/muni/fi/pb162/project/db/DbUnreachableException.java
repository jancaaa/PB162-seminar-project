package cz.muni.fi.pb162.project.db;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 18. 11. 2015
 */
public class DbUnreachableException extends DbException {
    public DbUnreachableException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
