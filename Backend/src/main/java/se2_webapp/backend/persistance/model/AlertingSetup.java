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
@Table(name = "ALERTING_SETUP")
public class AlertingSetup {
        @Id
        @Column(name = "ID")
        private Long userId;

        @Column(name = "POST_ISSUES")
        private boolean postIssues;

        @Column(name = "POST_UPDATED_ISSUES")
        private boolean postUpdatedIssues;

        @Column(name = "POST_PIPELINES")
        private boolean postPipelines;

        @Column(name = "POST_VARIABLES")
        private boolean postVariables;
}