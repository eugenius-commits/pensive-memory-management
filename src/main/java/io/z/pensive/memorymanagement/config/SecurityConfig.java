package io.z.pensive.memorymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests 
                .requestMatchers("/api/public/**").permitAll() 
                .requestMatchers("/api/private/**").hasRole("ADMIN")
            );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
