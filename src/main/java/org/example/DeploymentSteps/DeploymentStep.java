package org.example.DeploymentSteps;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.IOException;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CopyPath.class, name = "copy"),
        @JsonSubTypes.Type(value = DeletePath.class, name = "delete")
})
public abstract class DeploymentStep {
    public String name;
    public String src;
    public String dest;
    public abstract void run(DeploymentStep step, IOProcessor ioProcessor) throws IOException;
}
