package se331.lab08_1.service;

import org.springframework.data.domain.Page;
import se331.lab08_1.entity.AuctionItem;

public interface AuctionItemService {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem event);
}
