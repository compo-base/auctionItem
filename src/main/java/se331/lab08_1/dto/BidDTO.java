package se331.lab08_1.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab08_1.entity.AuctionItem;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidDTO {
    Long id;
    Integer amount;
    String datetime;
    AuctionItemOfBid item;
}
