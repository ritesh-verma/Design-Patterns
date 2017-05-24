package studentRecordsBackup.util;

/**
 * Created by ritesh on 3/15/16.
 */
public class DuplicateItemException extends RuntimeException {
	/**
	 * Construct this exception object.
	 */
	public DuplicateItemException( ) {
		super( );
	}
	/**
	 * Construct this exception object.
	 * @param message the error message.
	 */
	public DuplicateItemException( String message ) {
		super( message );
	}
}

