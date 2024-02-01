package se2_webapp.backend.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import se2_webapp.backend.persistance.model.AlertingSetup;

import java.util.Optional;

@Transactional
public interface AlertingSetupRepository extends CrudRepository<AlertingSetup, Long> {
    Optional<AlertingSetup> findAlertingSetupByUserId(Long id);
}