package se2_webapp.backend.webClients.bodies.projectBody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Namespace {
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("path")
    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    String path;

    @JsonProperty("kind")
    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    String kind;

    @JsonProperty("full_path")
    public String getFull_path() {
        return this.full_path;
    }

    public void setFull_path(String full_path) {
        this.full_path = full_path;
    }

    String full_path;

    @JsonProperty("parent_id")
    public Object getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(Object parent_id) {
        this.parent_id = parent_id;
    }

    Object parent_id;

    @JsonProperty("avatar_url")
    public String getAvatar_url() {
        return this.avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    String avatar_url;

    @JsonProperty("web_url")
    public String getWeb_url() {
        return this.web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    String web_url;
}
