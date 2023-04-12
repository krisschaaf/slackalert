package se2_webapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se2_webapp.backend.controller.bodies.AlertingSetupRequestBody;
import se2_webapp.backend.persistance.model.AlertingSetup;
import se2_webapp.backend.service.AlertingSetupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alerting-setup")
@CrossOrigin(origins = "http://localhost:4200/")
public class AlertingSetupController {
    @Autowired
    private AlertingSetupService alertingSetupService;

    @PostMapping("/sendAlertingFormOnPOST")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendAlertingFormOnPOST(@RequestBody AlertingSetupRequestBody body) {
        this.alertingSetupService.
                sendAlertingFormOnPOST(body);
    }

    @GetMapping("/getConfig")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AlertingSetup getConfig(@RequestParam(name="id") Long id) {
        return this.alertingSetupService.getConfig(id);
    }
}
