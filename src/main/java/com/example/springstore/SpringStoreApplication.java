package com.example.springstore;

import com.example.springstore.model.Store;
import com.example.springstore.service.StoreService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
@EnableJpaRepositories
public class SpringStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringStoreApplication.class, args);


    }
}
