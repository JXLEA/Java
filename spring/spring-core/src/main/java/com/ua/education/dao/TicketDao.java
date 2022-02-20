package com.ua.education.dao;

import com.ua.education.model.Event;
import com.ua.education.model.Ticket;
import com.ua.education.model.User;
import com.ua.education.repository.Storage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class TicketDao {

    private Storage storage;

    public Ticket book(Ticket ticket) {
        long id = storage.getTicketStorage().values().size() + 1;
        ticket.setId(id);
        return storage.getTicketStorage().put(String.format("ticket: %s ", ticket.getId()), ticket);
    }

    public List<Ticket> getBookedForUser(User user, int pageSize, int pageNum) {
        int indexFrom = pageNum * pageSize;
        return storage.getTicketStorage().values()
                .stream()
                .filter(ticket -> Objects.equals(user.getId(), ticket.getUserId()))
                .collect(Collectors.toList())
                .subList(indexFrom, indexFrom + pageSize);
    }

    public List<Ticket> getBookedForEvent(Event event, int pageSize, int pageNum) {
        int indexFrom = pageNum * pageSize;
        return storage.getTicketStorage().values()
                .stream()
                .filter(ticket -> Objects.equals(event.getId(), ticket.getEventId()))
                .collect(Collectors.toList())
                .subList(indexFrom, indexFrom + pageSize);
    }

    public boolean cancel(long ticketId) {
        return Objects.nonNull(storage.getTicketStorage().remove(String.format("ticket: %s ", ticketId)));
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
