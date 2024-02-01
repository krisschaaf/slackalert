package se2_webapp.backend.persistance.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import se2_webapp.backend.persistance.model.SlackSetup;

import java.util.List;
import java.util.Optional;

@Transactional
public interface SlackSetupRepository extends CrudRepository<SlackSetup, Long> {

    List<SlackSetup> findSlackSetupByEmail(String email);

    Optional<SlackSetup> findSlackSetupByUserId(Long id);

    @Modifying
    @Query("update SlackSetup s set s.token = ?1 where s.userId = ?2")
    void setSlackSetupTokenById(String token, Long userId);
}