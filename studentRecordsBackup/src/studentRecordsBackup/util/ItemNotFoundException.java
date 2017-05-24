package studentRecordsBackup.util;

/**
 * Created by ritesh on 3/15/16.
 */
public class ItemNotFoundException extends RuntimeException {
	/**
	 * Construct this exception object.
	 */
	public ItemNotFoundException( ) {
		super( );
	}

	/**
	 * Construct this exception object.
	 * @param message the error message.
	 */
	public ItemNotFoundException( String message ) {
		super( message );
	}
}
