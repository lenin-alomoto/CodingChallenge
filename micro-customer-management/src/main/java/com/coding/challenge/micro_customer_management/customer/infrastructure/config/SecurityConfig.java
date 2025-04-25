package com.coding.challenge.micro_customer_management.customer.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(request -> 
    			request.requestMatchers("/api/reports/**")
    			.permitAll()
    			.requestMatchers("/swagger-ui/**")
    			.permitAll()
    			.requestMatchers("/v3/api-docs/**")
    			.permitAll() 
    			.requestMatchers("/swagger-ui.html")
    			.permitAll()  
    			.requestMatchers("/swagger-ui.html")
    			.permitAll()
    			.requestMatchers("/actuator/**")
    			.authenticated()
    		)
    		.httpBasic(Customizer.withDefaults())
    		.csrf(csrf -> csrf.disable());
		return http.build();
	}

    @Bean
    UserDetailsService adminUser() {
    	User.UserBuilder user = User.builder();
    	UserDetails userAdministrator = user.username("springadmin")
    			.password(passwordEncoder().encode("security123"))
    			.roles()
    			.build();
    	
    	return new InMemoryUserDetailsManager(userAdministrator);
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
