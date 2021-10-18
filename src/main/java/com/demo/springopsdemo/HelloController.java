package com.demo.springopsdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${application.message:Not configured by a Spring Cloud Server}")
    private String message;

    @Value("${SPRING_DATASOURCE_USERNAME: SPRING_DATASOURCE_USERNAME didn't work}")
    private String userName;

    @Value("${database-username: database-username didn't work}")
    private String userNameFromSecret;

    @GetMapping("/hello")
    public String hello() {
        return message + '\n';
    }

    @GetMapping("/env")
    public String getEnv(String v) {
        return System.getenv(v);
    }

    @GetMapping("/vars")
    public String getVars(){
        return userName + " | " + userNameFromSecret;
    }

}