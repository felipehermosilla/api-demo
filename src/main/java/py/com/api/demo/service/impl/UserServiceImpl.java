package py.com.api.demo.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.api.demo.entities.UserEntity;
import py.com.api.demo.exceptions.BusinessException;
import py.com.api.demo.exceptions.UserExeption;
import py.com.api.demo.framework.ApplicationUtils;
import py.com.api.demo.framework.conversion.MappingUtils;
import py.com.api.demo.framework.utils.JSONUtils;
import py.com.api.demo.repositories.IUserRepository;
import py.com.api.demo.service.UserService;
import py.com.api.demo.web.dto.UserDTO;

/**
 * User service implementation
 * @author felipehermosilla
 *
 */
@Service
@Transactional(rollbackFor=BusinessException.class)
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	IUserRepository userRepository;

	@Override
	public List<UserDTO> getAllUserDTO() {
		LOGGER.debug("Getting all users");
		List<UserEntity> users = ApplicationUtils.getListOrEmpty(userRepository.findAll());
		return getListFromEntities(users);
	}

	@Override
	public List<UserDTO> getUsersDtoByCountry(String country) {
		LOGGER.debug("Getting user by country: {}", country);
		List<UserEntity> users = ApplicationUtils.getListOrEmpty(userRepository.findByCountry(country));
		return getListFromEntities(users);
	}

	@Override
	public UserDTO getUserDtoById(Long userId) throws UserExeption {
		UserEntity user = getUserByIdAndFailIfNotExist(userId);
		LOGGER.debug("Getting user by id: {}", userId);
		return MappingUtils.map(user, UserDTO.class);
	}

	@Override
	public UserEntity getUserByIdAndFailIfNotExist(Long userId) throws UserExeption {
		UserEntity user = userRepository.findById(userId);
		if (user == null) {
			throw new UserExeption(UserExeption.USER_NOT_FOUND, "The user with id: " + userId + " not found");
		}
		return user;
	}

	@Override
	public UserDTO createUser(UserDTO userDto) throws UserExeption {
		validateUser(userDto);
		LOGGER.trace(String.format("Creating a new user %s", JSONUtils.toJSON(userDto)));
		UserEntity user = getUserByIdAndFailIfNotExist(userDto.getId());
		user = MappingUtils.map(userDto, UserEntity.class);
		userRepository.save(user);
		LOGGER.debug("The user has been created");
		return MappingUtils.map(user, UserDTO.class);
	}

	@Override
	public void deleteUser(Long userId) throws UserExeption {
		UserEntity user = getUserByIdAndFailIfNotExist(userId);
		LOGGER.debug("Deleting user by id: {}", userId);
		userRepository.delete(user);
		LOGGER.debug("The user with id: {} was deleted", userId);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) throws UserExeption {
		validateUser(userDto);
		UserEntity user = getUserByIdAndFailIfNotExist(userDto.getId());
		user = MappingUtils.map(userDto, UserEntity.class);
		userRepository.save(user);
		return MappingUtils.map(user, UserDTO.class);
	}

	private void validateUser(UserDTO userDto) throws UserExeption {
		if (StringUtils.isBlank(userDto.getName())) {
			throw new UserExeption(UserExeption.USER_NAME, "The user name is required");
		}
		if (StringUtils.isBlank(userDto.getLastname())) {
			throw new UserExeption(UserExeption.USER_LAST_NAME, "The user lastname is required");
		}
		if (userDto.getAge() == null) {
			throw new UserExeption(UserExeption.USER_LAST_NAME, "The user age is required");
		}
		if (userDto.getGender() == null) {
			throw new UserExeption(UserExeption.USER_LAST_NAME, "The user gender is required");
		}
	}

	private List<UserDTO> getListFromEntities(List<UserEntity> users) {
		return MappingUtils.asList(users, UserDTO.class);
	}

}
