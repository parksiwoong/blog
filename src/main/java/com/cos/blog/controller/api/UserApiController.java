package com.cos.blog.controller.api;

import com.cos.blog.controller.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.serveice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController : save호출됨");
        //실제로 DB에서 insert하고 아래에서 return이 되면 됨.
        user.setRole(RoleType.USER);
       userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //userSevice result 1 이면 성공 -1실패
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
        System.out.println("UserApiController : save호출됨");
        User principal = userService.로그인(user); // 용어 : principal (접근주체)

        if(principal != null){
            session.setAttribute("principal",principal); //널이 아니면 세션을 만들어서 principal로 받아지게
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //userSevice result 1 이면 성공 -1실패

    }
}
