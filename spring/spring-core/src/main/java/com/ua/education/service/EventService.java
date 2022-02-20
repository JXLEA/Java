package com.ua.education.service;

import com.ua.education.dao.EventDao;
import com.ua.education.model.Event;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EventService {

    private EventDao eventDao;

    public Event getEventById(long eventId) {
        return eventDao.getEventById(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDao.getEventsByTitle(title);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDao.getEventsByDay(day);
    }

    public Event create(Event event) {
        return eventDao.put(event);
    }

    public Event update(Event event) {
        return eventDao.put(event);
    }

    public boolean delete(long eventId) {
        return Objects.nonNull(eventDao.delete(eventId));
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}

