package org.example;

import org.example.DeploymentSteps.IOProcessor;
import org.example.DeploymentSteps.IOProcessorImpl;

import java.io.IOException;

public class DeploymentRunner {
    private IOProcessor ioProcessor;

    public DeploymentRunner() {
        ioProcessor = new IOProcessorImpl();
    }

    public void Execute(DeploymentRequest request){
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
