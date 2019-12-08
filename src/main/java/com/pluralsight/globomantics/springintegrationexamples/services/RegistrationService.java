package com.pluralsight.globomantics.springintegrationexamples.services;

import com.pluralsight.globomantics.springintegrationexamples.model.Event;

public interface RegistrationService {
    void notifyObservers(Event event);
}
