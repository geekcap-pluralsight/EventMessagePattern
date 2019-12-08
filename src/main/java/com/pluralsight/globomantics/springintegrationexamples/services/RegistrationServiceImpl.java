package com.pluralsight.globomantics.springintegrationexamples.services;

import com.pluralsight.globomantics.springintegrationexamples.config.EventGateway;
import com.pluralsight.globomantics.springintegrationexamples.model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = LogManager.getLogger(RegistrationService.class);

    @Autowired
    private EventGateway eventGateway;

    @Override
    public void notifyObservers(Event event) {
        logger.info("Publishing event {}", event);
        Message<Event> message = MessageBuilder.withPayload(event)
                .setHeader(IntegrationMessageHeaderAccessor.EXPIRATION_DATE, System.currentTimeMillis() + 60 * 60 * 1000)
                .build();
        eventGateway.publishEvent(message);
    }
}
