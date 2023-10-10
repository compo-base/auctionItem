package se331.lab08_1.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab08_1.entity.AuctionItem;
import se331.lab08_1.service.AuctionItemService;
import se331.lab08_1.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class AuctionItemController {

    final AuctionItemService auctionItemService;

    @GetMapping("items")
    public ResponseEntity<?> getAuctionItemLists(@RequestParam(value = "_limit",required = false)Integer perPage,
                                                 @RequestParam(value = "_page",required = false)Integer page,
                                                 @RequestParam(value = "title",required = false)String title,
                                                 @RequestParam(value = "amount",required = false)Double amount){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<AuctionItem> pageOutput;
        if (title == null) {
            pageOutput = auctionItemService.getAuctionItems(perPage,page);
        }
        else if(amount != null){
            pageOutput = auctionItemService.getAuctionItems(amount,PageRequest.of(page - 1, perPage));
        }
        else {
            pageOutput = auctionItemService.getAuctionItems(title, PageRequest.of(page-1,perPage));
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDto(pageOutput.getContent()),responseHeaders, HttpStatus.OK);

    }

    @GetMapping("items/{id}")
    public ResponseEntity<?> getAuctionItem(@PathVariable("id")Long id){
        AuctionItem output = auctionItemService.getAuctionItem(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItemDto(output));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the given id is not found");
        }
    }

}
