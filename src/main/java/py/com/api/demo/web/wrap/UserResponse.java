package py.com.api.demo.web.wrap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import py.com.api.demo.web.dto.UserDTO;

/**
 *
 * @author felipehermosilla
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse extends ServiceResponse {

	@JsonProperty
	private UserDTO user;

	public UserResponse(UserDTO user) {
		this.user = user;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}

