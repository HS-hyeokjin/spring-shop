package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

//JpaRepository 제네릭 타입 첫번째 엔티티 타입 클래스, 두번째 기본키 타입


public interface ItemRepository extends JpaRepository<Item, Long> {


    //Query 어노테이션 안에 JPQL 쿼리문 넣어줌. from 뒤에는 엔티티 클래스로 작성한 item을 지정했고, item으로부터 데이터를 select 한다.
    //@Query("select i from Item i where i.itemDetail like%:itemDetail% order by i.price desc")
    //쿼리 메소드 : find + (엔티티이름) + By + 변수이름
    //itemNm(상품명)으로 데이터를 조회 하기 위해 Nm 뒤에 필드명 itemNm을 붙힘
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    //파라미터에 @Param 어노테이션을 이용하여 파라미터로 넘어온 값을 JPQL에 들어갈 변수로 지정해준다
    //현재는 itemDetail 변수를 "like & &" 사이에 ":itemDetail"로 값이 들어가도록 작성
    //List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

}
