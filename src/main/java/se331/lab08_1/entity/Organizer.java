package se331.lab08_1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import jakarta.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {
    @Id // identifies the field as the primary key of the database table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use with the @Id annotation to specify how the primary key should be generated.
    @EqualsAndHashCode.Exclude //auto-generates the equals() and hashCode() methods
    Long id;
    String name;
    String address;
    String description;


}