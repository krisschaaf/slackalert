package se2_webapp.backend.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se2_webapp.backend.controller.bodies.UserRequestBody;
import se2_webapp.backend.persistance.model.User;
import se2_webapp.backend.persistance.repository.UserRepository;
import se2_webapp.backend.service.UserService;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @AfterEach
    public void teardown() {
        userRepository.deleteAll();
    }

    @Test
    void createUserHappy() throws Exception{
        var testMail = "testmail";
        var testUsername = "testUsername";
        var testPassword = "testPassword01!";

        UserRequestBody testUser = new UserRequestBody();
        testUser.setEmail(testMail);
        testUser.setUsername(testUsername);
        testUser.setPassword(testPassword);

        when(userService.findByEmail(testMail)).thenReturn(Collections.EMPTY_LIST);
        when(userService.findByUsername(testUsername)).thenReturn(Collections.EMPTY_LIST);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/user/sendRegistrationForm")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(new Gson().toJson(testUser));

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void loginUserHappy() throws Exception{
        var testMail = "testmail";
        var testUsername = "testUsername";
        var testPassword = "testPassword01!";

        UserRequestBody testUser = new UserRequestBody();
        testUser.setEmail(testMail);
        testUser.setUsername("");
        testUser.setPassword(testPassword);

        User savedUser = new User();
        savedUser.setEmail(testMail);
        savedUser.setUsername(testUsername);
        savedUser.setPassword(testPassword);
        savedUser.setLoggedIn(false);

        when(userService.findByEmail(testMail)).thenReturn(List.of(savedUser));
        when(userService.findByUsername(testUsername)).thenReturn(Collections.EMPTY_LIST);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/user/sendLoginForm")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(new Gson().toJson(testUser));

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    @Test
    void logoutUserHappy() throws Exception{
        var testId = 1L;
        var testMail = "testmail";
        var testUsername = "testUsername";
        var testPassword = "testPassword01!";

        User savedUser = new User();
        savedUser.setEmail(testMail);
        savedUser.setUsername(testUsername);
        savedUser.setPassword(testPassword);
        savedUser.setLoggedIn(true);

        when(userService.findByEmail(testMail)).thenReturn(List.of(savedUser));
        when(userService.findByUsername(testUsername)).thenReturn(Collections.EMPTY_LIST);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/user/logoutUser?id=" + testId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }

//    @Test
//    void createUserAndReturn403WhenEmailAlreadyExists() throws Exception {
//        User newUser = new User();
//        newUser.setEmail("testEmail");
//        newUser.setUsername("testUsername");
//        newUser.setPassword("testPassword01!");
//
//        User alreadyExistingUser = new User();
//        alreadyExistingUser.setEmail("testEmail");
//        alreadyExistingUser.setUsername("differentUsername");
//        alreadyExistingUser.setPassword("differentPassword01!");
//
//        when(userService.findByEmail("testEmail")).thenReturn(List.of(alreadyExistingUser));
//        when(userService.findByUsername("testUsername")).thenReturn(Collections.EMPTY_LIST);
//
//        MockHttpServletRequestBuilder builder =
//                MockMvcRequestBuilders.post("/user/sendRegistrationForm")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8")
//                        .content(new Gson().toJson(newUser));
//
//        this.mockMvc.perform(builder)
//                .andExpect(MockMvcResultMatchers.status().isForbidden());
//    }
}
