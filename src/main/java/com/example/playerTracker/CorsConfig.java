package com.example.playerTracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from the specified origins
        config.setAllowedOrigins(List.of("http://localhost:3000"));

        // Allow specific HTTP methods (e.g., GET, POST, PUT)
        config.addAllowedMethod("*");

        // Allow specific headers (e.g., Authorization)
        config.addAllowedHeader("*");

        // Whether the browser should include credentials (e.g., cookies) in CORS requests
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
