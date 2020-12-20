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

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController : save호출됨");
        //실제로 DB에서 insert하고 아래에서 return이 되면 됨.
        user.setRole(RoleType.USER);
       int result = userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK, result); //userSevice result 1 이면 성공 -1실패
    }
}
