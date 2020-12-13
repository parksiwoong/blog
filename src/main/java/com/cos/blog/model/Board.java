package com.cos.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob // 대용량데이터때 쓰는거
    private String content; //섬머노트 라이브러리<html>태그가 섞여서 디자인됨.


    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne //연관관계가 없기때문에 이걸로 관계를 만들어주는거, 원은 유저 //Many=Board,User=One //
    @JoinColumn(name="userId")
    private User user;  //DB는 오브젝트를 저장할 수 없다. FK,자바는 오브젝트를 저장할 수 있다.


    @CreationTimestamp //시간이 자동 입력
    private Timestamp createDate;
}
