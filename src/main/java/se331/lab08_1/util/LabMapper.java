package se331.lab08_1.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab08_1.dto.AuctionItemDTO;
import se331.lab08_1.dto.BidDTO;
import se331.lab08_1.entity.AuctionItem;
import se331.lab08_1.entity.Bid;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    AuctionItemDTO getAuctionItemDto(AuctionItem item);
    List<AuctionItemDTO> getAuctionItemDto(List<AuctionItem> item);
    BidDTO getBitDto(Bid bid);
    List<BidDTO> getBitDto(List<Bid> bid);


}
