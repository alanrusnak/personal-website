package com.alanrusnak.personalwebsite;

import com.alanrusnak.personalwebsite.models.Post;
import com.alanrusnak.personalwebsite.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PostRepository repository) {
        return (args) -> {
            // save a couple of customers
            Post newPost = new Post();
            newPost.setTitle("Title");
            newPost.setHtmlContent("Hello this is post content");
            repository.save(newPost);
            newPost = new Post();
            newPost.setTitle("Title2");
            newPost.setHtmlContent("Hello this is post content2");
            repository.save(newPost);
            newPost = new Post();
            newPost.setTitle("Title3");
            newPost.setHtmlContent("Hello this is post content3");
            repository.save(newPost);

            for (Post customer : repository.findAll()) {
                System.out.println(customer.toString());
            }


        };
    }

}