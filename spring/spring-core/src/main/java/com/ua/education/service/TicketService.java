package com.ua.education.service;

import com.ua.education.dao.TicketDao;
import com.ua.education.model.Event;
import com.ua.education.model.Ticket;
import com.ua.education.model.User;
import com.ua.education.model.impl.TicketImpl;

import java.util.List;

public class TicketService {

    private TicketDao ticketDao;

    public Ticket book(long userId, long eventId, int place, Ticket.Category category) {
        Ticket ticket = new TicketImpl(userId, eventId, place, category);
        return ticketDao.book(ticket);
    }

    public List<Ticket> getBookedForUser(User user, int pageSize, int pageNum) {
        return ticketDao.getBookedForUser(user, pageSize, pageNum);
    }

    public List<Ticket> getBookedForEvent(Event event, int pageSize, int pageNum) {
        return ticketDao.getBookedForEvent(event, pageSize, pageNum);
    }

    public boolean cancel(long ticketId) {
        return ticketDao.cancel(ticketId);
    }

    public TicketDao getTicketDao() {
        return ticketDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }
}
