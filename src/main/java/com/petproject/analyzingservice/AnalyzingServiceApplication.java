package com.petproject.analyzingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Основной класс микросервиса для сбора статистики.
 * Предоставляет функционал сбора статистики и сохранения её в базу данных.
 *
 * @author Egor Nazarev
 */
@SpringBootApplication
public class AnalyzingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalyzingServiceApplication.class, args);
    }

}
