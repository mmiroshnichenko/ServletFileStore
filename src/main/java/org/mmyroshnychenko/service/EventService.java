package org.mmyroshnychenko.service;

import org.mmyroshnychenko.model.Event;
import org.mmyroshnychenko.model.EventType;
import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.repository.EventRepository;
import org.mmyroshnychenko.repository.impl.HibernateEventRepositoryImpl;

import java.util.Date;
import java.util.List;

public class EventService {
    private EventRepository eventRepository;

    public EventService() {
        this.eventRepository = new HibernateEventRepositoryImpl();
    }

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event saveNew(File file, User user, EventType type) {
        Event event = new Event();
        event.setFile(file);
        event.setUser(user);
        event.setCreated(new Date());
        event.setType(type);
        return this.save(event);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event saveCreated(File file, User user) {
        return saveNew(file, user, EventType.CREATE);
    }

    public Event saveUpdated(File file, User user) {
        return saveNew(file, user, EventType.UPDATE);
    }

    public List<Event> getByUserAndFile(User user, File file) {
        return eventRepository.getByUserAndFile(user, file);
    }
}
