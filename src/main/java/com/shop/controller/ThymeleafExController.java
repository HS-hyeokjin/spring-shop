package com.shop.controller;

import com.shop.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shop.dto.ItemDto;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafExController {
    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model) {
        //model 객체를 이용해 뷰에 전달할 데이터를 key,value 구조로 넣어줌
        model.addAttribute("data", "타임리프 예제");
        return "thymeleafEx/thymeleafEx01";
    }

    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품상세설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(1000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto",itemDto);
        return "thymeleafEx/thymeleafEx02";
    }
}
