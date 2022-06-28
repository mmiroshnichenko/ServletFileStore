package org.mmyroshnychenko.repository;

import org.mmyroshnychenko.model.Event;
import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.model.User;

import java.util.List;

public interface EventRepository extends GenericRepository<Event, Long> {
    List<Event> getByUserAndFile(User user, File file);
}
