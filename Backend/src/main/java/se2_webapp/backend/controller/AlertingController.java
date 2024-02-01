package se2_webapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se2_webapp.backend.service.AlertingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alerting")
@CrossOrigin(origins = "http://localhost:4200/")
public class AlertingController {
    @Autowired
    private AlertingService alertingService;

    @GetMapping("/postAlert")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void postAlert(@RequestParam(name="id") Long id) {
        this.alertingService.postAlert(id);
    }
}
