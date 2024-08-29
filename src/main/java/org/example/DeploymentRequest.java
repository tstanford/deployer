package org.example;

import org.example.DeploymentSteps.DeploymentStep;

import java.util.List;

public class DeploymentRequest {
    public String ticketNumber;
    public String description;
    public List<EnvironmentConfig> environments;
    public List<DeploymentStep> steps;
}
