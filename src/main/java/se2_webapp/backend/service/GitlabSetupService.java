package se2_webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se2_webapp.backend.controller.bodies.GitlabSetupRequestBody;
import se2_webapp.backend.exceptions.ResourceNotFoundException;
import se2_webapp.backend.persistance.model.GitlabSetup;
import se2_webapp.backend.persistance.repository.GitlabSetupRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GitlabSetupService {

    @Autowired
    private GitlabSetupRepository gitlabSetupRepository;

    @PostConstruct
    private void storeUser() {
        gitlabSetupRepository.saveAll(createGitlabSetup());
    }

    //For Testing purposes
    private List<GitlabSetup> createGitlabSetup() {
        List<GitlabSetup> entities = new ArrayList<>();
        entities.add(new GitlabSetup(1L, "max.mockermann@test.de", "projectName", 27565, "https://git.haw-hamburg.de/api/v4/projects/", "GNcAXm7hDmhoCCYxxFZm"));
        entities.add(new GitlabSetup(2L, "fritz.tester@de.de", "secondName", 3253,"https://www.dfhafeöf.de/", "sfbeaev"));
        return entities;
    }

    public void sendGitlabFormOnPOST(GitlabSetupRequestBody body) {
        this.saveGitlabSetup(body);
    }

    private GitlabSetup saveGitlabSetup(GitlabSetupRequestBody body) {
        GitlabSetup gitlabSetup = new GitlabSetup(body.getUserId(), body.getEmail(), body.getProjectName(), body.getProjectID(), body.getBaseURL(), body.getToken());
        return gitlabSetupRepository.save(gitlabSetup);
    }

    private GitlabSetup getExistingGitlabSetup(Long id) {
        return this.findGitlabSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Gitlab Setup available"));
    }

    public GitlabSetup getConfig(Long id) {
        GitlabSetup gitlabSetup;
        try {
            gitlabSetup = this.findGitlabSetupByUserId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Gitlab Setup available"));
        } catch(ResponseStatusException ex) {
            gitlabSetup = new GitlabSetup();
        }
        return gitlabSetup;
    }

    /*
    * not relevant right now
    */
    public List<GitlabSetup> findByEmail(String email) { return gitlabSetupRepository.findGitlabSetupByEmail(email); }

    public Optional<GitlabSetup> findGitlabSetupByUserId(Long id) {return gitlabSetupRepository.findGitlabSetupByUserId(id);}

    public void setGitlabSetupTokenById(String token, Long id) {gitlabSetupRepository.setGitlabSetupTokenById(token, id);}

    public void deleteUser(Optional<GitlabSetup> setupOptional) {
        GitlabSetup GitlabSetup = setupOptional.orElseThrow(() -> new ResourceNotFoundException());
        gitlabSetupRepository.delete(GitlabSetup);
    }

    public void deleteAll() {gitlabSetupRepository.deleteAll();}
}
