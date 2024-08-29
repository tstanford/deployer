package org.example.DeploymentSteps;

import java.io.IOException;

public interface IOProcessor {
    void delete(String src) throws IOException;

    void copy(String src, String dest) throws IOException;
}
