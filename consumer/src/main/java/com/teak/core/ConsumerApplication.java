package com.teak.core;

import com.teak.core.email.SenderEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * The type Consumer application.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@SpringBootApplication
@EnableConfigurationProperties(SenderEntity.class)
public class ConsumerApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}