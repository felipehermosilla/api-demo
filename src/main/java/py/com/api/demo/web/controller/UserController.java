package py.com.api.demo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import py.com.api.demo.exceptions.UserExeption;
import py.com.api.demo.rest.ApiPaths;
import py.com.api.demo.service.UserService;
import py.com.api.demo.web.dto.UserDTO;
import py.com.api.demo.web.wrap.ServiceResponse;
import py.com.api.demo.web.wrap.UserListResponse;
import py.com.api.demo.web.wrap.UserResponse;
/**
 *
 * @author felipehermosilla
 *
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Get all users", notes = "Get all users list", position = 1)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users list retrieved"),
			@ApiResponse(code = 404, message = "No users found") })
	@RequestMapping(value = ApiPaths.USERS_API, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResponse> getAllUsers() {
		UserListResponse response = new UserListResponse(userService.getAllUserDTO());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "Filter users by country", notes = "Gets users filter by country", position = 6)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users list retrieved"),
			@ApiResponse(code = 404, message = "Users not found") })
	@RequestMapping(value = ApiPaths.USERS_FILTER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResponse> getUsersByFilter(
			@RequestParam(value = "country", required = true) String country) {

		UserListResponse response = new UserListResponse(userService.getUsersDtoByCountry(country));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get user by id", notes = "Get user data by id", position = 3)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User created"),
			@ApiResponse(code = 404, message = "User not found") })
	@RequestMapping(value = ApiPaths.USERS_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> getUserById(@ApiParam("user id") @PathVariable(value = "id") Long userId)
			throws UserExeption {

		UserResponse response = new UserResponse(userService.getUserDtoById(userId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Create user", notes = "create user", position = 3)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User created"),
			@ApiResponse(code = 409, message = "Error while creating user") })
	@RequestMapping(value = ApiPaths.USERS_API, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> createUser(@RequestBody @Valid UserDTO userDTO) throws UserExeption {

		userService.createUser(userDTO);
		ServiceResponse response = new ServiceResponse();
		response.setMessage("User created");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Update user", notes = "update user", position = 3)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User updated"),
			@ApiResponse(code = 409, message = "Error while updating user") })
	@RequestMapping(value = ApiPaths.USERS_BY_ID, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> updateUser(@ApiParam("user id") @PathVariable(value = "id") Long userId,
			@RequestBody @Valid UserDTO userDTO) throws UserExeption {

		userService.updateUser(userDTO);
		ServiceResponse response = new ServiceResponse();
		response.setMessage("User updated");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
