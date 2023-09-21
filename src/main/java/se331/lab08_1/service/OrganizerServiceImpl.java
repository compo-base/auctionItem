package se331.lab08_1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab08_1.dao.OrganizerDao;
import se331.lab08_1.entity.Organizer;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{

    final OrganizerDao eventDao;

    @Override
    public Integer getEventSize(){
        return eventDao.getEventSize();
    }

    @Override
    public Page<Organizer> getEvents(Integer pageSize, Integer page){
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Organizer getEvent(Long id){
        return eventDao.getEvent(id);
    }

    @Override
    public Organizer save(Organizer organizer){
        return eventDao.save(organizer);
    }

}