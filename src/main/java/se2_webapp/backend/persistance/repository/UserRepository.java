package se2_webapp.backend.persistance.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import se2_webapp.backend.persistance.model.User;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUserByUsername(String username);

    List<User> findUserByEmail(String email);

    Optional<User> findById(Long id);

    @Modifying
    @Query("update User u set u.isLoggedIn = ?1 where u.id = ?2")
    void setUserIsLoggedInById(boolean isLoggedIn, Long userId);

    @Modifying
    @Query("update User u set u.createdConfig = ?1 where u.id = ?2")
    void setUserCreatedConfig(boolean createdConfig, Long userId);
}