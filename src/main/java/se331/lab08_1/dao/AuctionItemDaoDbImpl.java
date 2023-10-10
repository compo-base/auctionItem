package se331.lab08_1.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab08_1.entity.AuctionItem;
import se331.lab08_1.repository.AuctionItemRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")

public class  AuctionItemDaoDbImpl implements AuctionItemDao{


        final AuctionItemRepository auctionItemRepository;

        @Override
        public Integer getAuctionItemSize(){
            return Math.toIntExact(auctionItemRepository.count());
        }

        @Override
        public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page){
            // Determine the total number of events in the database.
            long totalEvents = auctionItemRepository.count();

            // If pageSize is null, set it to the total number of events.
            pageSize = pageSize == null ? (int) totalEvents : pageSize;

            // If page is null, default to fetching the first page.
            page = page == null ? 0 : page - 1; // Convert to 0-based for Spring's PageRequest.

            // Use the PageRequest object to fetch the desired page of events from the database.
            return auctionItemRepository.findAll(PageRequest.of(page, pageSize));
        }

        @Override
        public AuctionItem getAuctionItem(Long id){
            return auctionItemRepository.findById(id).orElse(null);
        }

        @Override
        public AuctionItem save(AuctionItem event){
            return auctionItemRepository.save(event);
        }
        @Override
        public Page<AuctionItem> getAuctionItem(String name, Pageable page){
            return auctionItemRepository.findByTypeIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(name,name,page);
        }
    }



