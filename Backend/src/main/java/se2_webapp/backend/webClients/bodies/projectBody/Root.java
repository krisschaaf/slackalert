package se2_webapp.backend.webClients.bodies.projectBody;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Root {
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("description")
    public Object getDescription() {
        return this.description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    Object description;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("name_with_namespace")
    public String getName_with_namespace() {
        return this.name_with_namespace;
    }

    public void setName_with_namespace(String name_with_namespace) {
        this.name_with_namespace = name_with_namespace;
    }

    String name_with_namespace;

    @JsonProperty("path")
    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    String path;

    @JsonProperty("path_with_namespace")
    public String getPath_with_namespace() {
        return this.path_with_namespace;
    }

    public void setPath_with_namespace(String path_with_namespace) {
        this.path_with_namespace = path_with_namespace;
    }

    String path_with_namespace;

    @JsonProperty("created_at")
    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    Date created_at;

    @JsonProperty("default_branch")
    public String getDefault_branch() {
        return this.default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

    String default_branch;

    @JsonProperty("tag_list")
    public ArrayList<Object> getTag_list() {
        return this.tag_list;
    }

    public void setTag_list(ArrayList<Object> tag_list) {
        this.tag_list = tag_list;
    }

    ArrayList<Object> tag_list;

    @JsonProperty("topics")
    public ArrayList<Object> getTopics() {
        return this.topics;
    }

    public void setTopics(ArrayList<Object> topics) {
        this.topics = topics;
    }

    ArrayList<Object> topics;

    @JsonProperty("ssh_url_to_repo")
    public String getSsh_url_to_repo() {
        return this.ssh_url_to_repo;
    }

    public void setSsh_url_to_repo(String ssh_url_to_repo) {
        this.ssh_url_to_repo = ssh_url_to_repo;
    }

    String ssh_url_to_repo;

    @JsonProperty("http_url_to_repo")
    public String getHttp_url_to_repo() {
        return this.http_url_to_repo;
    }

    public void setHttp_url_to_repo(String http_url_to_repo) {
        this.http_url_to_repo = http_url_to_repo;
    }

    String http_url_to_repo;

    @JsonProperty("web_url")
    public String getWeb_url() {
        return this.web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    String web_url;

    @JsonProperty("readme_url")
    public Object getReadme_url() {
        return this.readme_url;
    }

    public void setReadme_url(Object readme_url) {
        this.readme_url = readme_url;
    }

    Object readme_url;

    @JsonProperty("avatar_url")
    public Object getAvatar_url() {
        return this.avatar_url;
    }

    public void setAvatar_url(Object avatar_url) {
        this.avatar_url = avatar_url;
    }

    Object avatar_url;

    @JsonProperty("forks_count")
    public int getForks_count() {
        return this.forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    int forks_count;

    @JsonProperty("star_count")
    public int getStar_count() {
        return this.star_count;
    }

    public void setStar_count(int star_count) {
        this.star_count = star_count;
    }

    int star_count;

    @JsonProperty("last_activity_at")
    public Date getLast_activity_at() {
        return this.last_activity_at;
    }

    public void setLast_activity_at(Date last_activity_at) {
        this.last_activity_at = last_activity_at;
    }

    Date last_activity_at;

    @JsonProperty("namespace")
    public Namespace getNamespace() {
        return this.namespace;
    }

    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    Namespace namespace;

    @JsonProperty("container_registry_image_prefix")
    public String getContainer_registry_image_prefix() {
        return this.container_registry_image_prefix;
    }

    public void setContainer_registry_image_prefix(String container_registry_image_prefix) {
        this.container_registry_image_prefix = container_registry_image_prefix;
    }

    String container_registry_image_prefix;

    @JsonProperty("_links")
    public Links get_links() {
        return this._links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    Links _links;

    @JsonProperty("packages_enabled")
    public boolean getPackages_enabled() {
        return this.packages_enabled;
    }

    public void setPackages_enabled(boolean packages_enabled) {
        this.packages_enabled = packages_enabled;
    }

    boolean packages_enabled;

    @JsonProperty("empty_repo")
    public boolean getEmpty_repo() {
        return this.empty_repo;
    }

    public void setEmpty_repo(boolean empty_repo) {
        this.empty_repo = empty_repo;
    }

    boolean empty_repo;

    @JsonProperty("archived")
    public boolean getArchived() {
        return this.archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    boolean archived;

    @JsonProperty("visibility")
    public String getVisibility() {
        return this.visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    String visibility;

    @JsonProperty("owner")
    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    Owner owner;

    @JsonProperty("resolve_outdated_diff_discussions")
    public boolean getResolve_outdated_diff_discussions() {
        return this.resolve_outdated_diff_discussions;
    }

    public void setResolve_outdated_diff_discussions(boolean resolve_outdated_diff_discussions) {
        this.resolve_outdated_diff_discussions = resolve_outdated_diff_discussions;
    }

    boolean resolve_outdated_diff_discussions;

    @JsonProperty("container_expiration_policy")
    public ContainerExpirationPolicy getContainer_expiration_policy() {
        return this.container_expiration_policy;
    }

    public void setContainer_expiration_policy(ContainerExpirationPolicy container_expiration_policy) {
        this.container_expiration_policy = container_expiration_policy;
    }

    ContainerExpirationPolicy container_expiration_policy;

    @JsonProperty("issues_enabled")
    public boolean getIssues_enabled() {
        return this.issues_enabled;
    }

    public void setIssues_enabled(boolean issues_enabled) {
        this.issues_enabled = issues_enabled;
    }

    boolean issues_enabled;

    @JsonProperty("merge_requests_enabled")
    public boolean getMerge_requests_enabled() {
        return this.merge_requests_enabled;
    }

    public void setMerge_requests_enabled(boolean merge_requests_enabled) {
        this.merge_requests_enabled = merge_requests_enabled;
    }

    boolean merge_requests_enabled;

    @JsonProperty("wiki_enabled")
    public boolean getWiki_enabled() {
        return this.wiki_enabled;
    }

    public void setWiki_enabled(boolean wiki_enabled) {
        this.wiki_enabled = wiki_enabled;
    }

    boolean wiki_enabled;

    @JsonProperty("jobs_enabled")
    public boolean getJobs_enabled() {
        return this.jobs_enabled;
    }

    public void setJobs_enabled(boolean jobs_enabled) {
        this.jobs_enabled = jobs_enabled;
    }

    boolean jobs_enabled;

    @JsonProperty("snippets_enabled")
    public boolean getSnippets_enabled() {
        return this.snippets_enabled;
    }

    public void setSnippets_enabled(boolean snippets_enabled) {
        this.snippets_enabled = snippets_enabled;
    }

    boolean snippets_enabled;

    @JsonProperty("container_registry_enabled")
    public boolean getContainer_registry_enabled() {
        return this.container_registry_enabled;
    }

    public void setContainer_registry_enabled(boolean container_registry_enabled) {
        this.container_registry_enabled = container_registry_enabled;
    }

    boolean container_registry_enabled;

    @JsonProperty("service_desk_enabled")
    public boolean getService_desk_enabled() {
        return this.service_desk_enabled;
    }

    public void setService_desk_enabled(boolean service_desk_enabled) {
        this.service_desk_enabled = service_desk_enabled;
    }

    boolean service_desk_enabled;

    @JsonProperty("can_create_merge_request_in")
    public boolean getCan_create_merge_request_in() {
        return this.can_create_merge_request_in;
    }

    public void setCan_create_merge_request_in(boolean can_create_merge_request_in) {
        this.can_create_merge_request_in = can_create_merge_request_in;
    }

    boolean can_create_merge_request_in;

    @JsonProperty("issues_access_level")
    public String getIssues_access_level() {
        return this.issues_access_level;
    }

    public void setIssues_access_level(String issues_access_level) {
        this.issues_access_level = issues_access_level;
    }

    String issues_access_level;

    @JsonProperty("repository_access_level")
    public String getRepository_access_level() {
        return this.repository_access_level;
    }

    public void setRepository_access_level(String repository_access_level) {
        this.repository_access_level = repository_access_level;
    }

    String repository_access_level;

    @JsonProperty("merge_requests_access_level")
    public String getMerge_requests_access_level() {
        return this.merge_requests_access_level;
    }

    public void setMerge_requests_access_level(String merge_requests_access_level) {
        this.merge_requests_access_level = merge_requests_access_level;
    }

    String merge_requests_access_level;

    @JsonProperty("forking_access_level")
    public String getForking_access_level() {
        return this.forking_access_level;
    }

    public void setForking_access_level(String forking_access_level) {
        this.forking_access_level = forking_access_level;
    }

    String forking_access_level;

    @JsonProperty("wiki_access_level")
    public String getWiki_access_level() {
        return this.wiki_access_level;
    }

    public void setWiki_access_level(String wiki_access_level) {
        this.wiki_access_level = wiki_access_level;
    }

    String wiki_access_level;

    @JsonProperty("builds_access_level")
    public String getBuilds_access_level() {
        return this.builds_access_level;
    }

    public void setBuilds_access_level(String builds_access_level) {
        this.builds_access_level = builds_access_level;
    }

    String builds_access_level;

    @JsonProperty("snippets_access_level")
    public String getSnippets_access_level() {
        return this.snippets_access_level;
    }

    public void setSnippets_access_level(String snippets_access_level) {
        this.snippets_access_level = snippets_access_level;
    }

    String snippets_access_level;

    @JsonProperty("pages_access_level")
    public String getPages_access_level() {
        return this.pages_access_level;
    }

    public void setPages_access_level(String pages_access_level) {
        this.pages_access_level = pages_access_level;
    }

    String pages_access_level;

    @JsonProperty("operations_access_level")
    public String getOperations_access_level() {
        return this.operations_access_level;
    }

    public void setOperations_access_level(String operations_access_level) {
        this.operations_access_level = operations_access_level;
    }

    String operations_access_level;

    @JsonProperty("analytics_access_level")
    public String getAnalytics_access_level() {
        return this.analytics_access_level;
    }

    public void setAnalytics_access_level(String analytics_access_level) {
        this.analytics_access_level = analytics_access_level;
    }

    String analytics_access_level;

    @JsonProperty("container_registry_access_level")
    public String getContainer_registry_access_level() {
        return this.container_registry_access_level;
    }

    public void setContainer_registry_access_level(String container_registry_access_level) {
        this.container_registry_access_level = container_registry_access_level;
    }

    String container_registry_access_level;

    @JsonProperty("security_and_compliance_access_level")
    public String getSecurity_and_compliance_access_level() {
        return this.security_and_compliance_access_level;
    }

    public void setSecurity_and_compliance_access_level(String security_and_compliance_access_level) {
        this.security_and_compliance_access_level = security_and_compliance_access_level;
    }

    String security_and_compliance_access_level;

    @JsonProperty("releases_access_level")
    public String getReleases_access_level() {
        return this.releases_access_level;
    }

    public void setReleases_access_level(String releases_access_level) {
        this.releases_access_level = releases_access_level;
    }

    String releases_access_level;

    @JsonProperty("emails_disabled")
    public Object getEmails_disabled() {
        return this.emails_disabled;
    }

    public void setEmails_disabled(Object emails_disabled) {
        this.emails_disabled = emails_disabled;
    }

    Object emails_disabled;

    @JsonProperty("shared_runners_enabled")
    public boolean getShared_runners_enabled() {
        return this.shared_runners_enabled;
    }

    public void setShared_runners_enabled(boolean shared_runners_enabled) {
        this.shared_runners_enabled = shared_runners_enabled;
    }

    boolean shared_runners_enabled;

    @JsonProperty("lfs_enabled")
    public boolean getLfs_enabled() {
        return this.lfs_enabled;
    }

    public void setLfs_enabled(boolean lfs_enabled) {
        this.lfs_enabled = lfs_enabled;
    }

    boolean lfs_enabled;

    @JsonProperty("creator_id")
    public int getCreator_id() {
        return this.creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    int creator_id;

    @JsonProperty("import_status")
    public String getImport_status() {
        return this.import_status;
    }

    public void setImport_status(String import_status) {
        this.import_status = import_status;
    }

    String import_status;

    @JsonProperty("open_issues_count")
    public int getOpen_issues_count() {
        return this.open_issues_count;
    }

    public void setOpen_issues_count(int open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    int open_issues_count;

    @JsonProperty("ci_default_git_depth")
    public int getCi_default_git_depth() {
        return this.ci_default_git_depth;
    }

    public void setCi_default_git_depth(int ci_default_git_depth) {
        this.ci_default_git_depth = ci_default_git_depth;
    }

    int ci_default_git_depth;

    @JsonProperty("ci_forward_deployment_enabled")
    public boolean getCi_forward_deployment_enabled() {
        return this.ci_forward_deployment_enabled;
    }

    public void setCi_forward_deployment_enabled(boolean ci_forward_deployment_enabled) {
        this.ci_forward_deployment_enabled = ci_forward_deployment_enabled;
    }

    boolean ci_forward_deployment_enabled;

    @JsonProperty("ci_job_token_scope_enabled")
    public boolean getCi_job_token_scope_enabled() {
        return this.ci_job_token_scope_enabled;
    }

    public void setCi_job_token_scope_enabled(boolean ci_job_token_scope_enabled) {
        this.ci_job_token_scope_enabled = ci_job_token_scope_enabled;
    }

    boolean ci_job_token_scope_enabled;

    @JsonProperty("ci_separated_caches")
    public boolean getCi_separated_caches() {
        return this.ci_separated_caches;
    }

    public void setCi_separated_caches(boolean ci_separated_caches) {
        this.ci_separated_caches = ci_separated_caches;
    }

    boolean ci_separated_caches;

    @JsonProperty("ci_opt_in_jwt")
    public boolean getCi_opt_in_jwt() {
        return this.ci_opt_in_jwt;
    }

    public void setCi_opt_in_jwt(boolean ci_opt_in_jwt) {
        this.ci_opt_in_jwt = ci_opt_in_jwt;
    }

    boolean ci_opt_in_jwt;

    @JsonProperty("ci_allow_fork_pipelines_to_run_in_parent_project")
    public boolean getCi_allow_fork_pipelines_to_run_in_parent_project() {
        return this.ci_allow_fork_pipelines_to_run_in_parent_project;
    }

    public void setCi_allow_fork_pipelines_to_run_in_parent_project(boolean ci_allow_fork_pipelines_to_run_in_parent_project) {
        this.ci_allow_fork_pipelines_to_run_in_parent_project = ci_allow_fork_pipelines_to_run_in_parent_project;
    }

    boolean ci_allow_fork_pipelines_to_run_in_parent_project;

    @JsonProperty("public_jobs")
    public boolean getPublic_jobs() {
        return this.public_jobs;
    }

    public void setPublic_jobs(boolean public_jobs) {
        this.public_jobs = public_jobs;
    }

    boolean public_jobs;

    @JsonProperty("build_timeout")
    public int getBuild_timeout() {
        return this.build_timeout;
    }

    public void setBuild_timeout(int build_timeout) {
        this.build_timeout = build_timeout;
    }

    int build_timeout;

    @JsonProperty("auto_cancel_pending_pipelines")
    public String getAuto_cancel_pending_pipelines() {
        return this.auto_cancel_pending_pipelines;
    }

    public void setAuto_cancel_pending_pipelines(String auto_cancel_pending_pipelines) {
        this.auto_cancel_pending_pipelines = auto_cancel_pending_pipelines;
    }

    String auto_cancel_pending_pipelines;

    @JsonProperty("ci_config_path")
    public String getCi_config_path() {
        return this.ci_config_path;
    }

    public void setCi_config_path(String ci_config_path) {
        this.ci_config_path = ci_config_path;
    }

    String ci_config_path;

    @JsonProperty("shared_with_groups")
    public ArrayList<Object> getShared_with_groups() {
        return this.shared_with_groups;
    }

    public void setShared_with_groups(ArrayList<Object> shared_with_groups) {
        this.shared_with_groups = shared_with_groups;
    }

    ArrayList<Object> shared_with_groups;

    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    public boolean getOnly_allow_merge_if_pipeline_succeeds() {
        return this.only_allow_merge_if_pipeline_succeeds;
    }

    public void setOnly_allow_merge_if_pipeline_succeeds(boolean only_allow_merge_if_pipeline_succeeds) {
        this.only_allow_merge_if_pipeline_succeeds = only_allow_merge_if_pipeline_succeeds;
    }

    boolean only_allow_merge_if_pipeline_succeeds;

    @JsonProperty("allow_merge_on_skipped_pipeline")
    public Object getAllow_merge_on_skipped_pipeline() {
        return this.allow_merge_on_skipped_pipeline;
    }

    public void setAllow_merge_on_skipped_pipeline(Object allow_merge_on_skipped_pipeline) {
        this.allow_merge_on_skipped_pipeline = allow_merge_on_skipped_pipeline;
    }

    Object allow_merge_on_skipped_pipeline;

    @JsonProperty("restrict_user_defined_variables")
    public boolean getRestrict_user_defined_variables() {
        return this.restrict_user_defined_variables;
    }

    public void setRestrict_user_defined_variables(boolean restrict_user_defined_variables) {
        this.restrict_user_defined_variables = restrict_user_defined_variables;
    }

    boolean restrict_user_defined_variables;

    @JsonProperty("request_access_enabled")
    public boolean getRequest_access_enabled() {
        return this.request_access_enabled;
    }

    public void setRequest_access_enabled(boolean request_access_enabled) {
        this.request_access_enabled = request_access_enabled;
    }

    boolean request_access_enabled;

    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    public boolean getOnly_allow_merge_if_all_discussions_are_resolved() {
        return this.only_allow_merge_if_all_discussions_are_resolved;
    }

    public void setOnly_allow_merge_if_all_discussions_are_resolved(boolean only_allow_merge_if_all_discussions_are_resolved) {
        this.only_allow_merge_if_all_discussions_are_resolved = only_allow_merge_if_all_discussions_are_resolved;
    }

    boolean only_allow_merge_if_all_discussions_are_resolved;

    @JsonProperty("remove_source_branch_after_merge")
    public boolean getRemove_source_branch_after_merge() {
        return this.remove_source_branch_after_merge;
    }

    public void setRemove_source_branch_after_merge(boolean remove_source_branch_after_merge) {
        this.remove_source_branch_after_merge = remove_source_branch_after_merge;
    }

    boolean remove_source_branch_after_merge;

    @JsonProperty("printing_merge_request_link_enabled")
    public boolean getPrinting_merge_request_link_enabled() {
        return this.printing_merge_request_link_enabled;
    }

    public void setPrinting_merge_request_link_enabled(boolean printing_merge_request_link_enabled) {
        this.printing_merge_request_link_enabled = printing_merge_request_link_enabled;
    }

    boolean printing_merge_request_link_enabled;

    @JsonProperty("merge_method")
    public String getMerge_method() {
        return this.merge_method;
    }

    public void setMerge_method(String merge_method) {
        this.merge_method = merge_method;
    }

    String merge_method;

    @JsonProperty("squash_option")
    public String getSquash_option() {
        return this.squash_option;
    }

    public void setSquash_option(String squash_option) {
        this.squash_option = squash_option;
    }

    String squash_option;

    @JsonProperty("enforce_auth_checks_on_uploads")
    public boolean getEnforce_auth_checks_on_uploads() {
        return this.enforce_auth_checks_on_uploads;
    }

    public void setEnforce_auth_checks_on_uploads(boolean enforce_auth_checks_on_uploads) {
        this.enforce_auth_checks_on_uploads = enforce_auth_checks_on_uploads;
    }

    boolean enforce_auth_checks_on_uploads;

    @JsonProperty("suggestion_commit_message")
    public Object getSuggestion_commit_message() {
        return this.suggestion_commit_message;
    }

    public void setSuggestion_commit_message(Object suggestion_commit_message) {
        this.suggestion_commit_message = suggestion_commit_message;
    }

    Object suggestion_commit_message;

    @JsonProperty("merge_commit_template")
    public Object getMerge_commit_template() {
        return this.merge_commit_template;
    }

    public void setMerge_commit_template(Object merge_commit_template) {
        this.merge_commit_template = merge_commit_template;
    }

    Object merge_commit_template;

    @JsonProperty("squash_commit_template")
    public Object getSquash_commit_template() {
        return this.squash_commit_template;
    }

    public void setSquash_commit_template(Object squash_commit_template) {
        this.squash_commit_template = squash_commit_template;
    }

    Object squash_commit_template;

    @JsonProperty("auto_devops_enabled")
    public boolean getAuto_devops_enabled() {
        return this.auto_devops_enabled;
    }

    public void setAuto_devops_enabled(boolean auto_devops_enabled) {
        this.auto_devops_enabled = auto_devops_enabled;
    }

    boolean auto_devops_enabled;

    @JsonProperty("auto_devops_deploy_strategy")
    public String getAuto_devops_deploy_strategy() {
        return this.auto_devops_deploy_strategy;
    }

    public void setAuto_devops_deploy_strategy(String auto_devops_deploy_strategy) {
        this.auto_devops_deploy_strategy = auto_devops_deploy_strategy;
    }

    String auto_devops_deploy_strategy;

    @JsonProperty("autoclose_referenced_issues")
    public boolean getAutoclose_referenced_issues() {
        return this.autoclose_referenced_issues;
    }

    public void setAutoclose_referenced_issues(boolean autoclose_referenced_issues) {
        this.autoclose_referenced_issues = autoclose_referenced_issues;
    }

    boolean autoclose_referenced_issues;

    @JsonProperty("keep_latest_artifact")
    public boolean getKeep_latest_artifact() {
        return this.keep_latest_artifact;
    }

    public void setKeep_latest_artifact(boolean keep_latest_artifact) {
        this.keep_latest_artifact = keep_latest_artifact;
    }

    boolean keep_latest_artifact;

    @JsonProperty("runner_token_expiration_interval")
    public Object getRunner_token_expiration_interval() {
        return this.runner_token_expiration_interval;
    }

    public void setRunner_token_expiration_interval(Object runner_token_expiration_interval) {
        this.runner_token_expiration_interval = runner_token_expiration_interval;
    }

    Object runner_token_expiration_interval;

    @JsonProperty("approvals_before_merge")
    public int getApprovals_before_merge() {
        return this.approvals_before_merge;
    }

    public void setApprovals_before_merge(int approvals_before_merge) {
        this.approvals_before_merge = approvals_before_merge;
    }

    int approvals_before_merge;

    @JsonProperty("mirror")
    public boolean getMirror() {
        return this.mirror;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    boolean mirror;

    @JsonProperty("external_authorization_classification_label")
    public Object getExternal_authorization_classification_label() {
        return this.external_authorization_classification_label;
    }

    public void setExternal_authorization_classification_label(Object external_authorization_classification_label) {
        this.external_authorization_classification_label = external_authorization_classification_label;
    }

    Object external_authorization_classification_label;

    @JsonProperty("marked_for_deletion_at")
    public Object getMarked_for_deletion_at() {
        return this.marked_for_deletion_at;
    }

    public void setMarked_for_deletion_at(Object marked_for_deletion_at) {
        this.marked_for_deletion_at = marked_for_deletion_at;
    }

    Object marked_for_deletion_at;

    @JsonProperty("marked_for_deletion_on")
    public Object getMarked_for_deletion_on() {
        return this.marked_for_deletion_on;
    }

    public void setMarked_for_deletion_on(Object marked_for_deletion_on) {
        this.marked_for_deletion_on = marked_for_deletion_on;
    }

    Object marked_for_deletion_on;

    @JsonProperty("requirements_enabled")
    public boolean getRequirements_enabled() {
        return this.requirements_enabled;
    }

    public void setRequirements_enabled(boolean requirements_enabled) {
        this.requirements_enabled = requirements_enabled;
    }

    boolean requirements_enabled;

    @JsonProperty("requirements_access_level")
    public String getRequirements_access_level() {
        return this.requirements_access_level;
    }

    public void setRequirements_access_level(String requirements_access_level) {
        this.requirements_access_level = requirements_access_level;
    }

    String requirements_access_level;

    @JsonProperty("security_and_compliance_enabled")
    public boolean getSecurity_and_compliance_enabled() {
        return this.security_and_compliance_enabled;
    }

    public void setSecurity_and_compliance_enabled(boolean security_and_compliance_enabled) {
        this.security_and_compliance_enabled = security_and_compliance_enabled;
    }

    boolean security_and_compliance_enabled;

    @JsonProperty("compliance_frameworks")
    public ArrayList<Object> getCompliance_frameworks() {
        return this.compliance_frameworks;
    }

    public void setCompliance_frameworks(ArrayList<Object> compliance_frameworks) {
        this.compliance_frameworks = compliance_frameworks;
    }

    ArrayList<Object> compliance_frameworks;

    @JsonProperty("issues_template")
    public Object getIssues_template() {
        return this.issues_template;
    }

    public void setIssues_template(Object issues_template) {
        this.issues_template = issues_template;
    }

    Object issues_template;

    @JsonProperty("merge_requests_template")
    public Object getMerge_requests_template() {
        return this.merge_requests_template;
    }

    public void setMerge_requests_template(Object merge_requests_template) {
        this.merge_requests_template = merge_requests_template;
    }

    Object merge_requests_template;

    @JsonProperty("merge_pipelines_enabled")
    public boolean getMerge_pipelines_enabled() {
        return this.merge_pipelines_enabled;
    }

    public void setMerge_pipelines_enabled(boolean merge_pipelines_enabled) {
        this.merge_pipelines_enabled = merge_pipelines_enabled;
    }

    boolean merge_pipelines_enabled;

    @JsonProperty("merge_trains_enabled")
    public boolean getMerge_trains_enabled() {
        return this.merge_trains_enabled;
    }

    public void setMerge_trains_enabled(boolean merge_trains_enabled) {
        this.merge_trains_enabled = merge_trains_enabled;
    }

    boolean merge_trains_enabled;

    @JsonProperty("only_allow_merge_if_all_status_checks_passed")
    public boolean getOnly_allow_merge_if_all_status_checks_passed() {
        return this.only_allow_merge_if_all_status_checks_passed;
    }

    public void setOnly_allow_merge_if_all_status_checks_passed(boolean only_allow_merge_if_all_status_checks_passed) {
        this.only_allow_merge_if_all_status_checks_passed = only_allow_merge_if_all_status_checks_passed;
    }

    boolean only_allow_merge_if_all_status_checks_passed;

    @JsonProperty("permissions")
    public Permissions getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    Permissions permissions;
}
