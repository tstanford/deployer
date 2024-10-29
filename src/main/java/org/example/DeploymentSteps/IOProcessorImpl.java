package org.example.DeploymentSteps;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class IOProcessorImpl implements IOProcessor {
    @Override
    public void delete(String src) throws IOException {
        Files.deleteIfExists(Path.of(src));
    }
    @Override
    public void copy(String src, String dest) throws IOException {
        Files.copy(Path.of(src), Path.of(dest));
    }
}
