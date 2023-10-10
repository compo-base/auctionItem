package se331.lab08_1.config;


import jakarta.transaction.Transactional;
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
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem item;
        Bid bid;
        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Antique Vase")
                .description("A beautifully crafted porcelain vase from the 18th century.")
                .build());
        bid = bidRepository.save(Bid.builder().amount(1000).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(1200).item(item).build());
        Bid highestBidForItem1 = bidRepository.save(Bid.builder()
                .amount(1300)
                .item(item)
                .build());
        item.setSuccessfulBid(highestBidForItem1);
        item.getBids().addAll(List.of(bid, bid, highestBidForItem1));

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Vintage Car")
                .description("A classic 1950s sports car in mint condition.")
                .build());
        bid = bidRepository.save(Bid.builder().amount(50000).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(52000).item(item).build());
        Bid successfulBid2 = bidRepository.save(Bid.builder()
                .amount(53000)
                .item(item)
                .build());
        item.setSuccessfulBid(successfulBid2);
        item.getBids().addAll(List.of(bid, bid, successfulBid2));

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Diamond Necklace")
                .description("A stunning necklace featuring a 5-carat diamond centerpiece.")
                .build());
        bid = bidRepository.save(Bid.builder().amount(15000).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(15200).item(item).build());
        Bid successfulBid3 = bidRepository.save(Bid.builder()
                .amount(15300)
                .item(item)
                .build());
        item.setSuccessfulBid(successfulBid3);
        item.getBids().addAll(List.of(bid, bid, successfulBid3));

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Signed Book")
                .description("A book signed by a famous author.")
                .build());
        bid = bidRepository.save(Bid.builder().amount(200).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(220).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(230).item(item).build());
        item.getBids().addAll(List.of(bid, bid, bid));

        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Painting")
                .description("A painting by a renowned artist.")
                .build());
        bid = bidRepository.save(Bid.builder().amount(5000).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(5200).item(item).build());
        bid = bidRepository.save(Bid.builder().amount(5300).item(item).build());
        item.getBids().addAll(List.of(bid, bid, bid));

    }
}