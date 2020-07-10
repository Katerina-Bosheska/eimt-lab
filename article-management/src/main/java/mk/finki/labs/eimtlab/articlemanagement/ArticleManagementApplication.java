package mk.finki.labs.eimtlab.articlemanagement;

import mk.finki.labs.eimtlab.sharedkernel.SharedConfiguration;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.xml.validation.Validator;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@Import(SharedConfiguration.class)
public class ArticleManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleManagementApplication.class, args);
    }

}
