package com.github.prakasit.springk8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class SpringK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringK8sApplication.class, args);
    }

}
