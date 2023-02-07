package com.teak.core.email;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type Sender entity.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@ConfigurationProperties(prefix = "spring.mail")
@Data
public class SenderEntity {
    private String username;
}
