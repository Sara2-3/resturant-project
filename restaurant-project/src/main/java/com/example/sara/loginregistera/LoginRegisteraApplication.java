package com.example.sara.loginregistera;

import com.example.sara.loginregistera.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class LoginRegisteraApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginRegisteraApplication.class, args);

}
}
