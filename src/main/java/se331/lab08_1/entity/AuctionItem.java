package se331.lab08_1.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String type;
    String description;
    @OneToMany(mappedBy ="item")
    List<Bid> bids;
    @OneToOne
    Bid successfulBid;

}
