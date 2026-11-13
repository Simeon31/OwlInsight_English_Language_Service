package com.owlinsight.owlinsight_english_language_service;

import org.springframework.boot.SpringApplication;

public class TestOwlInsightEnglishLanguageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(OwlInsightEnglishLanguageServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
