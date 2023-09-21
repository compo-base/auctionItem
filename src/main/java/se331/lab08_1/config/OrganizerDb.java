package se331.lab08_1.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import se331.lab08_1.entity.Organizer;
import se331.lab08_1.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class OrganizerDb {
    final OrganizerRepository organizerRepository;
    @PostConstruct
    public void init(){
        organizerRepository.save(Organizer.builder()
                .name("Art Enthusiasts")
                .address("Street: Modern Art Lane, Apartment: 3B 10 West 91st Street")
                .description("Engage in modern art exhibitions and discussions.")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Tech Innovators")
                .address("Street: Silicon Boulevard, Apartment: 7A 34 North 45th Street")
                .description("Showcase of the latest tech innovations.")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Green Planet Advocates")
                .address("Street: Eco Avenue, Apartment: 2C 22 South 23rd Street")
                .description("Promotion of eco-friendly practices and green energy.")
                .build());


        organizerRepository.save(Organizer.builder()
                .name("Culinary Masters")
                .address("Street: Gourmet Way, Apartment: 5D 15 East 50th Street")
                .description("Showcasing world cuisines and culinary techniques.")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Book Lovers Club")
                .address("Street: Literature Lane, Apartment: 9E 101 West 15th Street")
                .description("Book readings, author discussions, and more.")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Science Explorers")
                .address("Street: Quantum Road, Apartment: 1F 66 North 67th Street")
                .description("Explore the wonders of science, from atoms to galaxies.")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Fitness Fanatics")
                .address("Street: Active Alley, Apartment: 4G 30 East 30th Street")
                .description("Yoga, aerobics, and other fitness events.")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("History Buffs")
                .address("Street: Time Travel Trail, Apartment: 8H 88 West 88th Street")
                .description("Diving deep into historical events and eras.")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Cinema Critics")
                .address("Street: Film Fest Boulevard, Apartment: 6I 55 South 55th Street")
                .description("Screenings and discussions on world cinema.")
                .build());

    }
}
