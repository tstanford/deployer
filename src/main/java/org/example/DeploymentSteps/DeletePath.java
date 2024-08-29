package org.example.DeploymentSteps;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.IOException;

@JsonTypeName("delete")
public class DeletePath extends DeploymentStep {
    @Override
    public void run(DeploymentStep step, IOProcessor ioProcessor) throws IOException {
        ioProcessor.delete(this.src);
    }
}
