package py.com.api.demo.exceptions;

/**
 *
 * @author felipehermosilla
 *
 */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(String msg, Throwable e) {
		super(msg, e);
	}

}
