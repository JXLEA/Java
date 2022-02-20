package com.ua.education.facade;

import com.ua.education.model.Event;
import com.ua.education.model.Ticket;
import com.ua.education.model.User;
import com.ua.education.service.EventService;
import com.ua.education.service.TicketService;
import com.ua.education.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BookingFacadeImpl implements BookingFacade {

    private final EventService eventService;
    private final TicketService ticketService;
    private final UserService userService;

    public BookingFacadeImpl(EventService eventService, TicketService ticketService, UserService userService) {
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.create(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.update(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.delete(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        User created = userService.create(user);
        return Objects.isNull(created) ? user : created;
    }

    @Override
    public User updateUser(User user) {
        return userService.update(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.delete(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.book(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedForUser(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
       return ticketService.getBookedForEvent(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancel(ticketId);
    }
}
