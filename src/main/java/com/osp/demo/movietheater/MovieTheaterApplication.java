package com.osp.demo.movietheater;

import com.osp.demo.movietheater.builder.MovieBuilder;
import com.osp.demo.movietheater.domain.MovieStatus;
import com.osp.demo.movietheater.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class MovieTheaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieTheaterApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MovieRepository movieRepository) {
        return args -> Arrays.asList("Frank Rodríguez", "Hugo Gonzáles", "Jhon Díaz")
                .forEach(name -> {
                            movieRepository.save(new MovieBuilder()
                                    .fullName(name)
                                    .publishingDate(LocalDateTime.now().toString())
                                    .status(MovieStatus.ACTIVE.toString())
                                    .build());
                            movieRepository.findAll();
                        }
                );
    }
}
