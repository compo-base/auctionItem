package se331.lab08_1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemOfBid {
    Long id;
    String type;
    String description;
}
// item of each bid
