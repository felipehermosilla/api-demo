package py.com.api.demo.web.wrap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author felipehermosilla
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse {

	@JsonProperty
	private String userMessage;
	@JsonProperty
	private Boolean success;
	@JsonProperty
	private String message;
	@JsonProperty
	private String errorCode;

	public ServiceResponse() {
	}

	public ServiceResponse(String pUserMessage) {
		userMessage = pUserMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
