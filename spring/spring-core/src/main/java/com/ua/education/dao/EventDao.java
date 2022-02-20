package com.ua.education.dao;

import com.ua.education.model.Event;
import com.ua.education.repository.Storage;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EventDao {

    private Storage storage;

    public Event getEventById(long eventId) {
        return storage.getEventStorage().get(String.format("event: %s", eventId));
    }

    public List<Event> getEventsByTitle(String title) {
        return storage.getEventStorage().values()
                .stream()
                .filter(event -> title.equals(event.getTitle()))
                .collect(Collectors.toList());
    }

    public List<Event> getEventsByDay(Date day) {
        return storage.getEventStorage().values()
                .stream()
                .filter(event -> day.compareTo(event.getDate()) == 0)
                .collect(Collectors.toList());
    }

    public Event put(Event event) {
        event.setId(event.getId() == 0 ? storage.getTicketStorage().values().size() + 1 : event.getId());
        return storage.getEventStorage().put(String.format("event: %s", event.getId()), event);
    }

    public Event delete(long eventId) {
        return storage.getEventStorage().remove(String.format("event: %s", eventId));
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
