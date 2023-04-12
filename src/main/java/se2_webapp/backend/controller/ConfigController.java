package se2_webapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se2_webapp.backend.controller.bodies.ConfigResponseBody;
import se2_webapp.backend.service.ConfigService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/config")
@CrossOrigin(origins = "http://localhost:4200/")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @GetMapping("/getConfigForm")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ConfigResponseBody getConfigForm(@RequestParam(name="id") Long id) {
        return this.configService.getConfigForm(id);
    }

    @GetMapping("/getUserCreatedConfig")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean getUserCreatedConfig(@RequestParam(name="id") Long id) {
        return this.configService.getUserCreatedConfig(id);
    }
}
