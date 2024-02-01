package se2_webapp.backend.webClients.bodies.projectBody;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ContainerExpirationPolicy {
    @JsonProperty("cadence")
    public String getCadence() {
        return this.cadence;
    }

    public void setCadence(String cadence) {
        this.cadence = cadence;
    }

    String cadence;

    @JsonProperty("enabled")
    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    boolean enabled;

    @JsonProperty("keep_n")
    public int getKeep_n() {
        return this.keep_n;
    }

    public void setKeep_n(int keep_n) {
        this.keep_n = keep_n;
    }

    int keep_n;

    @JsonProperty("older_than")
    public String getOlder_than() {
        return this.older_than;
    }

    public void setOlder_than(String older_than) {
        this.older_than = older_than;
    }

    String older_than;

    @JsonProperty("name_regex")
    public String getName_regex() {
        return this.name_regex;
    }

    public void setName_regex(String name_regex) {
        this.name_regex = name_regex;
    }

    String name_regex;

    @JsonProperty("name_regex_keep")
    public Object getName_regex_keep() {
        return this.name_regex_keep;
    }

    public void setName_regex_keep(Object name_regex_keep) {
        this.name_regex_keep = name_regex_keep;
    }

    Object name_regex_keep;

    @JsonProperty("next_run_at")
    public Date getNext_run_at() {
        return this.next_run_at;
    }

    public void setNext_run_at(Date next_run_at) {
        this.next_run_at = next_run_at;
    }

    Date next_run_at;
}
