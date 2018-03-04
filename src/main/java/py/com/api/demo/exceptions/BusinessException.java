package py.com.api.demo.exceptions;

/**
 *
 * @author felipehermosilla
 *
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String PARAMETER_INVALID = "parameter.invalid";
	/**
	 * Error code
	 */
	private final String errorCode;

	/**
	 * Builds an exception with detailes
	 *
	 * @param errorCode
	 *            error code
	 * @param message
	 *            error message
	 */
	public BusinessException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Build an invalid parameter exception
	 *
	 * @param account
	 *            account reference
	 * @return accountException
	 */
	public static BusinessException invalidParameter(String parameter) {
		return new BusinessException(PARAMETER_INVALID, String.format("Invalid parameter: %s", parameter));
	}

	public String getErrorCode() {
		return errorCode;
	}
}
