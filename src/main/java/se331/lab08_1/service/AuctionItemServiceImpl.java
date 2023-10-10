package se331.lab08_1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab08_1.dao.AuctionItemDao;
import se331.lab08_1.entity.AuctionItem;

@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {

    final AuctionItemDao auctionItemDao;

    @Override
    public Integer getAuctionItemSize(){
        return auctionItemDao.getAuctionItemSize();
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page){
        return auctionItemDao.getAuctionItems(pageSize, page);
    }

    @Override
    public AuctionItem getAuctionItem(Long id){
        return auctionItemDao.getAuctionItem(id);
    }
    @Override
    public AuctionItem save(AuctionItem event){
        return auctionItemDao.save(event);
    }


}
