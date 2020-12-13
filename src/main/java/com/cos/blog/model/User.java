package com.cos.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity //User클래스가 MySQL에 테이블이 생성된다. //테이블화시킬땐 엔티티
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 프로젝트에서 연결된  DB의 넘버링전략을 따라간다.
    private int id; // 오라클 - 시퀀스 , mysql - auto_increment

    @Column(nullable = false, length = 20)
    private String username; //유저이름은 널이 되면 안되니

    @Column(nullable = false, length = 128) //1234 =>해쉬
    private String password;

    @Column(nullable = false,length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; // Enum을 쓰는게 좋다. //admin, user, manger 각자 권한 주는애들 주려고 만든거



    @CreationTimestamp //시간이 자동 입력
    private Timestamp createDate;

}
