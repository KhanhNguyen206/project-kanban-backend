package com.khanhnn.kanbanwebservice;

import com.khanhnn.kanbanwebservice.service.BacklogService;
import com.khanhnn.kanbanwebservice.service.impl.BacklogServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KanbanWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KanbanWebServiceApplication.class, args);
    }

    @Bean
    public BacklogService backlogService(){
        return new BacklogServiceImpl();
    }
}
