package se2_webapp.backend;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se2_webapp.backend.persistance.repository.UserRepository;
import se2_webapp.backend.service.UserService;

@SpringBootTest
public class AbstractIntegrationTest {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserService userService;

    @AfterEach
    void teardown() {
        userRepository.deleteAll();
    }

}
