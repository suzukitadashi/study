package com.example.todolistAtSpring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate


@SpringBootApplication
class TodolistAtSpringApplication {

    @Bean
    fun commandLineRunner(jdbcTemplate: JdbcTemplate) = CommandLineRunner {
        jdbcTemplate.execute("""CREATE TABLE IF NOT EXISTS task(
            id BIGINT PRIMARY KEY AUTO_INCREMENT,
            content VARCHAR(100) NOT NULL,
            done BOOLEAN NOT NULL DEFAULT FALSE
        )""")
    }

}



fun main(args: Array<String>) {
    SpringApplication.run(TodolistAtSpringApplication::class.java, *args)
}
