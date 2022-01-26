package com.example.IBAN;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@EnableAutoConfiguration
@Configuration
public class IbanConfig {

/**
    @Bean
    CommandLineRunner commandLineRunner(IbanRepository ibanRepository){

        return args -> {
            Iban one = new Iban(
                    1L,
                    "AL47 2121 1009 0000",
                    1L

            );
            Iban two = new Iban(
                    "LT47 2123 5609 6090",
                    1L

            );
            ibanRepository.saveAll(List.of(one, two));
        };
    }**/
}
