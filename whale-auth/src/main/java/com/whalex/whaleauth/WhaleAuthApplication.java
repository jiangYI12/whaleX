package com.whalex.whaleauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class WhaleAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhaleAuthApplication.class, args);
    }

}
