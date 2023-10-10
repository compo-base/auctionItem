package se331.lab08_1.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab08_1.entity.AuctionItem;
import se331.lab08_1.entity.Bid;
import se331.lab08_1.repository.AuctionItemRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem item;
        item = auctionItemRepository.save(AuctionItem.builder()
                .type("Antique Vase")
                .description("A beautifully crafted porcelain vase from the 18th century.")
                .build());

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