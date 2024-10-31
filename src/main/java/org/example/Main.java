package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final DeploymentRunner deploymentRunner;
    private final DeploymentFileReader deploymentFileReader;
    private final ObjectMapper objectMapper;

    public Main(DeploymentRunner deploymentRunner, DeploymentFileReader deploymentFileReader, ObjectMapper objectMapper) {
        this.deploymentRunner = deploymentRunner;
        this.deploymentFileReader = deploymentFileReader;
        this.objectMapper = objectMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(args.length == 0){
            System.out.println("Must provide deployment yaml");
            System.exit(1);
        }

        String data = deploymentFileReader.getDeploymentFile(args[1]+".");
        DeploymentRequest deployment = objectMapper.readValue(data, DeploymentRequest.class);
        deploymentRunner.execute(deployment);
    }
}
