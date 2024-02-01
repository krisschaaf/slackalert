package se2_webapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se2_webapp.backend.controller.bodies.GitlabSetupRequestBody;
import se2_webapp.backend.persistance.model.GitlabSetup;
import se2_webapp.backend.service.GitlabSetupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gitlab-setup")
@CrossOrigin(origins = "http://localhost:4200/")
public class GitlabSetupController {
    @Autowired
    private GitlabSetupService gitlabSetupService;

    @PostMapping("/sendGitlabFormOnPOST")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendGitlabFormOnPOST(@RequestBody GitlabSetupRequestBody body) {
        this.gitlabSetupService.
                sendGitlabFormOnPOST(body);
    }

    @GetMapping("/getConfig")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GitlabSetup getConfig(@RequestParam(name="id") Long id) {
        return this.gitlabSetupService.getConfig(id);
    }
}
