package se2_webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se2_webapp.backend.exceptions.ResourceNotFoundException;
import se2_webapp.backend.controller.bodies.UserRequestBody;
import se2_webapp.backend.persistance.model.User;
import se2_webapp.backend.persistance.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdapterService adapterService;

    @PostConstruct
    private void storeUser() {
        userRepository.saveAll(createUser());
    }

    //For Testing purposes
    private List<User> createUser() {
        List<User> entities = new ArrayList<>();
        entities.add(new User("Max", "max.mockermann@test.de", "password"));
        entities.add(new User("Fritz", "fritz.tester@de.de", "test"));
        return entities;
    }

    public boolean registerUser(UserRequestBody body) {
        String username = body.getUsername();
        String email = body.getEmail();

        if(!this.findByEmail(email).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Email already registered");
        }
        if(!this.findByUsername(username).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Username already registered");
        }
        this.saveUser(body);
        return true;
    }

    private User saveUser(UserRequestBody body) {
        User User = new User();
        User.setUsername(body.getUsername());
        User.setEmail(body.getEmail());
        User.setPassword(body.getPassword());
        return userRepository.save(User);
    }

    //changes isLoggedIn Attribute of User to false
    public void logoutUser(Long id) {
        if(this.userRepository.findById(id).get().isLoggedIn()) {
            this.userRepository.setUserIsLoggedInById(false, id);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Already logged out");
        }
        adapterService.resetAdapters();
    }

    /*
    * changes isLoggedIn Attribute of User to true
    * @returns user which successfully logged in
    * */
    public User loginUser(UserRequestBody body) {
        User userBody = new User(body.getUsername(), body.getEmail(), body.getPassword());
        User currentUser = getExistingUser(userBody);

        if(currentUser.isLoggedIn()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User already logged in");
        }

        if(currentUser.getPassword().equals(userBody.getPassword())) {
            this.setUserIsLoggedInById(true, currentUser.getId());
            currentUser.setLoggedIn(true);
            adapterService.setAdapters(currentUser.getId());
            return currentUser;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong Password");
        }
    }

    private User getExistingUser(User user) {
        List<User> usersFoundByEmail = this.findByEmail(user.getEmail());
        List<User> usersFoundByUsername = this.findByUsername(user.getUsername());
        if(!usersFoundByEmail.isEmpty()) {
            return usersFoundByEmail.get(0);
        }
        if(!usersFoundByUsername.isEmpty()) {
            return usersFoundByUsername.get(0);
        }
        return null;
    }


    /*
    * not relevant right now
    */
    public List<User> findByUsername(String username) { return userRepository.findUserByUsername(username); }

    public List<User> findByEmail(String email) { return userRepository.findUserByEmail(email); }

    public Optional<User> findById(Long id) {return userRepository.findById(id);}

    public void setUserIsLoggedInById(boolean isLoggedIn, Long userId) {userRepository.setUserIsLoggedInById(isLoggedIn, userId);}

    public void setUserCreatedConfig(boolean createdConfig, Long userId) {userRepository.setUserCreatedConfig(createdConfig, userId);}

    public void deleteUser(Optional<User> userOptional) {
        User User = userOptional.orElseThrow(() -> new ResourceNotFoundException());
        userRepository.delete(User);
    }

    public void deleteAll() {userRepository.deleteAll();}
}
