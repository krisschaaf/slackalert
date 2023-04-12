package se2_webapp.backend.persistance.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "GITLAB_SETUP")
public class GitlabSetup {
        @Id
        @Column(name = "ID")
        private Long userId;

        @Column(name = "EMAIL")
        private String email;

        @Column(name = "PROJECT_NAME")
        private String projectName;

        @Column(name = "PROJECT_ID")
        private int projectID;

        @Column(name = "BASE_URL")
        private String baseURL;

        @Column(name = "TOKEN")
        private String token;
}