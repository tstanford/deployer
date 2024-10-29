package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private DeploymentRunner deploymentRunner;

    public Main(DeploymentRunner deploymentRunner) {
        this.deploymentRunner = deploymentRunner;
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

        String data = Files.readString(Path.of(args[0]));
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        DeploymentRequest deployment = mapper.readValue(data, DeploymentRequest.class);
        deploymentRunner.Execute(deployment);
    }
}
