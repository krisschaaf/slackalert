package se2_webapp.backend.webClients.bodies.gitlabBodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Variable {
    private String variable_type;
    private String key;
    private String value;
    @JsonProperty("protected")
    private boolean protectedValue;
    private boolean masked;
    private String environment_scope;

    @Override
    public String toString() {
        String renderedProtectedValue = isProtectedValue() ? "protected" : "not protected";
        String renderedMasked = isMasked() ? "masked" : "not masked";

        return
                "Variables with type '" + getVariable_type() + "' " +
                "and scope '" + getEnvironment_scope() + "' " +
                "is " + renderedProtectedValue + " and is " + renderedMasked + ".\r\n" +
                "It has the key '" + getKey() + "' and the value '" + getValue() + "'." +
                "\r\n\r\n";
    }
}
