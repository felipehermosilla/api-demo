package py.com.api.demo.framework;

import java.util.Collections;
import java.util.List;

import py.com.api.demo.exceptions.BusinessException;
import py.com.api.demo.web.wrap.ServiceResponse;

/**
 * Application utility methods
 * @author felipehermosilla
 *
 */
public class ApplicationUtils {

	/**
	 * Generic error response for REST Service Controllers
	 *
	 * @param error exception captured
	 * @param response posible response
	 * @return constructed response
	 */
	public static ServiceResponse errorResponse(BusinessException error, ServiceResponse response) {
		if (response == null) {
			response = new ServiceResponse();
		}

		response.setSuccess(false);
		response.setMessage(error.getMessage());
		response.setErrorCode(error.getErrorCode());

		return response;
	}

    /**
     * Get a safe list of facts or empty list
     *
     * @param all original
     * @param <T> Holder type
     * @return resulting list or empty list
     */
    public static <T> List<T> getListOrEmpty(List<T> all) {
        if (all != null) {
            return all;
        }
        else {
            return Collections.emptyList();
        }
    }
}
