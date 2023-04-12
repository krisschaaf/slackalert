package se2_webapp.backend.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se2_webapp.backend.controller.bodies.SlackSetupRequestBody;
import se2_webapp.backend.persistance.model.SlackSetup;
import se2_webapp.backend.service.SlackSetupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slack-setup")
@CrossOrigin(origins = "http://localhost:4200/")
public class SlackSetupController {
    @Autowired
    private SlackSetupService slackSetupService;

    @PostMapping("/sendSlackFormOnPOST")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendSlackFormOnPOST(@RequestBody SlackSetupRequestBody body) {
        this.slackSetupService.
                sendSlackFormOnPOST(body);
    }

    @GetMapping("/getBaseUrl")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getSlackToken(@RequestParam(name="id") Long id) {
        Gson gson = new Gson();
        return gson.toJson(this.slackSetupService.getBaseUrl(id));
    }

    @GetMapping("/getConfig")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SlackSetup getConfig(@RequestParam(name="id") Long id) {
        return slackSetupService.getConfig(id);
    }
}
