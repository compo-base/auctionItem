package se331.lab08_1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab08_1.entity.AuctionItem;
import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem,Long> {
    List<AuctionItem> findAll();
    Page<AuctionItem> findByDescription(String description, Pageable page);
    Page<AuctionItem> findByDescriptionContaining(String description, Pageable page);
    Page<AuctionItem> findByTypeIgnoreCaseContainingOrDescriptionIgnoreCaseContaining (String type,String description, Pageable page);
    Page<AuctionItem> findBySuccessfulBidAmountLessThan(Double amount, Pageable pageRequest);

}
