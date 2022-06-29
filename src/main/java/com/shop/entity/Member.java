package com.shop.entity;

import com.shop.constant.Role;
import com.shop.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter @Setter
@ToString

public class Member {

    @Id
    @Column(name="meber_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)        //같은 이메일이 없도록 유니크 지정
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)    //enum 타입을 엔티티의 속성으로 지정 및 String 으로 저장
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        //Member 엔티티를 생성하는 메소드. 메소드를 생성해서 관리하면 코드가 변경되도 한군데만 수정하면 됨
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        String password = passwordEncoder.encode(memberFormDto.getPassword());         //비밀번호 암호화
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;

    }
}
