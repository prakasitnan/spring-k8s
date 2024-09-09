package com.github.prakasit.springk8s.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@Log4j2
public class DemoController {

    @Value("${app.version}")
    private String version;



    @GetMapping({"", "/api/info"})
    public Map<String, String> apiInfo() {
        log.info("Request for apiInfo at : {}", LocalDateTime.now());
        return Map.of("app", "K8S SpringBoot Demo",
                "hostName", getHostname(),
                "version", version);
    }

    @GetMapping("/api/terminate")
    public String terminate() {
        log.info("Request for terminate at : {}", LocalDateTime.now());
        System.exit(1);
        return "I'll be BACK";
    }

    private String getHostname() {
        String hostName = "Unknown";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostName = addr.getHostName();
        } catch (Exception e) {
            log.error("Error in getting hostname", e);
        }
        return hostName;
    }

}
