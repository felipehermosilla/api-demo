package py.com.api.demo.service;

import java.util.List;

import py.com.api.demo.entities.UserEntity;
import py.com.api.demo.exceptions.UserExeption;
import py.com.api.demo.web.dto.UserDTO;

/**
 *
 * @author felipehermosilla
 *
 */
public interface UserService {

	List<UserDTO> getAllUserDTO();

	List<UserDTO> getUsersDtoByCountry(String country);

	UserDTO getUserDtoById(Long userId) throws UserExeption;

	UserEntity getUserByIdAndFailIfNotExist(Long userId) throws UserExeption;

	UserDTO createUser(UserDTO userDto) throws UserExeption;

	void deleteUser(Long userId) throws UserExeption;

	UserDTO updateUser(UserDTO userDto) throws UserExeption;
}
