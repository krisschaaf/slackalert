package se2_webapp.backend.webClients.bodies.projectBody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permissions {
    @JsonProperty("project_access")
    public Object getProject_access() {
        return this.project_access;
    }

    public void setProject_access(Object project_access) {
        this.project_access = project_access;
    }

    Object project_access;

    @JsonProperty("group_access")
    public Object getGroup_access() {
        return this.group_access;
    }

    public void setGroup_access(Object group_access) {
        this.group_access = group_access;
    }

    Object group_access;
}
