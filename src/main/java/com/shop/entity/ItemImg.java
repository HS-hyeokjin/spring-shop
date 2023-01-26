package com.shop.entity;

import groovy.transform.TypeChecked;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="item_img")
@Getter@Setter

public class ItemImg extends BaseEntity {

    @Id
    @Column(name= "item_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String imgName;

    private String oriImgName;  //이미지 원본 파일 명

    private String imgUrl; //이미지 경로

    private String repimgYn; //대표 이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
