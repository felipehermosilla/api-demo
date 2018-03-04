package py.com.api.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import py.com.api.demo.entities.UserEntity;

/**
 * User data access
 * @author felipehermosilla
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findById(Long id);

	List<UserEntity> findAll();

	List<UserEntity> findByName(String name);

	List<UserEntity> findByCountry(String country);

}
