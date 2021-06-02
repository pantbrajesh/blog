package com.example.blog;

import com.example.blog.entities.Article;
import com.example.blog.entities.User;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(UserRepository userRepository, ArticleRepository articleRepository) {

		return args -> {
			User u = new User(1, "jcena", "John", "cena");

			userRepository.save(u);

			Article article1 = new Article();
			article1.setArticleId(1);
			article1.setAuthor(u);
			article1.setHeading("This is a sample article 1");
			article1.setContent("Lorem ipsum Lorem ipsum");
			article1.setPostSlug("This is post Slug");
			article1.setCreatedAt(new Date(System.currentTimeMillis()));

			articleRepository.save(article1);
		};
	}

}
