package com.pluralsight.globomantics.springintegrationexamples.eventlisteners;

import com.pluralsight.globomantics.springintegrationexamples.model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class EventListenerOne {
    private static final Logger logger = LogManager.getLogger(EventListenerOne.class);

    @ServiceActivator(inputChannel = "eventChannel")
    public void receivedEvent(Message<Event> message) {
        IntegrationMessageHeaderAccessor accessor = new IntegrationMessageHeaderAccessor(message);
        long expirationDate = accessor.getExpirationDate();
        logger.info("EventListenerOne::received event: {}, expires: {}", message.getPayload(), expirationDate);
    }
}
