package se2_webapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se2_webapp.backend.service.AdapterService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adapter")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdapterController {
    @Autowired
    private AdapterService adapterService;

    @GetMapping("/connectGitlabAdapter")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendAlertingFormOnPOST(@RequestParam(name="id", required = true) Long id) {
        this.adapterService.connectGitlabAdapter(id);
        this.adapterService.connectSlackAdapter(id);
    }
}
