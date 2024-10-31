package org.example;

import org.example.DeploymentSteps.IOProcessor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeploymentRunnerImpl implements DeploymentRunner {

    private IOProcessor ioProcessor;

    public DeploymentRunnerImpl(IOProcessor ioProcessor) {
        this.ioProcessor = ioProcessor;
    }

    public void execute(DeploymentRequest request){
        request.steps.stream().forEach(step -> {
            System.out.println("Running Step: " +step.name);
            try {
                step.run(step, ioProcessor);
            } catch (IOException e) {
                System.out.println("Failed");
            }
            System.out.println("Completed");
        });
    }
}
