package com.kgraudina.playground.manager;

import com.kgraudina.playground.manager.service.PlaygroundManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaygroundManagerApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(PlaygroundManagerApplication.class);

    @Autowired
    PlaygroundManagement playgroundManagement;

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(PlaygroundManagerApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        System.out.println("Welcome to the Playground Management application demo!");
        playgroundManagement.playgroundManagerInit();
    }
}