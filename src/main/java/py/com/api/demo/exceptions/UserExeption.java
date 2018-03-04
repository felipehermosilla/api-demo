package py.com.api.demo.exceptions;

/**
 *
 * @author felipehermosilla
 *
 */
public class UserExeption extends BusinessException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8860820014122889209L;

	public static final String USER_ERROR = "user.error";
	public static final String USER_NOT_FOUND = USER_ERROR+".notFound";
	public static final String USER_NAME = USER_ERROR+".name";
	public static final String USER_LAST_NAME = USER_ERROR+".lastname";
	public static final String USER_AGE = USER_ERROR+".age";
	public static final String USER_GENDER = USER_ERROR+".gender";




	public UserExeption(String errorCode, String message) {
		super(errorCode, message);
	}
}
