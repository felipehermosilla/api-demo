package py.com.api.demo.rest;

/**
 *
 * @author felipehermosilla
 *
 */
public class ApiPaths {

    public static final String API_PATTERN = "/api/.*";
	public static final String USERS_API = "/api/users";
	public static final String USERS_FILTER = USERS_API+"/filter";
	public static final String USERS_BY_ID = USERS_API+"/{id}";
}
