package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MainTest {

    private DeploymentRunnerImpl runner;
    private DeploymentFileReader reader;
    private ObjectMapper mapper;
    private String fileContents;

    @BeforeEach
    public void setup() throws IOException {
        runner = mock(DeploymentRunnerImpl.class);
        reader = mock(DeploymentFileReader.class);
        mapper = mock(ObjectMapper.class);
        fileContents = readFile();
    }

    @Test
    void shouldRunDeployment() throws Exception {
        DeploymentRequest deploymentRequest = new DeploymentRequest();
        when(reader.getDeploymentFile("test.yaml")).thenReturn(fileContents);
        when(mapper.readValue(fileContents, DeploymentRequest.class)).thenReturn(deploymentRequest);

        Main main = new Main(runner, reader, mapper);
        main.run("test.yaml");

        verify(runner).execute(deploymentRequest);
    }

    private String readFile() throws IOException {
        File file = new ClassPathResource("test.yaml").getFile();
        return new String(Files.readAllBytes(file.toPath()));
    }
}