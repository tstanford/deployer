package org.example;


import org.springframework.stereotype.Component;

@Component
public interface DeploymentRunner {
    void execute(DeploymentRequest request);
}
