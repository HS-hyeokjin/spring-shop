package com.shop.repository;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest      //통합테스트를 위해 springboot에서 제공
@TestPropertySource(locations="classpath:application-test.properties") //h2db를 쓰기 위해 위선순의 향상
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;
    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        //테스트를 위해 10개의 상품 저장
        for(int i=1;i<=10;i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setITemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
        }
    }
    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmOrItemDetail(){
        this.createItemTest();
        //ItemRepository 인터페이스에 작석했던 findByItemNm 메소드 호출 파라미터 "테스트상품 1"
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1","테스트 상품 상세 설명5");
        for(Item item : itemList){
            System.out.println(item.toString()); //조회 결과 출력
        }
    }

}