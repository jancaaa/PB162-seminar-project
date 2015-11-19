package cz.muni.fi.pb162.project.db;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 18. 11. 2015
 */
public class CannotStoreException extends DbException {
    public CannotStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
