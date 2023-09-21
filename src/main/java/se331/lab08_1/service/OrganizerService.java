package se331.lab08_1.service;

import org.springframework.data.domain.Page;
import se331.lab08_1.entity.Organizer;

public interface OrganizerService {
    Integer getEventSize();
    Page<Organizer> getEvents(Integer pageSize, Integer page);
    Organizer getEvent(Long id);
    Organizer save(Organizer event);
}
