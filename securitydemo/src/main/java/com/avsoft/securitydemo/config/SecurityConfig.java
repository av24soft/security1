package com.avsoft.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.
		authorizeHttpRequests(auth -> auth.requestMatchers("/helloadmin")
				.hasRole("ADMIN").anyRequest().authenticated())
				.formLogin(form -> form.permitAll())
				.logout(lg -> lg.permitAll());
		
				

		return httpSecurity.build();
	}
	@Bean
	public UserDetailsService userDetailsService()
	{
	UserDetails  user =User.builder().username("avsoft").password(passwordEncoder().encode("abc"))
			.roles("USER").build();
	
	UserDetails  admin =User.builder().username("admin").password(passwordEncoder().encode("admin"))
			.roles("ADMIN").build();
	
	return new InMemoryUserDetailsManager(user,admin);
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
