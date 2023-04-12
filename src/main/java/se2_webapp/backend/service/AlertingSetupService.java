package se2_webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se2_webapp.backend.controller.bodies.AlertingSetupRequestBody;
import se2_webapp.backend.exceptions.ResourceNotFoundException;
import se2_webapp.backend.persistance.model.AlertingSetup;
import se2_webapp.backend.persistance.repository.AlertingSetupRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlertingSetupService {
    @Autowired
    private AlertingSetupRepository alertingSetupRepository;

    @Autowired
    private UserService userService;

    @PostConstruct
    private void storeSetups() {
        alertingSetupRepository.saveAll(createAlertingSetup());
    }

    //For Testing purposes
    private List<AlertingSetup> createAlertingSetup() {
        List<AlertingSetup> entities = new ArrayList<>();
        entities.add(new AlertingSetup(1L, true, false, false, true));
        entities.add(new AlertingSetup(2L, false, false, true, true));
        return entities;
    }

    public void sendAlertingFormOnPOST(AlertingSetupRequestBody body) {
        AlertingSetup alertingSetup = new AlertingSetup(body.getUserId(), body.isPostIssues(), body.isPostUpdatedIssues(), body.isPostPipelines(), body.isPostVariables());
        alertingSetupRepository.save(alertingSetup);
        userService.setUserCreatedConfig(true, body.getUserId());
    }

    public AlertingSetup getConfig(Long id) {
        return this.findAlertingSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Alerting Setup available"));
    }

    /*
    * not relevant right now
    */
    public Optional<AlertingSetup> findAlertingSetupByUserId(Long id) {return alertingSetupRepository.findAlertingSetupByUserId(id);}

    public void deleteSetup(Optional<AlertingSetup> setupOptional) {
        AlertingSetup AlertingSetup = setupOptional.orElseThrow(() -> new ResourceNotFoundException());
        alertingSetupRepository.delete(AlertingSetup);
    }

    public void deleteAll() {alertingSetupRepository.deleteAll();}
}
