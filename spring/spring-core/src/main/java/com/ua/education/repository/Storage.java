package com.ua.education.repository;

import com.ua.education.model.Event;
import com.ua.education.model.Ticket;
import com.ua.education.model.User;

import java.util.HashMap;
import java.util.Map;


public class Storage {

    private Map<String, Event> eventStorage;
    private Map<String, User> userStorage;
    private Map<String, Ticket> ticketStorage;

    public Map<String, Event> getEventStorage() {
        return eventStorage;
    }

    public Map<String, User> getUserStorage() {
        return userStorage;
    }

    public Map<String, Ticket> getTicketStorage() {
        return ticketStorage;
    }

    private void initStorage() {
        System.out.println("Spring Storage-object post-construct initialization");
        eventStorage = new HashMap<>();
        userStorage = new HashMap<>();
        ticketStorage = new HashMap<>();
    }
}
