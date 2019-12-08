package com.pluralsight.globomantics.springintegrationexamples.config;

import com.pluralsight.globomantics.springintegrationexamples.model.Event;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "eventGateway", defaultRequestChannel = "eventChannel")
public interface EventGateway {
    @Gateway
    void publishEvent(Message<Event> message);
}
