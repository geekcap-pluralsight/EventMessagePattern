package com.pluralsight.globomantics.springintegrationexamples;

import com.pluralsight.globomantics.springintegrationexamples.model.Event;
import com.pluralsight.globomantics.springintegrationexamples.services.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIntegrationExamplesApplication implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(SpringIntegrationExamplesApplication.class);

    @Autowired
    private RegistrationService registrationService;

    @Override
    public void run(String... args) throws Exception {
        registrationService.notifyObservers(new Event("Event-1", "New Event"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationExamplesApplication.class, args);
    }
}
