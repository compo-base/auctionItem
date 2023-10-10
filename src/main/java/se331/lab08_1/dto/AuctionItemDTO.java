package se331.lab08_1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab08_1.entity.Bid;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDTO {
    Long id;
    String type;
    String description;
    List<BidOfAuctionItem> bids = new ArrayList<>();
   AuctionItemOfSuccessBidDTO successfulBid = null;
}
