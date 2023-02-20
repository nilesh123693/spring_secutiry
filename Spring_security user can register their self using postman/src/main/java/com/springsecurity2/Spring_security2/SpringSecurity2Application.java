package com.springsecurity2.Spring_security2;

import com.springsecurity2.Spring_security2.model.User;
import com.springsecurity2.Spring_security2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurity2Application implements  CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setId(1);
		user1.setUserName("nilesh");
		user1.setPassword(passwordEncoder.encode("1234"));
		user1.setRole("ROLE_USER");
		user1.setEmail("nilesh@gmail.com");
		userRepository.save(user1);

		User user2 = new User();
		user2.setId(2);
		user2.setUserName("admin");
		user2.setPassword(passwordEncoder.encode("admin"));
		user2.setRole("ROLE_ADMIN");
		user2.setEmail("admin@gmail.com");
		userRepository.save(user2);
	}
}
