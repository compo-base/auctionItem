package se331.lab08_1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab08_1.entity.AuctionItem;

public interface AuctionItemDao {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem item);
    Page<AuctionItem> getAuctionItem(String name, Pageable page);
    Page<AuctionItem> getAuctionItem(Double amount, Pageable page);
}

