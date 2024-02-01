package se2_webapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se2_webapp.backend.controller.bodies.UserRequestBody;
import se2_webapp.backend.persistance.model.User;
import se2_webapp.backend.service.UserService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> readOneById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/sendRegistrationForm")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendRegistrationForm(@RequestBody UserRequestBody body) {
        this.userService.registerUser(body);
    }

    @PostMapping("/sendLoginForm")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User sendLoginForm(@RequestBody UserRequestBody body) {
        return this.userService.loginUser(body);
    }

    @GetMapping("/logoutUser")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void logoutUser(@RequestParam(name="id", required = true) Long id) {
        this.userService.logoutUser(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByID(@PathVariable("id") Optional<User> userOptional) {
        this.userService.deleteUser(userOptional);
    }
}
