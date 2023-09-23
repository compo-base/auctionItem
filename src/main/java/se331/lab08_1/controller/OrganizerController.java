package se331.lab08_1.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import se331.lab08_1.entity.Event;
import se331.lab08_1.entity.Organizer;
import se331.lab08_1.service.OrganizerService;

@Controller
@RequiredArgsConstructor
public class OrganizerController {

    final OrganizerService eventService;

    @GetMapping("organizer")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit",required = false)
                                           Integer perPage,@RequestParam(value = "_page",required = false)Integer page){
        Page<Organizer> pageOutput = eventService.getEvents(perPage,page);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(), responseHeaders, HttpStatus.OK);
    }
    @GetMapping("organizer/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id")Long id){
        Organizer output = eventService.getEvent(id);
        if(output != null){
            return ResponseEntity.ok(output);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the given id is not found");
        }
    }
    @PostMapping("/organizer")
    public ResponseEntity<?> addEvent(@RequestBody Organizer organize){
        Organizer output = eventService.save(organize);
        return ResponseEntity.ok(output);
    }




}
