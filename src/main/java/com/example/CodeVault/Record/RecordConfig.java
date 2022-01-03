package com.example.CodeVault.Record;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecordConfig {

    @Bean
    CommandLineRunner commandLineRunner(RecordRepository repository){
        return args -> {
            Record pook = new Record(
                    1L,
                    "Eurobank",
                    "pook",
                    "123456");

            Record pipis = new Record(
                    2L,
                    "Instagram",
                    "pipis",
                    "123456");

            repository.saveAll(List.of(pook, pipis));
        };
    }
}
