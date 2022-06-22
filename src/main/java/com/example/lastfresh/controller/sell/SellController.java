package com.example.lastfresh.controller.sell;

import com.example.lastfresh.domain.dto.ImageDTO;
import com.example.lastfresh.domain.dto.PageDTO;
import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.service.owner.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sell/*")
public class SellController {
    private final OwnerService ownerService;

    @GetMapping("/pos")
    public void pos(){}

    @GetMapping("/sellMain")
    public void sellMain(Criteria criteria, Model model, HttpServletRequest request){
        log.info("sellMain실행");
        log.info("form Criteria : " + criteria.toString());

        HttpSession session = request.getSession();
        Object userNumber = session.getAttribute("userNumber");

        /*세션으로 받아올 값*/
        Long userNum = (Long)userNumber;

        if(criteria.getPageNum() == 0) {
            criteria = new Criteria(1, 10, 0);
        }

        log.info("criteria :" + criteria.toString());

        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum", userNum);
        map.put("criteria", criteria);


        model.addAttribute("list", ownerService.getListSold(map));
        PageDTO pageDTO = new PageDTO(criteria, ownerService.getTotalSold(map));
        model.addAttribute("pageDTO", pageDTO);
        log.info("pageDto.criteria: " + pageDTO.getCriteria());
        log.info("pageDto.criteria: " + pageDTO.toString());
    }

//    @GetMapping("/sellMenuList")
//    public void sellMenuList(Pageable pageable, Model model){
//        PageDTO<ProductVO> productVOs = ownerService.getProductVOs(pageable, 6L);
//        model.addAttribute("productList", productVOs);
//    }

    @GetMapping("/sellMenuList")
    public void sellMenuList(Criteria criteria,  Model model, HttpServletRequest request){
//        log.info("sellMenuList실행");
//        log.info("form Criteria : " + criteria.toString());

        HttpSession session = request.getSession();
        Object userNumber = session.getAttribute("userNumber");

        /*세션으로 받아올 값*/
        Long userNum = (Long)userNumber;

        if(criteria.getPageNum() == 0) {
            criteria = new Criteria(1, 10, 0);
        }

        log.info("criteria :" + criteria.toString());

//        criteria = new Criteria(criteria.getPageNum(), criteria.getAmount());
//        criteria.setUserNum(userNum);

        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum", userNum);
        map.put("criteria", criteria);


        model.addAttribute("list", ownerService.getList(map));
        PageDTO pageDTO = new PageDTO(criteria, ownerService.getTotal(map));
        model.addAttribute("pageDTO", pageDTO);
        log.info("pageDto.criteria: " + pageDTO.getCriteria());
    }

    @GetMapping("/sellMenuRegister")
    public void register() {
    }

    @PostMapping("/sellMenuRegister")
    public RedirectView register(ProductVO productVO, HttpServletRequest request){
        log.info("-----------------------------------------------------");
        log.info("등록 들어옴");
        log.info("ProductVO : " + productVO);
        log.info("-----------------------------------------------------");

        HttpSession session = request.getSession();
        Object userNumber = session.getAttribute("userNumber");

        /*세션으로 받아올 값*/
        Long userNum = (Long)userNumber;

//        HttpSession session = request.getSession();
//        session.setAttribute();
//        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNum")));

        ownerService.register(productVO, userNum);

        return new RedirectView("sellMenuList");
    }

    @PostMapping("/remove")
    public RedirectView remove (Long sellProductNum, Criteria criteria, RedirectAttributes rttr) {
        log.info("삭제-------------------------------------------------------------");
        log.info("sellProductNum : " + sellProductNum);

        String result = null;

        if (ownerService.deleteProductMenu(sellProductNum)) {
            result = "삭제에 성공하셨습니다.";
        } else {
            result = "삭제에 실패하였습니다.";
        }

        rttr.addFlashAttribute("result", result);
        rttr.addAttribute("pageNum", criteria.getPageNum());
        rttr.addAttribute("amount", criteria.getAmount());
        rttr.addAttribute("limit", criteria.getLimit());

        return new RedirectView("sellMenuList");
    }

    @PostMapping("/sellMenuRegisterModify")
    public RedirectView modify(ProductVO productVO, ProductDTO productDTO, Criteria criteria, RedirectAttributes rttr) {
        log.info("업데이트-------------------------------------------------------------");
        log.info("넘어옴 formData : " + productVO.toString());

        ownerService.modify(productVO);

        rttr.addAttribute("pageNum", criteria.getPageNum());
        rttr.addAttribute("amount", criteria.getAmount());
        rttr.addAttribute("limit", criteria.getLimit());
        return new RedirectView("sellMenuList");
    }

    @GetMapping("/sellMenuRegisterModify")
    public void modify (Long sellProductNum, Criteria criteria, Model model) {
        log.info("------------------------------------------");
        log.info("상품 정보 By sellProductNum :" + ownerService.getListAllBysSllProductNum(sellProductNum).toString());
        log.info("------------------------------------------");
        model.addAttribute("list", ownerService.getListAllBysSllProductNum(sellProductNum));
        model.addAttribute("criteria", criteria);
    }

    @PostMapping("/modify")
    public RedirectView modify (Long sellProductNum, Criteria criteria, RedirectAttributes rttr) {

        rttr.addAttribute("sellProductNum", sellProductNum);
        rttr.addAttribute("pageNum", criteria.getPageNum());
        rttr.addAttribute("amount", criteria.getAmount());
        return new RedirectView("sellMenuRegisterModify");
    }

//    @PostMapping("/menuDeleteAjax")
//    public RedirectView remove(Long sellProductNum) {
//        ownerService.deleteProductMenu(sellProductNum);
//        return new RedirectView("sellMenuList");
//    }


    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public ImageDTO uploadAjaxPost(MultipartFile[] uploadFile) throws IOException {
        String uploadFolder = "C:/upload";
//        UUID(Universally unique identifier) : 범용 고유 식별자
//        네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//        중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
//        UUID의 개수는 10의 38승입니다.

        String uploadFolderPath = this.getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }

        UUID uuid = UUID.randomUUID();
        String uploadFileName1 = uuid.toString() + "_" + uploadFile[0].getOriginalFilename();
        String uploadFileName2 = uuid.toString() + "_" + uploadFile[1].getOriginalFilename();

        ImageDTO imgDTO = new ImageDTO();
        imgDTO.setSellProductThumbnail(uploadFileName1);
        imgDTO.setSellProductImage(uploadFileName2);
        imgDTO.setSellProductImageUuid(uuid.toString());
        imgDTO.setSellProductImageUploadPath(uploadFolderPath);
        log.info(imgDTO.toString());

        //저장할 경로와 파일의 이름을 File객체에 담는다.
        File saveFile1 = new File(uploadPath, uploadFileName1);
        File saveFile2 = new File(uploadPath, uploadFileName2);

        try {
            //설정한 경로에 해당 파일을 업로드한다.
            uploadFile[0].transferTo(saveFile1);
            uploadFile[1].transferTo(saveFile2);
            return imgDTO;

        } catch (IOException e) {
            log.error(e.getMessage());
            throw new IOException("서버 오류입니다. 다시 시도해주세요.");
        }
    }

//    @PostMapping("/upload_ok3")
//    public String upload3(@RequestParam("file") List<MultipartFile> list) {
//
//        return "fileupload/upload_ok";
//    }

    private String getPath(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }
}
