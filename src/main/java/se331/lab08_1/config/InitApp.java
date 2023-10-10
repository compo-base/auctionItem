package se331.lab08_1.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab08_1.entity.AuctionItem;
import se331.lab08_1.entity.Bid;
import se331.lab08_1.repository.AuctionItemRepository;
import se331.lab08_1.repository.BidRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem item;
        Bid bid;
        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Antique Vase")
                .description("A beautifully crafted porcelain vase from the 18th century.")
                .build());
        bid = bidRepository.save(Bid.builder().amount(1000).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(1200).item(item).build());
        Bid highestBidForItem1 = bidRepository.save(Bid.builder().amount(1300).datetime("2023-10-10 12:10:10").item(item).build());
        item.setSuccessfulBid(highestBidForItem1);
        item.getBids().addAll(List.of(bid, bid, highestBidForItem1));

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Vintage Car")
                .description("A classic 1950s sports car in mint condition.")
                .build());

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Diamond Necklace")
                .description("A stunning necklace featuring a 5-carat diamond centerpiece.")
                .build());

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Signed Book")
                .description("A book signed by a famous author.")
                .build());

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Painting")
                .description("A painting by a renowned artist.")
                .build());

    }
}