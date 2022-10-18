package com.example.basicCaching;

import com.example.basicCaching.model.Book;
import com.example.basicCaching.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BasicCachingApplication {

//	@Autowired
//	private com.example.basicCaching.repository.bookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BasicCachingApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		Book u1 = new Book();
//		u1.setAuthor("Ironman");
//		u1.setCategory("action");
//		u1.setEdition("2018");
//		u1.setPublisher("ask");
//		u1.setName("the Ironman");
//		this.bookRepository.save(u1);
//	}

}
