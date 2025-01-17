package se.lexicon.workshoplibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.lexicon.workshoplibrary.repository.AppUserRepository;
import se.lexicon.workshoplibrary.repository.DetailsRepository;

@SpringBootApplication
public class WorkshopLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopLibraryApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(DetailsRepository detailsRepository, AppUserRepository userRepository) {
        return args -> {
            // Interact with App/Repos here.
        };
    }


}
