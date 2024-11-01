package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeploymentConfig {

    @Bean
    public ObjectMapper getYamlObjectMapper(){
        return new ObjectMapper(new YAMLFactory());
    }
}
