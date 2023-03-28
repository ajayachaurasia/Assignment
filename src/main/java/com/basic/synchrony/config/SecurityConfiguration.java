package com.basic.synchrony.config;

import com.basic.synchrony.service.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity //In Spring Security 5.6, we can enable annotation-based security using the @EnableMethodSecurity annotation on any @Configuration instance. @EnableMethodSecurity enables @PreAuthorize, @PostAuthorize, @PreFilter, and @PostFilter by default.
public class SecurityConfiguration {

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //Spring security provided BCryptPasswordEncoder class to encrypt the passwords
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        //authorize.anyRequest().authenticated()
                        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll() //allowing anyone to access login REST API with this security configuration
                                .requestMatchers("/api/user-auth/**").permitAll()
                                .anyRequest().authenticated()

                );

        return http.build();
    }
}
