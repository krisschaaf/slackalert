package se2_webapp.backend.webClients.bodies.gitlabBodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Issue {
    private int id;
    private String title;
    private String description;
    private String state;
    private OffsetDateTime created_at;
    private OffsetDateTime closed_at;
    private OffsetDateTime updated_at;
    private User closed_by;
    private String[] labels;
    private User author;
    private String type;
    private int weight;
    private String web_url;

    @Override
    public String toString() {
        String renderedDescription =
                getDescription() != null
                        ? "It contains following description: '" + getDescription() + "'.\r\n"
                        : "";

        String renderedLabels = "";

        if (getLabels().length > 0) {
            String renderedLabelsEach = "";
            for (String label: getLabels()) {
                renderedLabelsEach += "'" + label + "', ";
            }
            renderedLabels = "It has following labels: " + renderedLabelsEach.substring(0, renderedLabelsEach.length()-2) + ".\r\n";
        }

        return
                "Issue with id '" + getId() + "' " +
                "and title '" + getTitle() + "' " +
                "created by\r\n'" + getAuthor().toString() + " '\r\n" +
                "at '" + created_at.format(RFC_1123_DATE_TIME) + "' " +
                "has type '" + getType() + "' " +
                "and state '" + getState() + "'.\r\n" +
                renderedDescription +
                renderedLabels +
                "The Issue can be found here: \r\n'" + getWeb_url() + "'." +
                "\r\n\r\n";
    }

    public boolean isNewerThan(OffsetDateTime dateTime) {
        return this.getUpdated_at().isAfter(dateTime);
    }
}
