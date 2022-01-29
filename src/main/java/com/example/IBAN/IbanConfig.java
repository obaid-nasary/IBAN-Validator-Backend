package com.example.IBAN;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
