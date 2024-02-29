package com.ritesh.boot.todo.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager configureUser() {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails user = User.builder().passwordEncoder(passwordEncoder).username("Ritesh").password("rrr")
				.roles("USER", "ADMIN").build();

		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
