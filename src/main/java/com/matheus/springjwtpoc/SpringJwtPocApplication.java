package com.matheus.springjwtpoc;

import com.matheus.springjwtpoc.domain.AppUser;
import com.matheus.springjwtpoc.domain.Role;
import com.matheus.springjwtpoc.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtPocApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_MANAGER"));
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser("User 1", "user1@email.com", "user1", new ArrayList<>()));
			userService.saveUser(new AppUser("User 2", "user2@email.com", "user2", new ArrayList<>()));
			userService.saveUser(new AppUser("User 3", "user3@email.com", "user3", new ArrayList<>()));
			userService.saveUser(new AppUser("User 4", "user4@email.com", "user4", new ArrayList<>()));

			userService.addRoleToUser("user1@email.com", "ROLE_USER");
			userService.addRoleToUser("user1@email.com", "ROLE_MANAGER");
			userService.addRoleToUser("user2@email.com", "ROLE_MANAGER");
			userService.addRoleToUser("user3@email.com", "ROLE_ADMIN");
			userService.addRoleToUser("user4@email.com", "ROLE_USER");
			userService.addRoleToUser("user4@email.com", "ROLE_ADMIN");
			userService.addRoleToUser("user4@email.com", "ROLE_SUPER_ADMIN");
		};
	}
}
