package com.security.security;
import com.security.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()
public class SecurityApplication{

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {

		SpringApplication.run(SecurityApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//		User u1 = new User();
//		u1.setUsername("harry");
//		u1.setPassword("1234");
//		u1.setEmail("john@gmail.com");
//		u1.setRole("NORMAL");
//		this.userRepository.save(u1);
//	}
}
