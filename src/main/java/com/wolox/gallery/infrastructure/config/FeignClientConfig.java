package com.wolox.gallery.infrastructure.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.wolox.gallery.infrastructure.adapter.placeholder.feing")
public class FeignClientConfig {
}
