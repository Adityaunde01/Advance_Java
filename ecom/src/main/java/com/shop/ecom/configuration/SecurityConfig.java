package com.shop.ecom.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.shop.ecom.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public MyUserDetailService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
		
		return http.csrf(AbstractHttpConfigurer::disable)
			  .authorizeHttpRequests(req->req.anyRequest().authenticated())
			  .httpBasic(Customizer.withDefaults())
			  .sessionManagement(sesssion->sesssion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			  .build();
		
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		
		return provider;
	}
}
