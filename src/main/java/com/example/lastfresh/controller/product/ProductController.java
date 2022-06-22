package com.example.lastfresh.controller.product;


import com.example.lastfresh.domain.dto.ProductPageDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/categorySort")
    public void categorySort(String categoryName,CriteriaProduct criteriaProduct,String type, Model model){
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        Long categoryNum = productService.getCategoryNum(categoryName);
        log.info("카테고리솔트 들어옴------------------------------------------------------------------------------------");
        log.info("/pos/getList실행");

        log.info("criteria : " + criteriaProduct.toString() + type);
        log.info("카테고리 이름: " + categoryName);

        String status1 = null;
        String status2 = null;
        String status3 = "true";
        String check = null;
        log.info("비교 들어가기전---------"+type);
        log.info(type);
        if (type != null) {
            status3 = null;
            if (type.equals("낮은가격")) {
                status1 = "true";
                check = "낮은가격";
            }
            if (type.equals("높은가격")) {
                status2 = "true";
                check = "높은가격";
            }
            if (type.equals("신상품")) {
                status3 = "true";
                check = "신상품";
            }
        }

        log.info("비교 들어간후---------"+type);
        HashMap<String, String> typeList = new HashMap<>();
        typeList.put("status1", status1);
        typeList.put("status2", status2);
        typeList.put("status3", status3);

        log.info("카테고리넘버" +categoryNum + "-----------");
        log.info("카테고리프로덕트" +criteriaProduct + "-----------");



        HashMap<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("criteriaProduct", criteriaProduct);
        categoryMap.put("type", typeList);
        categoryMap.put("categoryNum", categoryNum);


        model.addAttribute("check", check);
        model.addAttribute("categoryName",categoryName);
        model.addAttribute("list", productService.getCategoryList(categoryMap));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotalCategory(categoryMap)));
        model.addAttribute("getTotal",productService.getTotalCategory(categoryMap));
    }

    @GetMapping("/proDelivery")
    public void proDelivery(CriteriaProduct criteriaProduct, String type, Model model)throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());

        log.info("/pos/getList실행");
        log.info("criteria : " + criteriaProduct.toString() + type);

        String status1 = null;
        String status2 = null;
        String status3 = "true";
        String check = null;
        log.info("비교 들어가기전---------" + type);
        log.info(type);
        if (type != null) {
            status3 = null;
            if (type.equals("낮은가격")) {
                status1 = "true";
                check = "낮은가격";
            }
            if (type.equals("높은가격")) {
                status2 = "true";
                check = "높은가격";
            }
            if (type.equals("신상품")) {
                status3 = "true";
                check = "신상품";
            }
        }

        log.info("비교 들어간후---------" + type);
        HashMap<String, String> typeList = new HashMap<>();
        typeList.put("status1", status1);
        typeList.put("status2", status2);
        typeList.put("status3", status3);

        log.info("상태1" + status1 + "-----------");
        log.info("상태2" + status2 + "-----------");
        log.info("상태3" + status3 + "-----------");


        HashMap<String, Object> map = new HashMap<>();
        map.put("criteriaProduct", criteriaProduct);
        map.put("type", typeList);


        model.addAttribute("check", check);
        model.addAttribute("deliveryList", productService.getDeliveryList(map));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getDeliveryTotal(criteriaProduct)));
        model.addAttribute("getDeliveryTotal", productService.getDeliveryTotal(criteriaProduct));
    }
    //    public void proDelivery(CriteriaProduct criteriaProduct, Model model) {
//        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
//        model.addAttribute("deliveryList", productService.getDeliveryList(criteriaProduct));
//        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getDeliveryTotal(criteriaProduct)));
//        model.addAttribute("getDeliveryTotal",productService.getDeliveryTotal(criteriaProduct));
//    }
    @GetMapping("/proAddressList")
    public void proAddressList(CriteriaProduct criteriaProduct, String type,String sido,String sigungu,String dong, Model model)throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        String sellProductAddress = sido+" "+sigungu+" "+dong;

        log.info(sellProductAddress);

        log.info("/pos/getList실행");
        log.info("criteria : " + criteriaProduct.toString() + type);

        String status1 = null;
        String status2 = null;
        String status3 = "true";
        String check = null;
        log.info("비교 들어가기전---------" + type);
        log.info(type);
        if (type != null) {
            status3 = null;
            if (type.equals("낮은가격")) {
                status1 = "true";
                check = "낮은가격";
            }
            if (type.equals("높은가격")) {
                status2 = "true";
                check = "높은가격";
            }
            if (type.equals("신상품")) {
                status3 = "true";
                check = "신상품";
            }
        }

        log.info("비교 들어간후---------" + type);
        HashMap<String, String> typeList = new HashMap<>();
        typeList.put("status1", status1);
        typeList.put("status2", status2);
        typeList.put("status3", status3);

        log.info("상태1" + status1 + "-----------");
        log.info("상태2" + status2 + "-----------");
        log.info("상태3" + status3 + "-----------");


        HashMap<String, Object> map = new HashMap<>();
        map.put("criteriaProduct", criteriaProduct);
        map.put("type", typeList);
        map.put("sellProductAddress", sellProductAddress);

        log.info("맵 확인-------------------"+String.valueOf(map));


        model.addAttribute("check", check);
        model.addAttribute("proAddressListList", productService.proAddressListList(map));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotalAddressCategory(map)));
        model.addAttribute("getTotalAddressCategory", productService.getTotalAddressCategory(map));
    }
    //    public void proDelivery(CriteriaProduct criteriaProduct, Model model) {
//        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
//        model.addAttribute("deliveryList", productService.getDeliveryList(criteriaProduct));
//        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getDeliveryTotal(criteriaProduct)));
//        model.addAttribute("getDeliveryTotal",productService.getDeliveryTotal(criteriaProduct));
//    }
    @GetMapping("/proAddressListPickup")
    public void proAddressListPickup(CriteriaProduct criteriaProduct, String type,String sido,String sigungu,String dong, Model model)throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        String sellProductAddress = sido+" "+sigungu+" "+dong;

        log.info(sellProductAddress);

        log.info("/pos/getList실행");
        log.info("criteria : " + criteriaProduct.toString() + type);

        String status1 = null;
        String status2 = null;
        String status3 = "true";
        String check = null;
        log.info("비교 들어가기전---------" + type);
        log.info(type);
        if (type != null) {
            status3 = null;
            if (type.equals("낮은가격")) {
                status1 = "true";
                check = "낮은가격";
            }
            if (type.equals("높은가격")) {
                status2 = "true";
                check = "높은가격";
            }
            if (type.equals("신상품")) {
                status3 = "true";
                check = "신상품";
            }
        }

        log.info("비교 들어간후---------" + type);
        HashMap<String, String> typeList = new HashMap<>();
        typeList.put("status1", status1);
        typeList.put("status2", status2);
        typeList.put("status3", status3);

        log.info("상태1" + status1 + "-----------");
        log.info("상태2" + status2 + "-----------");
        log.info("상태3" + status3 + "-----------");


        HashMap<String, Object> map = new HashMap<>();
        map.put("criteriaProduct", criteriaProduct);
        map.put("type", typeList);
        map.put("sellProductAddress", sellProductAddress);

        log.info("맵 확인-------------------"+String.valueOf(map));


        model.addAttribute("check", check);
        model.addAttribute("proAddressListPickup", productService.proAddressListPickup(map));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotalProListPickup(map)));
        model.addAttribute("getTotalProListPickup", productService.getTotalProListPickup(map));
    }
//    public void proDelivery(CriteriaProduct criteriaProduct, Model model) {
//        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
//        model.addAttribute("deliveryList", productService.getDeliveryList(criteriaProduct));
//        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getDeliveryTotal(criteriaProduct)));
//        model.addAttribute("getDeliveryTotal",productService.getDeliveryTotal(criteriaProduct));
//    }

    @GetMapping("/proDetail")
    public void proDetail(Long sellProductNum, Model model, CriteriaProduct criteriaProduct, HttpServletRequest request){
        log.info("productDetail실행");
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());

        HttpSession session = request.getSession();

        Object userNumber = session.getAttribute("userNumber");
        log.info("userNumber" + userNumber);
        model.addAttribute("proDetail", productService.get(sellProductNum));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotal(criteriaProduct)));
        model.addAttribute("getTotal",productService.getTotal(criteriaProduct));
        model.addAttribute("userNumber", (Long) userNumber);
    }

    @GetMapping("/proNew")
    public void list(CriteriaProduct criteriaProduct, String type, Model model)throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        log.info("~!~!~!~!~!~!~!~!~!~!~!~!프로뉴들어옴------------------------------------------------------------------------------------");
        log.info("/pos/getList실행");
        log.info("criteria : " + criteriaProduct.toString() + type);

        String status1 = null;
        String status2 = null;
        String status3 = "true";
        String check = null;
        log.info("비교 들어가기전---------"+type);
        log.info(type);
        if (type != null) {
            status3 = null;
            if (type.equals("낮은가격")) {
                status1 = "true";
                check = "낮은가격";
            }
            if (type.equals("높은가격")) {
                status2 = "true";
                check = "높은가격";
            }
            if (type.equals("신상품")) {
                status3 = "true";
                check = "신상품";
            }
        }

        log.info("비교 들어간후---------"+type);
        HashMap<String, String> typeList = new HashMap<>();
        typeList.put("status1", status1);
        typeList.put("status2", status2);
        typeList.put("status3", status3);

        log.info("상태1" +status1 + "-----------");
        log.info("상태2" +status2 + "-----------");
        log.info("상태3" +status3 + "-----------");


        HashMap<String, Object> map = new HashMap<>();
        map.put("criteriaProduct", criteriaProduct);
        map.put("type", typeList);


        model.addAttribute("check", check);
        model.addAttribute("list", productService.getList(map));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotal(criteriaProduct)));
        model.addAttribute("getTotal",productService.getTotal(criteriaProduct));
    }

    @GetMapping("/proPickup")
    public void proPickup(CriteriaProduct criteriaProduct, String type, Model model)throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());

        log.info("/pos/getList실행");
        log.info("criteria : " + criteriaProduct.toString() + type);

        String status1 = null;
        String status2 = null;
        String status3 = "true";
        String check = null;
        log.info("비교 들어가기전---------" + type);
        log.info(type);
        if (type != null) {
            status3 = null;
            if (type.equals("낮은가격")) {
                status1 = "true";
                check = "낮은가격";
            }
            if (type.equals("높은가격")) {
                status2 = "true";
                check = "높은가격";
            }
            if (type.equals("신상품")) {
                status3 = "true";
                check = "신상품";
            }
        }

        log.info("비교 들어간후---------" + type);
        HashMap<String, String> typeList = new HashMap<>();
        typeList.put("status1", status1);
        typeList.put("status2", status2);
        typeList.put("status3", status3);

        log.info("상태1" + status1 + "-----------");
        log.info("상태2" + status2 + "-----------");
        log.info("상태3" + status3 + "-----------");


        HashMap<String, Object> map = new HashMap<>();
        map.put("criteriaProduct", criteriaProduct);
        map.put("type", typeList);


        model.addAttribute("check", check);
        model.addAttribute("pickupList", productService.getPickupList(map));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getPickupTotal(criteriaProduct)));
        model.addAttribute("getPickupTotal", productService.getPickupTotal(criteriaProduct));
    }

//    public void proPickup(CriteriaProduct criteriaProduct, Model model) {
//        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
//        model.addAttribute("pickupList", productService.getPickupList(criteriaProduct));
//        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getPickupTotal(criteriaProduct)));
//        model.addAttribute("getPickupTotal",productService.getPickupTotal(criteriaProduct));
//    }

    @GetMapping("/proShipping")
    public void proShipping(CriteriaProduct criteriaProduct, String type, Model model)throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());

        log.info("/pos/getList실행");
        log.info("criteria : " + criteriaProduct.toString() + type);

        String status1 = null;
        String status2 = null;
        String status3 = "true";
        String check = null;
        log.info("비교 들어가기전---------" + type);
        log.info(type);
        if (type != null) {
            status3 = null;
            if (type.equals("낮은가격")) {
                status1 = "true";
                check = "낮은가격";
            }
            if (type.equals("높은가격")) {
                status2 = "true";
                check = "높은가격";
            }
            if (type.equals("신상품")) {
                status3 = "true";
                check = "신상품";
            }
        }

        log.info("비교 들어간후---------" + type);
        HashMap<String, String> typeList = new HashMap<>();
        typeList.put("status1", status1);
        typeList.put("status2", status2);
        typeList.put("status3", status3);

        log.info("상태1" + status1 + "-----------");
        log.info("상태2" + status2 + "-----------");
        log.info("상태3" + status3 + "-----------");


        HashMap<String, Object> map = new HashMap<>();
        map.put("criteriaProduct", criteriaProduct);
        map.put("type", typeList);


        model.addAttribute("check", check);
        model.addAttribute("shippingList", productService.getShippingList(map));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getShippingTotal(criteriaProduct)));
        model.addAttribute("getShippingTotal", productService.getShippingTotal(criteriaProduct));
    }

    ///////////////////////////////
    @PostMapping("/productToBasketNew")
    public RedirectView productToBasketNew(ProductVO productVO, BasketVO basketVO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));
        log.info("```````````````````````````````````````````````````````");
        log.info("```````````````````````````````````````````````````````");
        log.info(String.valueOf(basketVO.getBasketQuantity()));
        log.info("```````````````````````````````````````````````````````");
        log.info("```````````````````````````````````````````````````````");
        productService.productToBasket(userNum,basketVO,productVO);
        return new RedirectView("proNew");
    }
    @PostMapping("/productToBasketPickup")
    public RedirectView productToBasketPickup(ProductVO productVO,BasketVO basketVO,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));
        log.info("```````````````````````````````````````````````````````");
        log.info("```````````````````````````````````````````````````````");
        log.info(String.valueOf(basketVO.getBasketQuantity()));
        log.info("```````````````````````````````````````````````````````");
        log.info("```````````````````````````````````````````````````````");
        productService.productToBasket(userNum,basketVO,productVO);
        return new RedirectView("proPickup");
    }
    @PostMapping("/productToBasketShipping")
    public RedirectView productToBasketShipping(ProductVO productVO, BasketVO basketVO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));
        log.info("```````````````````````````````````````````````````````");
        log.info("```````````````````````````````````````````````````````");
        log.info(String.valueOf(basketVO.getBasketQuantity()));
        log.info("```````````````````````````````````````````````````````");
        log.info("```````````````````````````````````````````````````````");
        productService.productToBasket(userNum,basketVO,productVO);
        return new RedirectView("proShipping");
    }

    @RequestMapping("/productToBasket")
    public RedirectView productToBasket(Long sellProductDiscountPrice, Long sellProductNum,String basketDeliveryMethod,Long basketQuantity,
                                        HttpServletRequest request) {
        BasketVO basketVO=new BasketVO();
        ProductVO productVO=new ProductVO();
        basketVO.setBasketPrice(sellProductDiscountPrice);
        productVO.setSellProductNum(sellProductNum);
        basketVO.setBasketDeliveryMethod(basketDeliveryMethod);
        basketVO.setBasketQuantity(basketQuantity);

        HttpSession session = request.getSession();
        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));

        productService.productToBasket(userNum, basketVO, productVO);
        return new RedirectView("proNew");
    }
}
