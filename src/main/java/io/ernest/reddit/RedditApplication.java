package io.ernest.reddit;

import io.ernest.reddit.config.SpringitProperties;
import io.ernest.reddit.domain.Comment;
import io.ernest.reddit.domain.Link;
import io.ernest.reddit.repository.CommentRepository;
import io.ernest.reddit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class RedditApplication {

	@Autowired
	private SpringitProperties springitProperties;

	public static void main(String[] args) {
		SpringApplication.run(RedditApplication.class, args);
	}

	//@Bean
	@Profile("dev")
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			Link link = new Link("Getting started with Spring Boot 2", "sdffds");
			linkRepository.save(link);
			Comment comment = new Comment("Ameising course",link);
			commentRepository.save(comment);
			link.addComment(comment);

		};
	}

}
