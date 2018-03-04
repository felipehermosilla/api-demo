package py.com.api.demo.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import py.com.api.demo.exceptions.BusinessException;
import py.com.api.demo.framework.ApplicationUtils;
import py.com.api.demo.web.wrap.ServiceResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Error Controller
 * @author felipehermosilla
 *
 */
@ControllerAdvice
public class ErrorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);


	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ServiceResponse> onBusinessError(BusinessException error) {
		HttpStatus status = HttpStatus.CONFLICT;
		ServiceResponse response = ApplicationUtils.errorResponse(error, new ServiceResponse());

		if (error.getErrorCode().endsWith("notFound")) {
			status = HttpStatus.NOT_FOUND;
		}

		response.setUserMessage(error.getErrorCode());

		logResponse(status, response, error);
		return new ResponseEntity<>(response, status);
	}

	/***
	 * Standart method to log errors caused by the client
	 * @param status
	 * @param pServiceResponse
	 * @param originalCause
	 */
	private static void logResponse(HttpStatus status,ServiceResponse
			pServiceResponse,Exception originalCause){
		LOGGER.debug("Answer with error, status {} - errorCode: {} - " +
						"userMessage: " +
						"{} . Original Exception {}: {}",status,pServiceResponse
						.getErrorCode(),
				pServiceResponse.getErrorCode(),originalCause.getClass()
						.getName(),originalCause.getMessage());
		if(LOGGER.isTraceEnabled()){
			LOGGER.trace(originalCause.getMessage(), originalCause);
		}
	}

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<ServiceResponse> onFatalError(RuntimeException ex) {
		ServiceResponse response = new ServiceResponse();
		response.setMessage(ex.getMessage());
		response.setSuccess(false);

		LOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
