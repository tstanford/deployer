package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Must provide deployment yaml");
            System.exit(1);
        }

        String data = Files.readString(Path.of(args[0]));
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        DeploymentRequest deployment = mapper.readValue(data, DeploymentRequest.class);
        DeploymentRunner runner = new DeploymentRunner();
        runner.Execute(deployment);


    }
}
