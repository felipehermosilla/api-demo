package py.com.api.demo.web.wrap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import py.com.api.demo.web.dto.UserDTO;

/**
 *
 * @author felipehermosilla
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserListResponse extends CollectionResponse<UserDTO> {

	public UserListResponse() {
		super();
	}

	public UserListResponse(List<UserDTO> results) {
		super(results);
	}

	@Override
	@JsonProperty(value = "users")
	public List<UserDTO> getResults() {
		return super.getResults();
	}
}

