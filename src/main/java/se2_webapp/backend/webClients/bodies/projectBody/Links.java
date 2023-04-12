package se2_webapp.backend.webClients.bodies.projectBody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links{
        @JsonProperty("self")
        public String getSelf() {
            return this.self; }
        public void setSelf(String self) {
            this.self = self; }
        String self;
        @JsonProperty("issues")
        public String getIssues() {
            return this.issues; }
        public void setIssues(String issues) {
            this.issues = issues; }
        String issues;
        @JsonProperty("merge_requests")
        public String getMerge_requests() {
            return this.merge_requests; }
        public void setMerge_requests(String merge_requests) {
            this.merge_requests = merge_requests; }
        String merge_requests;
        @JsonProperty("repo_branches")
        public String getRepo_branches() {
            return this.repo_branches; }
        public void setRepo_branches(String repo_branches) {
            this.repo_branches = repo_branches; }
        String repo_branches;
        @JsonProperty("labels")
        public String getLabels() {
            return this.labels; }
        public void setLabels(String labels) {
            this.labels = labels; }
        String labels;
        @JsonProperty("events")
        public String getEvents() {
            return this.events; }
        public void setEvents(String events) {
            this.events = events; }
        String events;
        @JsonProperty("members")
        public String getMembers() {
            return this.members; }
        public void setMembers(String members) {
            this.members = members; }
        String members;
        @JsonProperty("cluster_agents")
        public String getCluster_agents() {
            return this.cluster_agents; }
        public void setCluster_agents(String cluster_agents) {
            this.cluster_agents = cluster_agents; }
        String cluster_agents;
    }

