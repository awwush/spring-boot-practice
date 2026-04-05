package com.codingshuttle.springbootpractice;

import com.codingshuttle.springbootpractice.module1.CakeBaker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPracticeApplication implements CommandLineRunner {

    private final CakeBaker cakeBaker;

    public SpringBootPracticeApplication(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cakeBaker.bakeCake();
    }
}
