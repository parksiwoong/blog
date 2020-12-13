package com.cos.blog.test;

import lombok.*;

//@Getter
//@Setter
@Data
//@RequiredArgsConstructor      //파이널에 붙은 애들에 대한 컨스트럭트를 만들어줌
@NoArgsConstructor      //빈생성자
//@AllArgsConstructor //모든페이지를 다쓰는 생성자를 만들고싶으면
public class Member {
    private int id;
    private  String username;
    private String password;
    private String email;

    @Builder //객체를 만들고싶을때 자동으로 증가하는 시퀀스가 되고싶은데 데이터베이스에 넣고싶을때 오버로딩 변수수가 안맞을때
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;

        //예) Member m = Member.builder().username("ssar).password("1234").email("ssar@naver.com").build();
    }


}
