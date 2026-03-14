package com.core.springboot_start.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public PostRepository postRepository(JpaPostRepository jpaPostRepository) {
        return jpaPostRepository;
    }
}
