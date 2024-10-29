package org.example;

import org.example.DeploymentSteps.IOProcessor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeploymentRunner {

    private IOProcessor ioProcessor;

    public DeploymentRunner(IOProcessor ioProcessor) {
        this.ioProcessor = ioProcessor;
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
