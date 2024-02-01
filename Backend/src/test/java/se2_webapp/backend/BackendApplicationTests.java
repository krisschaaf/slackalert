package se2_webapp.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import se2_webapp.backend.controller.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
class BackendApplicationTests {

	@Autowired
	MockMvc mockmvc;

	@Autowired
	UserController userController;

	@Autowired
	GitlabSetupController gitlabSetupController;

	@Autowired
	SlackSetupController slackSetupController;

	@Autowired
	AlertingSetupController alertingSetupController;

	@Autowired
	ConfigController configController;

	 @Test
	 void contextLoads() {
	 }

	 @Test
	 void userControllerIsNotNull() {
	 	assertThat(userController).isNotNull();
	 }

	 @Test
	 void gitlabSetupControllerIsNotNull() {
	 	assertThat(gitlabSetupController).isNotNull();
	 }

	 @Test
	 void slackSetupControllerIsNotNull() {
	 	assertThat(slackSetupController).isNotNull();
	 }

	 @Test
	 void alertingSetupControllerIsNotNull() {
	 	assertThat(alertingSetupController).isNotNull();
	 }

	 @Test
	 void configControllerIsNotNull() { assertThat(configController).isNotNull(); }
}
