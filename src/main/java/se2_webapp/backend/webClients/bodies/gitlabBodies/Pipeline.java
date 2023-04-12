package se2_webapp.backend.webClients.bodies.gitlabBodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Pipeline {
    private int id;
    private int iid;
    private int project_id;
    private String status;
    private String source;
    private String ref;
    private String sha;
    private String web_url;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @Override
    public String toString() {
        return
                "Pipeline with id '" + getId() + "' " +
                "has status '" + getStatus() + "' " +
                "by source '" + getSource() + "' " +
                "with ref '" + getRef() + "'.\r\n" +
                "Created at '" + created_at.format(RFC_1123_DATE_TIME) + "' " +
                "and can be found here: \r\n'" + getWeb_url() + "'." +
                "\r\n\r\n";
    }
}
