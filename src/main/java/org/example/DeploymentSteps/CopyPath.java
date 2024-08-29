package org.example.DeploymentSteps;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.IOException;

@JsonTypeName("copy")
public class CopyPath extends DeploymentStep {
    @Override
    public void run(DeploymentStep step, IOProcessor ioProcessor) throws IOException {
        ioProcessor.copy(this.src,this.dest);
    }
}
