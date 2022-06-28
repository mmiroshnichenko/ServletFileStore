package org.mmyroshnychenko.service;

import org.junit.Test;
import org.mmyroshnychenko.model.Event;
import org.mmyroshnychenko.model.EventType;
import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.repository.EventRepository;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EventServiceTest {
    private EventRepository mockEventRepository = Mockito.mock(EventRepository.class);
    private EventService eventService = new EventService(mockEventRepository);
    Date date = new Date();

    private File getFile() {
        return new File(1L, "testName", "testPath", date, date);
    }

    private User getUser() {
        return new User(1L, "michael");
    }

    private Event getEvent() {
        return new Event(1L, getUser(), getFile(), date, EventType.CREATE);
    }

    private List<Event> getEventList() {
        List<Event> events = new ArrayList<>();
        events.add(getEvent());
        return events;
    }

    @Test
    public void shouldSaveEventTest() {
        Event newEvent = new Event();
        newEvent.setFile(getFile());
        newEvent.setUser(getUser());
        newEvent.setCreated(date);
        newEvent.setType(EventType.CREATE);

        Mockito.when(mockEventRepository.save(newEvent)).thenReturn(getEvent());
        Event savedMockEvent = eventService.save(newEvent);

        assertEquals(savedMockEvent, getEvent());
    }

    @Test
    public void shouldGetByUserAndFile() {
        Mockito.when(mockEventRepository.getByUserAndFile(getUser(), getFile())).thenReturn(getEventList());
        List<Event> mockEvents = eventService.getByUserAndFile(getUser(), getFile());

        assertEquals(mockEvents, getEventList());
    }
}
