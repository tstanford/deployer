package org.example;

import org.springframework.stereotype.Component;

public interface DeploymentFileReader {
    String getDeploymentFile(String path);
}
