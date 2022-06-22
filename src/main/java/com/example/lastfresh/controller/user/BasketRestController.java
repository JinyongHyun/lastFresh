package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.service.user.BasketService;
import com.example.lastfresh.service.user.MyPageService;
import com.example.lastfresh.service.user.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* 장바구니 */

//@Controller
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/cart/*")
public class BasketRestController {
    private final OrderService orderService;
    private final MyPageService myPageService;
    private final BasketService basketService;

    @GetMapping("/orderCart/count/{userNum}")
    public int count(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.count(userNum);
    }

    //   get list for delivery items
    @GetMapping("/orderCart/pickUp/{userNum}")
    public List<BasketDTO> getPickUpList(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.getListPickUp(userNum);
    }

    //   get list for pick up items
    @GetMapping("/orderCart/delivery/{userNum}")
    public List<BasketDTO> getDeliveryList(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.getListDelivery(userNum);
    }

    //   get list for shipping items
    @GetMapping("/orderCart/shipping/{userNum}")
    public List<BasketDTO> getShippingList(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.getListShipping(userNum);
    }

    //    delete product
    @DeleteMapping("/orderCart/{basketNum}")
    public void remove(@PathVariable("basketNum") Long basketNum){
        basketService.remove(basketNum);
        //!!!!!!!!!!!!!!!!!!!! increase stock
    }

    // deleteAll products
    @DeleteMapping("/orderCart/removeAll/{userNum}")
    public void removeAll(@PathVariable("userNum") Long userNum){
        basketService.removeAll(userNum);
        ////////////////// increase stock for all
    }


  // when you add product / there is limit
  // when you minus product / there is limit = 1

  // @PatchMapping(value = {"/{rno}", "/{rno}/{replier}"}, consumes = "application/json")
    @PatchMapping("/orderCart/add/{basketNum}")
    public void quantityAdd(@PathVariable("basketNum") Long basketNum){
        basketService.addQuantity(basketNum);
    }

    @PatchMapping("/orderCart/subtract/{basketNum}")
    public void quantitySubtract(@PathVariable("basketNum") Long basketNum){
        basketService.subtractQuantity(basketNum);
    }

    @PatchMapping("/orderCart/check/{basketNum}")
    public void check(@PathVariable("basketNum") Long basketNum){
        basketService.check(basketNum);
    }

    @PatchMapping("/orderCart/checkAll/{userNum}")
    public void checkAll(@PathVariable("userNum") Long userNum){
        basketService.checkAll(userNum);
    }

    @PatchMapping("/orderCart/unCheckAll/{userNum}")
    public void unCheckAll(@PathVariable("userNum") Long userNum){
        basketService.unCheckAll(userNum);
    }
 /*

    @PatchMapping(value = {"/{rno}", "/{rno}/{replier}"}, consumes = "application/json")
    public String modify(@RequestBody ReplyVO replyVO, @PathVariable(value = "replier", required = false) String replier, @PathVariable("rno") Long rno){
        log.info("modify.........." + replyVO);
        if (replyVO.getReplier() == null){ //json 검사
            replyVO.setReplier(Optional.ofNullable(replier).orElse("anonymous")); // uri 검사
        }
        replyVO.setRno(rno);
        return replyService.modify(replyVO) ? "댓글 수정 성공" : "댓글 수정 실패";
    }*/
}
