package com.goldenshoe.onlinestore.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aliyussef on 02/05/2021
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "store-policy")
public class StorePolicy {
    private int returnPeriod;
}
