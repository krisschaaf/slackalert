package se2_webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se2_webapp.backend.controller.bodies.SlackSetupRequestBody;
import se2_webapp.backend.exceptions.ResourceNotFoundException;
import se2_webapp.backend.persistance.model.SlackSetup;
import se2_webapp.backend.persistance.repository.SlackSetupRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SlackSetupService {

    private static final String DEFAULT_BASE_URL = "https://slack.com/api/";

    @Autowired
    private SlackSetupRepository slackSetupRepository;

    @PostConstruct
    private void storeSetups() {
        slackSetupRepository.saveAll(createSlackSetup());
    }

    //For Testing purposes
    private List<SlackSetup> createSlackSetup() {
        List<SlackSetup> entities = new ArrayList<>();
        entities.add(new SlackSetup(1L, "max.mockermann@test.de", "slackalert-app", "https://app.slack.com/api/", null));
        entities.add(new SlackSetup(2L, "fritz.tester@de.de", "allgemein", "https://app.slack.com/api/", null));
        return entities;
    }

    public void sendSlackFormOnPOST(SlackSetupRequestBody body) {
        this.saveSlackSetup(body);
    }

    public String getBaseUrl(Long id) {
        try {
            String baseUrl = this.getExistingSlackSetup(id).getBaseUrl();
            if(baseUrl == null || baseUrl.isEmpty()) {
                return DEFAULT_BASE_URL;
            } else {
                return baseUrl;
            }
        } catch (ResponseStatusException e) {
            return DEFAULT_BASE_URL;
        }
    }

    private SlackSetup saveSlackSetup(SlackSetupRequestBody body) {
        var finalBaseUrl = "";

        if(body.getBaseUrl().isEmpty()) {
            finalBaseUrl = DEFAULT_BASE_URL;
        } else {
            finalBaseUrl = body.getBaseUrl();
        }

        SlackSetup slackSetup = new SlackSetup(body.getUserId(), body.getEmail(), body.getChannelName(), finalBaseUrl, body.getToken());
        return slackSetupRepository.save(slackSetup);
    }

    private SlackSetup getExistingSlackSetup(Long id) {
        return this.findSlackSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Slack Setup available"));
    }

    public SlackSetup getConfig(Long id) {
        SlackSetup slackSetup;
        try {
            slackSetup = this.findSlackSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Gitlab Setup available"));
        } catch(ResponseStatusException ex) {
            slackSetup = new SlackSetup();
        }
        return slackSetup;
    }


    /*
    * not relevant right now
    */
    public List<SlackSetup> findByEmail(String email) { return slackSetupRepository.findSlackSetupByEmail(email); }

    public Optional<SlackSetup> findSlackSetupByUserId(Long id) {return slackSetupRepository.findSlackSetupByUserId(id);}

    public void setSlackSetupTokenById(String token, Long id) {slackSetupRepository.setSlackSetupTokenById(token, id);}

    public void deleteUser(Optional<SlackSetup> setupOptional) {
        SlackSetup SlackSetup = setupOptional.orElseThrow(() -> new ResourceNotFoundException());
        slackSetupRepository.delete(SlackSetup);
    }

    public void deleteAll() {slackSetupRepository.deleteAll();}
}
