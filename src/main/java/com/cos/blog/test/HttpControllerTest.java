package com.cos.blog.test;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {
    private static final String TAG= "HttpControllerTest:";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = new Member(1, "ssar","1234","email");
        System.out.println(TAG+ "getter: " + m.getId());
        m.setId(5000);
        System.out.println(TAG+ "setter: "+m.getId());
        return "lombok test 완료";
    }

    @GetMapping("/http/get")
    public String getTest(Member m){


        return "get 요청";
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody String text){
        return "post 요청 : " + text;
    }
    @PutMapping("/http/put")
    public String putTest(){
        return "put  요청";
    }
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}
