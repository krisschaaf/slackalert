package se2_webapp.backend.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import se2_webapp.backend.service.AdapterService;
import se2_webapp.backend.service.GitlabSetupService;

@SpringBootTest
@ActiveProfiles("local")
public class AdapterServiceTest {

    @MockBean
    private GitlabSetupService gitlabSetupService;
    @MockBean
    private AdapterService adapterService;

//    @Test
//    void saveAlertingSetupHappy() {
//        var userId = 1L;
//        var gitlabTestMail = "gitlabTestmail";
//        var gitlabTestPassword = "gitlabTestPassword01!";
//        var gitlabTestUrlBoard = "https://sfgfead.de/";
//        var gitlabTestToken = "gitlabTesttoken";
//
//        GitlabSetup gitlabTestSetup = new GitlabSetup();
//        gitlabTestSetup.setUserId(userId);
//        gitlabTestSetup.setEmail(gitlabTestMail);
//        gitlabTestSetup.setPassword(gitlabTestPassword);
//        gitlabTestSetup.setUrlBoard(gitlabTestUrlBoard);
//        gitlabTestSetup.setToken(gitlabTestToken);
//
//        doReturn(Optional.of(gitlabTestSetup)).when(gitlabSetupService).findGitlabSetupByUserId(userId);
//
//        adapterService.connectGitlabAdapter((int) userId);
//
//        assertThat(gitlabWebClientBuilder.getValuesAsStrings()).contains(gitlabTestToken, gitlabTestUrlBoard);
//    }
}
